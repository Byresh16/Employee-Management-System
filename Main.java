import model.Employee;
import dao.EmployeeDAO;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n1. Add Employee\n2. View All\n3. Delete\n4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Department: "); String dept = sc.nextLine();
                    System.out.print("Salary: "); double sal = sc.nextDouble();
                    dao.addEmployee(new Employee(id, name, dept, sal));
                }
                case 2 -> {
                    List<Employee> list = dao.getAllEmployees();
                    for (Employee e : list) System.out.println(e);
                }
                case 3 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteEmployee(id);
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }
}