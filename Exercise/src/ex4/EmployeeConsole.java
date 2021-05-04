package ex4;

import java.util.Scanner;
import java.util.List;

public class EmployeeConsole {
	private Scanner in = new Scanner(System.in);
	private EmployeeManager manager = new EmployeeManager();

	public EmployeeConsole() {

	}

	public int menu() {
		System.out.println("_____MENU_____");
		System.out.println("1.ADD EMPLOYEE");
		System.out.println("2.SORT EMPLOYEE");
		System.out.println("3.SHOW LIST OF EMPLOYEE");
		System.out.println("0.EXIT");
		int select = this.inputInt(0, 3);
		return select;
	}

	public void start() {
		while (true) {
			int choice = this.menu();

			switch (choice) {
			case 0:
				System.out.println("thank you");
				System.exit(0);
				break;

			case 1:
				this.addEmployee();
				break;

			case 2:
				this.sortEmployee();
				break;

			case 3:
				this.showEmployee();
				break;

			default:
				break;
			}
		}
	}

	public int inputInt(int min, int max) {
		int value;
		while (true) {
			try {
				System.out.print("> ");
				value = Integer.parseInt(in.nextLine());
				if (value >= min && value <= max) {
					break;
				}
				System.out.println("from " + min + " to " + max);
			} catch (Exception e) {
				System.out.println("error");
			}
		}
		return value;
	}

	public void addEmployee() {
		while (true) {
			System.out.print("name >");
			String name = in.nextLine();

			System.out.print("age >");
			int age = inputInt(0, 200);

			System.out.print("salary >");
			int salary = inputInt(0, Integer.MAX_VALUE);

			this.manager.addEmployee(new Employee(name, age, salary));

			System.out.println("press any key to continue | press 0 to exit");
			String choice = in.nextLine().trim();
			System.out.print(choice);
			if (choice.equalsIgnoreCase("0")) {
				break;
			}
		}
	}

	public void sortEmployee() {
		List<Employee> afterSort = this.manager.sortEmployeeBySalary();

		System.out.println("\n_____after sort_____");
		if (afterSort.size() > 0) {
			for (Employee employee : afterSort) {
				System.out.println("name: " + employee.getName());
				System.out.println("age: " + employee.getAge());
				System.out.println("salary: " + employee.getSalary());
				System.out.println("----------");
			}
		} else {
			System.out.println("empty");
		}
	}

	public void showEmployee() {
		List<Employee> employees = this.manager.getEmployees();

		System.out.println("\n_____list of Employee_____");
		if (employees.size() > 0) {
			for (Employee employee : employees) {
				System.out.println("name: " + employee.getName());
				System.out.println("age: " + employee.getAge());
				System.out.println("salary: " + employee.getSalary());
				System.out.println("----------");
			}
		} else {
			System.out.println("empty");
		}
	}

}
