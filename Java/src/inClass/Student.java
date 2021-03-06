package inClass;

public class Student {
	private static int RootID = 0;
	private int ID;
	private String name;
	private float C;
	private float PHP;
	private float markAVG;
	private String rank;
	
	public Student(String name, float C, float PHP) {
		this.setID(++RootID);;
		this.setName(name);
		this.setC(C);
		this.setPHP(PHP);
		this.setMarkAVG();
		this.setRank();
	}

	public Student() {
		this.setID(++RootID);;
		this.setName("");
		this.setC(0);
		this.setPHP(0);
		this.setMarkAVG();
		this.setRank();
	}

	public static int getRootID() {
		return RootID;
	}

	public static void setRootID(int rootID) {
		RootID = rootID;
	}

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getC() {
		return this.C;
	}

	public void setC(float C) {
		this.C = C;
	}

	public float getPHP() {
		return this.PHP;
	}

	public void setPHP(float PHP) {
		this.PHP = PHP;
	}

	public float getMarkAVG() {
		return this.markAVG;
	}

	public void setMarkAVG() {
		this.markAVG = (this.C + this.PHP) / 2;
	}

	public String getRank() {
		return this.rank;
	}

	public void setRank() {
		if (this.markAVG >= 8) {
			this.rank = "GIOI";
		} else if (this.markAVG >= 6) {
			this.rank = "KHA";
		} else if(this.markAVG >= 5) {
			this.rank = "TRUNG BINH";
		} else {
			this.rank = "KHONG DAT";
		}
	}
	
	//show info
	public void showInfo() {
		System.out.println(
				"ID:" + this.ID 
				+ "\nClass Name:" + this.name 
				+ "\nC:" + this.C 
				+ "\nPHP:" + this.PHP 
				+ "\nAVG:" + this.markAVG
				+ "\nRank:" + this.rank
				+ "\n");
	}
}
