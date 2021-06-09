package app;

import java.util.Scanner;

import Controller.CustomerController;

public class Application {
	private Scanner in = new Scanner(System.in);
	private CustomerController controller = new CustomerController();
	
	public void start() {
		while (true) {
			int action = this.menu();
			switch (action) {
			case 0:
				System.out.println("Thank You");
				System.exit(0);
				break;
				
			case 2:
				this.controller.addCustomer();
				break;
				
			case 3:
				this.controller.updateCustomer();
				break;
				
			case 4:
				this.controller.deleteCustomer();
				break;
				
			case 5:
				this.controller.displayOrder();
				break;
				
			case 1:
			default:
				this.controller.displayCustomer();
				break;
			}
		}
	}

	public int menu() {
		System.out.println("____________MENU____________");
		System.out.println("1-DANH SÁCH KHÁCH HÀNG");
		System.out.println("2-THÊM KHÁCH HÀNG");
		System.out.println("3-SỬA KHÁCH HÀNG");
		System.out.println("4-XÓA KHÁCH HÀNG");
		System.out.println("5-DANH SÁCH HÓA ĐƠN");
		System.out.println("0-THOÁT");
		
		int choice = this.select();
		return choice;
	}

	public int select() {
		System.out.println("Nhập lựa chọn của bạn:");
		
		while (true) {
			try {
				int choice = Integer.parseInt(in.nextLine());
				if (choice < 0 || choice > 5) {
					throw new Exception();
				}
				return choice;
			} catch (Exception e) {
				System.out.println("Lựa chọn phải là số từ 0 - 5");
				System.out.println("Nhập lại lựa chọn");
			}
		}
	}
}
