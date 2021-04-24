package studentManagement;

abstract class Person {
	private String name;
	private int age;
	private int gender;
	private String address;
	private String phoneNumber;
	

	public Person() {
	}

	public Person(String name, int age, int gender,String address, String phoneNumber) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

}
