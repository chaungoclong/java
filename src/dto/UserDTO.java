package dto;

public class UserDTO {
	private int id;

	private String avatar;

	private String email;

	private String name;

	private String phone;

	public UserDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", avatar=" + avatar + ", email=" + email + ", name=" + name + ", phone=" + phone
				+ "]";
	}

}
