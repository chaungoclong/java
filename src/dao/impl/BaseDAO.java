package dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import dao.IBaseDAO;
import util.JPAUtil;
import util.QueryBuilder;

public abstract class BaseDAO<T> implements IBaseDAO<T> {
	protected Class<T> clazz;
	protected String entityTable;
	protected String table;
	protected EntityManager entityManager;
	protected EntityTransaction entityTransaction;

	public void init(Class<T> clazz, String table) {
		this.clazz = clazz;
		this.entityTable = clazz.getSimpleName();
		this.table = table;
	}

	public void open() {
		try {
			if (this.entityManager == null || !entityManager.isOpen()) {
				this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
				this.entityTransaction = this.entityManager.getTransaction();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (this.entityManager != null && this.entityManager.isOpen()) {
				this.entityManager.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<T> all() {
		List<T> results = new ArrayList<T>();

		this.open();

		try {
			this.entityTransaction.begin();

			String sql = "SELECT t FROM " + this.entityTable + " t";
			TypedQuery<T> query = this.entityManager.createQuery(sql, this.clazz);
			results = query.getResultList();

			this.entityTransaction.commit();
		} catch (Exception e) {
			results = null;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return results;
	}

	@Override
	public T find(Object id) {
		T entity = null;

		this.open();

		try {
			this.entityTransaction.begin();

			entity = this.entityManager.find(this.clazz, id);

			this.entityTransaction.commit();
		} catch (Exception e) {
			entity = null;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return entity;
	}

	@Override
	public T first() {
		T entity = null;

		this.open();

		try {
			this.entityTransaction.begin();

			String sql = "SELECT t FROM " + this.entityTable + " t";
			TypedQuery<T> query = this.entityManager.createQuery(sql, this.clazz);
			entity = query.setMaxResults(1).getSingleResult();

			this.entityTransaction.commit();
		} catch (Exception e) {
			entity = null;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return entity;
	}

	@Override
	public T last() {
		T entity = null;

		this.open();

		try {
			this.entityTransaction.begin();

			String sql = "SELECT t FROM " + this.entityTable + " t ORDER BY t.id DESC";
			TypedQuery<T> query = this.entityManager.createQuery(sql, this.clazz);
			entity = query.setMaxResults(1).getSingleResult();

			this.entityTransaction.commit();
		} catch (Exception e) {
			entity = null;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return entity;
	}

	@Override
	public boolean create(T entity) {
		boolean status = false;

		this.open();

		try {
			this.entityTransaction.begin();

			this.entityManager.persist(entity);

			this.entityTransaction.commit();

			status = true;
		} catch (Exception e) {
			this.entityTransaction.rollback();
			status = false;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return status;
	}

	@Override
	public boolean update(T entity) {
		boolean status = false;

		this.open();

		try {
			this.entityTransaction.begin();

			this.entityManager.merge(entity);

			this.entityTransaction.commit();

			status = true;
		} catch (Exception e) {
			this.entityTransaction.rollback();
			status = false;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return status;
	}

	@Override
	public boolean delete(Object id) {
		boolean status = false;

		this.open();

		try {
			this.entityTransaction.begin();

			T entity = this.entityManager.find(clazz, id);
			if (entity != null) {
				this.entityManager.remove(entity);
				status = true;
			}

			this.entityTransaction.commit();
		} catch (Exception e) {
			this.entityTransaction.rollback();
			status = false;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return status;
	}

	@Override
	public long count(String column) {
		// TODO Auto-generated method stub
		return this.count(column, null);
	}

	@Override
	public long count(String column, String rawSql, Object... params) {
		long result = 0;

		column = (column == null || column.isEmpty()) ? "*" : column;
		rawSql = (rawSql == null || rawSql.isEmpty()) ? "" : rawSql;

		this.open();

		try {
			this.entityTransaction.begin();

			String sql = "SELECT COUNT(" + column + ") FROM " + this.table + " " + rawSql;
			Query query = this.entityManager.createNativeQuery(sql);

			int i = 1;
			for (Object param : params) {
				query.setParameter(i++, param);
			}

			result = Long.parseLong(String.valueOf(query.setMaxResults(1).getSingleResult()));

			this.entityTransaction.commit();
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> paginate(HttpServletRequest request, int rowPerPage, String rawSql, Object... params) {
		List<T> results = new ArrayList<T>();

		String currentPageParam = request.getParameter("page");
		int currentPage = 1;

		if (currentPageParam != null) {
			try {
				currentPage = Integer.parseInt(currentPageParam);
			} catch (Exception e) {
				currentPage = 1;
			}
		}

		int offset = (currentPage - 1) * rowPerPage;

		// set info pagination
		rawSql = (rawSql == null || rawSql.isEmpty()) ? "" : rawSql;

		long totalRows = this.count("*", rawSql, params);
		int totalPages = (int) Math.ceil((double) totalRows / rowPerPage);
		String currentUrl = request.getRequestURL().toString();

		request.setAttribute("_paginateCurrentPage", currentPage);
		request.setAttribute("_paginateCurrentUrl", currentUrl);
		request.setAttribute("_paginateTotalPages", totalPages);

		// get result
		this.open();

		try {
			this.entityTransaction.begin();

			String sql = "SELECT * FROM " + this.table + " " + rawSql;
			Query query = this.entityManager.createNativeQuery(sql, this.clazz);

			int i = 1;
			for (Object param : params) {
				query.setParameter(i++, param);
			}

			results = (List<T>) query.setFirstResult(offset).setMaxResults(rowPerPage).getResultList();

			this.entityTransaction.commit();

		} catch (Exception e) {
			results = null;
		} finally {
			this.close();
		}

		return results;
	}

	@Override
	public List<T> paginate(HttpServletRequest request, int rowPerPage) {
		return this.paginate(request, rowPerPage, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> select(String rawSql, Object... params) {
		List<T> results = new ArrayList<T>();

		this.open();

		try {
			this.entityTransaction.begin();

			rawSql = (rawSql == null || rawSql.isEmpty()) ? "" : rawSql;

			String sql = QueryBuilder.select("*").from(this.table).rawSql(rawSql).render();
			System.out.println(sql);
			Query query = this.entityManager.createNativeQuery(sql, this.clazz);

			int i = 1;
			for (Object param : params) {
				query.setParameter(i++, param);
			}

			results = (List<T>) query.getResultList();

			this.entityTransaction.commit();
		} catch (Exception e) {
			results = null;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(String rawSql, Object... params) {
		T result = null;

		this.open();

		try {
			this.entityTransaction.begin();

			rawSql = (rawSql == null || rawSql.isEmpty()) ? "" : rawSql;

			String sql = QueryBuilder.select("*").from(this.table).rawSql(rawSql).render();
			System.out.println(sql);
			Query query = this.entityManager.createNativeQuery(sql, this.clazz);

			int i = 1;
			for (Object param : params) {
				query.setParameter(i++, param);
			}

			result = (T) query.setMaxResults(1).getSingleResult();

			this.entityTransaction.commit();
		} catch (Exception e) {
			result = null;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return result;
	}

	@Override
	public boolean update(Map<String, Object> setData, String rawSql, Object... params) {
		boolean status = false;

		this.open();

		try {
			this.entityTransaction.begin();

			rawSql = (rawSql == null || rawSql.isEmpty()) ? "" : rawSql;

			String sql = QueryBuilder.updateSet(this.table, setData).rawSql(rawSql).render();
			System.out.println(sql);
			Query query = this.entityManager.createNativeQuery(sql);

			int i = 1;

			// bind value for column
			for (Object data : setData.values()) {
				query.setParameter(i++, data);
			}

			// bind value for rawSql
			for (Object param : params) {
				query.setParameter(i++, param);
			}

			if (query.executeUpdate() > 0) {
				status = true;
			}

			this.entityTransaction.commit();
		} catch (Exception e) {
			this.entityTransaction.rollback();
			status = false;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return status;
	}

	@Override
	public boolean delete(String rawSql, Object... params) {
		boolean status = false;

		this.open();

		try {
			this.entityTransaction.begin();

			rawSql = (rawSql == null || rawSql.isEmpty()) ? "" : rawSql;

			String sql = QueryBuilder.deleteFrom(this.table).rawSql(rawSql).render();
			System.out.println(sql);
			Query query = this.entityManager.createNativeQuery(sql);

			int i = 1;
			for (Object param : params) {
				query.setParameter(i++, param);
			}

			if (query.executeUpdate() > 0) {
				status = true;
			}

			this.entityTransaction.commit();
		} catch (Exception e) {
			this.entityTransaction.rollback();
			status = false;
			e.printStackTrace();
		} finally {
			this.close();
		}

		return status;
	}

}
