package entities;

import java.io.Serializable;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1946874444875098154L;
	private static int rootId = 1;
	private int id;
	private String fullName;
	private String address;
	private String phone;
	private double amountAfter;
	private double discountPercent;
	private double taxPercent;

	public Customer() {
		this.id = rootId++;
	}
	
	public Customer(int id) {
		this.id = id;
	}

	public Customer(String fullName, String address, String phone, double amountAfter, double discountPercent,
			double taxPercent) {
		this.id = rootId++;
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
		this.amountAfter = amountAfter;
		this.discountPercent = discountPercent;
		this.taxPercent = taxPercent;
	}

	public Customer(int id, String fullName, String address, String phone, double amountAfter, double discountPercent,
			double taxPercent) {
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
		this.amountAfter = amountAfter;
		this.discountPercent = discountPercent;
		this.taxPercent = taxPercent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getAmountAfter() {
		return amountAfter;
	}

	public void setAmountAfter(double amountAfter) {
		this.amountAfter = amountAfter;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public double getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(double taxPercent) {
		this.taxPercent = taxPercent;
	}
	
	public double calculateTheAmount() {
		return this.amountAfter * (1 + this.taxPercent / 100 - this.discountPercent / 100);
	}

	@Override
	public String toString() {
		return id + "|" + fullName + "|" + address + "|" + phone + "|" + amountAfter + "|" + discountPercent + "|"
				+ taxPercent + "\n";
	}

	public static void main(String[] args) {
		Customer a = new Customer("CHAU NGOC LONG", "QUANG NINH", "0399898559", 100, 100, 0);
		System.out.println(a.toString());
	}
}
