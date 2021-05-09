package practice;

import java.util.ArrayList;

public class Programmer extends Employee {
	private ArrayList<String> programmingLanguage;

	public Programmer() {
		super();
	}

	public Programmer(String name, String address, int age, String phone, ArrayList<String> programmingLanguage) {
		super(name, address, age, phone);
		this.programmingLanguage = programmingLanguage;
	}

	@Override
	public void work() {
		System.out.println("I am coding...");
	}

	@Override
	public String toString() {
		return "Programmer [programmingLanguage=" + programmingLanguage + ", getName()=" + getName() + ", getAddress()="
				+ getAddress() + ", getAge()=" + getAge() + ", getPhone()=" + getPhone() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
