package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import entities.Customer;
import helpers.CustomerIO;

public class CustomerDaoImpl implements CustomerDao {
	private static final String FILEPATH = "customer.txt";
	private List<Customer> list_customers = new ArrayList<Customer>();

	public CustomerDaoImpl() {
		this.list_customers = CustomerIO.getList("customer.txt");
		System.out.println(this.list_customers.size());
	}

	@Override
	public boolean addCustomer(Customer customer) {
		this.list_customers.add(customer);
		return this.save();
	}

	@Override
	public List<Customer> getAllCustomer() {
		return this.list_customers;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		int id = customer.getId();
		int rollNo = this.findRollNoById(id);

		if (rollNo != -1) {
			this.list_customers.remove(rollNo);
			if (this.save()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		int id = customer.getId();
		int rollNo = this.findRollNoById(id);

		if (rollNo != -1) {
			this.list_customers.set(rollNo, customer);
			if (this.save()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int findRollNoById(int id) {
		for (int i = 0; i < this.list_customers.size(); ++i) {
			if (this.list_customers.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean save() {
		return CustomerIO.save(FILEPATH, list_customers, false);
	}

	@Override
	public String toString() {
		return "CustomerDaoImpl [list_customers=" + list_customers + "]";
	}

	@Override
	public int lastId() {
		return this.list_customers.size();
	}
}
