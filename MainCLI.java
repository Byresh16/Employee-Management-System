import java.util.*;

public class MainCLI {
    private static final List<Employee> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add\n2. View\n3. Delete\n4. Exit");
            switch (sc.nextInt()) {
                case 1 -> {
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Dept: "); String dept = sc.nextLine();
                    System.out.print("Salary: "); double sal = sc.nextDouble();
                    list.add(new Employee(id, name, dept, sal));
                }
                case 2 -> list.forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID to delete: "); int id = sc.nextInt();
                    list.removeIf(e -> e.getId() == id);
                }
                case 4 -> System.exit(0);
            }
        }
    }
}
