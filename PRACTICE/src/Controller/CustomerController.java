package Controller;

import java.util.List;
import java.util.Scanner;

import dao.CustomerDao;
import daoImpl.CustomerDaoImpl;
import entities.Customer;
import helpers.NumberHelper;

public class CustomerController {
	private CustomerDao model;
	private Scanner in;

	public CustomerController() {
		this.model = new CustomerDaoImpl();
		this.in = new Scanner(System.in);
	}

	// add customer
	public void addCustomer() {
		System.out.println("____________THÊM KHÁCH HÀNG_____________");

		int id = this.model.lastId() + 1;
		String fullName = this.inputName();
		String address = this.inputAddress();
		String phone = this.inputPhone();
		double amountAfter = this.inputAmount();
		double discountPercent = this.inputDiscount();
		double taxPercent = this.inputTax();

		Customer customer = new Customer(id, fullName, address, phone, amountAfter, discountPercent, taxPercent);
		if (this.model.addCustomer(customer)) {
			System.out.println("<Thêm khách hàng thành công>");
		} else {
			System.out.println("<Thêm khách hàng không thành công>");
		}
	}

	// delete customer
	public void deleteCustomer() {
		System.out.println("____________XÓA KHÁCH HÀNG_____________");

		int id = this.inputId();
		Customer customer = new Customer(id);
		if (this.model.deleteCustomer(customer)) {
			System.out.println("<Xóa Khách hàng thành công>");
		} else {
			System.out.println("<Xóa Khách hàng không thành công>");
		}
	}

	// update customer
	public void updateCustomer() {
		System.out.println("____________SỬA KHÁCH HÀNG_____________");

		int id = this.inputId();
		String fullName = this.inputName();
		String address = this.inputAddress();
		String phone = this.inputPhone();
		double amountAfter = this.inputAmount();
		double discountPercent = this.inputDiscount();
		double taxPercent = this.inputTax();

		Customer customer = new Customer(id, fullName, address, phone, amountAfter, discountPercent, taxPercent);
		if (this.model.updateCustomer(customer)) {
			System.out.println("<Sửa Khách hàng thành công>");
		} else {
			System.out.println("<Sửa Khách hàng không thành công>");
		}
	}

	// display all customer
	public void displayCustomer() {
		System.out.println("____________DANH SÁCH KHÁCH HÀNG_____________");

		List<Customer> list_customer = this.model.getAllCustomer();

		for (Customer customer : list_customer) {
			System.out.println("ID:" + customer.getId() + " |" + "FullName:" + customer.getFullName() + " |" + "Address:" + customer.getAddress() + " |"
					+ "Phone:" + customer.getPhone() + " |" + "Amount After:" + customer.getAmountAfter() + " |"
					+ "Discount Percent:" + customer.getDiscountPercent() + " |" + "Tax Percent:"
					+ customer.getTaxPercent());
		}
		
		System.out.println("\n\n\n");
	}

	// display order
	public void displayOrder() {
		System.out.println("____________DANH SÁCH HÓA ĐƠN_____________");

		List<Customer> list_customer = this.model.getAllCustomer();

		for (Customer customer : list_customer) {
			System.out.println("FullName:" + customer.getFullName() + " |" + "Address:" + customer.getAddress() + " |"
					+ "Phone:" + customer.getPhone() + " |" + "Amount After:" + customer.getAmountAfter() + " |"
					+ "Discount Percent:" + customer.getDiscountPercent() + " |" + "Tax Percent:"
					+ customer.getTaxPercent() + " |" + "Actual Amount:" + customer.calculateTheAmount());
		}
		System.out.println("\n\n\n");
	}

	// input id
	public int inputId() {
		System.out.println("Nhập ID của Khách hàng:");
		while (true) {
			try {
				int id = Integer.parseInt(in.nextLine());
				return id;
			} catch (Exception e) {
				System.out.println("ID của Khách hàng phải là số nguyên:");
				System.out.println("Nhập lại ID của Khách hàng:");
			}
		}
	}

	// input name
	public String inputName() {
		System.out.println("Tên Khách hàng:");
		while (true) {
			String name = in.nextLine();
			if (!NumberHelper.isNumeric(name) && name.length() > 0) {
				return name;
			}

			System.out.println("Tên khách không được là số và không được trống");
			System.out.println("Nhập lại Tên khách hàng:");
		}
	}

	// input address
	public String inputAddress() {
		System.out.println("Địa chỉ Khách hàng:");
		while (true) {
			String address = in.nextLine();
			if (address.length() > 0) {
				return address;
			}

			System.out.println("Địa chỉ Khách hàng không được trống");
			System.out.println("Nhập lại điạ chỉ Khách hàng:");
		}
	}

	// input phone
	public String inputPhone() {
		System.out.println("Nhập số điện thoại khách hàng:");
		while (true) {
			String phone = in.nextLine();
			if (NumberHelper.isNumeric(phone) && phone.length() == 10) {
				return phone;
			}

			System.out.println("Số điện thoại Khách hàng phải là số và có độ dài 10 chữ số");
			System.out.println("Nhập lại số điện thoại Khách hàng:");
		}
	}

	// input amount
	public double inputAmount() {
		System.out.println("Nhập tổng tiền tạm thời");
		while (true) {
			try {
				Double amount = Double.parseDouble(in.nextLine());
				return amount;
			} catch (Exception e) {
				System.out.println("Tổng tiền tạm thời phải là số");
				System.out.println("Nhập lại tổng tiền tạm thời:");
			}
		}
	}

	// input discount
	public double inputDiscount() {
		System.out.println("Nhập phần trăm giảm giá");
		while (true) {
			try {
				Double discount = Double.parseDouble(in.nextLine());
				return discount;
			} catch (Exception e) {
				System.out.println("phần trăm giảm giá phải là số");
				System.out.println("Nhập lại phần trăm giảm giá:");
			}
		}
	}

	// input tax
	public double inputTax() {
		System.out.println("Nhập thuế");
		while (true) {
			try {
				Double tax = Double.parseDouble(in.nextLine());
				return tax;
			} catch (Exception e) {
				System.out.println("Thuế phải là số");
				System.out.println("Nhập lại thuế:");
			}
		}
	}

	public static void main(String[] args) {
		CustomerController p = new CustomerController();
		p.addCustomer();
		p.displayCustomer();
	}
}
