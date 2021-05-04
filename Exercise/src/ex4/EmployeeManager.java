package ex4;

import java.util.List;
import java.util.ArrayList;

public class EmployeeManager {
	List<Employee> Employees;

	public EmployeeManager(List<Employee> employees) {
		this.Employees = employees;
	}

	public EmployeeManager() {
		this.Employees = new ArrayList<Employee>();
	}
	
	public Employee getEmployee(int index) {
		return this.Employees.get(index);
	}

	public List<Employee> getEmployees() {
		return Employees;
	}

	public void setEmployees(List<Employee> employees) {
		Employees = employees;
	}

	public void addEmployee(Employee employee) {
		this.Employees.add(employee);
	}

	public List<Employee> sortEmployeeBySalary() {
		List<Employee> result = new ArrayList<Employee>(this.Employees);

		// sort
		int i, j, index;
		for (i = 0; i < result.size() - 1; ++i) {
			index = i;
			for (j = i + 1; j < result.size(); ++j) {
				if (result.get(j).getSalary() > result.get(index).getSalary()) {
					index = j;
				}
			}

			if (index != i) {
				Employee tmp = result.get(i);
				result.set(i, result.get(index));
				result.set(index, tmp);
			}
		}

		return result;
	}

}
