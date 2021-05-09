package practice;

public abstract class Employee {
	private String name;
	private String address;
	private int age;
	private String phone;

	public Employee() {

	}

	public Employee(String name, String address, int age, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", age=" + age + ", phone=" + phone + ", getName()="
				+ getName() + ", getAddress()=" + getAddress() + ", getAge()=" + getAge() + ", getPhone()=" + getPhone()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public abstract void work();
}
