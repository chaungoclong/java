package model;

public class Reader {
	private static long ID = 10000000;
	private long readerID;
	private String fullName;
	private String address;
	private String phoneNumber;
	
	public Reader(String fullName, String address, String phoneNumber) {
		this.readerID = ID++;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public static long getID() {
		return ID;
	}

	public static void setID(long iD) {
		ID = iD;
	}

	public long getReaderID() {
		return readerID;
	}

	public void setReaderID(long readerID) {
		this.readerID = readerID;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
