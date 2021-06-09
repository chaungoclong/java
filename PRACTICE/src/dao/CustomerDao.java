package dao;

import java.util.List;

import entities.Customer;

public interface CustomerDao {
	public boolean addCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public boolean deleteCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public int findRollNoById(int id);
	public int lastId();
	public boolean save();
}
