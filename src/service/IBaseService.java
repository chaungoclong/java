package service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IBaseService<T> {
	// get all
	public List<T> all();

	// select
	public List<T> select(String rawSql, Object... params);

	// find
	public T find(Object id);

	public T find(String rawSql, Object... params);

	// first
	public T first();

	// last
	public T last();

	// create
	public boolean create(T entity);

	// update
	public boolean update(T entity);

	public boolean update(Map<String, Object> setData, String rawSql, Object... params);

	// delete by id
	public boolean delete(Object id);

	public boolean delete(String rawSql, Object... params);

	// count
	public long count(String column);

	// count
	public long count(String column, String rawSql, Object... params);

	// paginate
	public List<T> paginate(HttpServletRequest request, int rowPerPage, String rawSql, Object... params);

	// paginate
	public List<T> paginate(HttpServletRequest request, int rowPerPage);
}
