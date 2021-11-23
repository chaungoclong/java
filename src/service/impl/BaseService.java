package service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.impl.BaseDAO;
import service.IBaseService;

public class BaseService<T> implements IBaseService<T> {
	protected BaseDAO<T> dao;

	@Override
	public List<T> all() {
		// TODO Auto-generated method stub
		return this.dao.all();
	}

	@Override
	public List<T> select(String rawSql, Object... params) {
		// TODO Auto-generated method stub
		return this.dao.select(rawSql, params);
	}

	@Override
	public T find(Object id) {
		// TODO Auto-generated method stub
		return this.dao.find(id);
	}

	@Override
	public T find(String rawSql, Object... params) {
		// TODO Auto-generated method stub
		return this.dao.find(rawSql, params);
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return this.dao.first();
	}

	@Override
	public T last() {
		// TODO Auto-generated method stub
		return this.dao.last();
	}

	@Override
	public boolean create(T entity) {
		// TODO Auto-generated method stub
		return this.dao.create(entity);
	}

	@Override
	public boolean update(T entity) {
		// TODO Auto-generated method stub
		return this.dao.update(entity);
	}

	@Override
	public boolean update(Map<String, Object> setData, String rawSql, Object... params) {
		// TODO Auto-generated method stub
		return this.dao.update(setData, rawSql, params);
	}

	@Override
	public boolean delete(Object id) {
		// TODO Auto-generated method stub
		return this.dao.delete(id);
	}

	@Override
	public boolean delete(String rawSql, Object... params) {
		// TODO Auto-generated method stub
		return this.dao.delete(rawSql, params);
	}

	@Override
	public long count(String column) {
		// TODO Auto-generated method stub
		return this.dao.count(column);
	}

	@Override
	public long count(String column, String rawSql, Object... params) {
		// TODO Auto-generated method stub
		return this.dao.count(column, rawSql, params);
	}

	@Override
	public List<T> paginate(HttpServletRequest request, int rowPerPage, String rawSql, Object... params) {
		// TODO Auto-generated method stub
		return this.dao.paginate(request, rowPerPage, rawSql, params);
	}

	@Override
	public List<T> paginate(HttpServletRequest request, int rowPerPage) {
		// TODO Auto-generated method stub
		return this.dao.paginate(request, rowPerPage);
	}

}
