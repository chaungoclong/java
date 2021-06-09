package helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import entities.Customer;

public class CustomerIO {
	public static List<Customer> getList(String path) {
		List<Customer> list_customer = new ArrayList<Customer>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				String[] lines = line.split("\\|");

				int id = Integer.parseInt(lines[0]);
				String fullName = lines[1];
				String address = lines[2];
				String phone = lines[3];
				double amountAfter = Double.parseDouble(lines[4]);
				double discountPercent = Double.parseDouble(lines[5]);
				double taxPercent = Double.parseDouble(lines[6]);
				
				Customer customer = new Customer(id, fullName, address, phone, amountAfter, discountPercent, taxPercent);
				list_customer.add(customer);
				line = br.readLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list_customer;
	}

	public static boolean save(String path, List<Customer> data, boolean append) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
			for (Customer customer : data) {
				String line = customer.toString();
				bw.write(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
}
