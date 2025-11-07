import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // since question has mentioned only 4 emplyee arrya so

        Employee list[] = new Employee[4];
        for (int i = 0; i < 4; i++) {
            int empId = Integer.parseInt(sc.nextLine().trim());
            String name = sc.nextLine();
            String branch = sc.nextLine();
            double rating = Double.parseDouble(sc.nextLine().trim());
            boolean cmpTransport = sc.nextBoolean();
            sc.nextLine();

            list[i] = new Employee(empId, name, branch, rating, cmpTransport);
        }
        String branch = sc.nextLine();

        int count = findCountOfEmployeesUsingCompTransport(list, branch);
        if (count > 0)
            System.out.println(count);
        else
            System.out.println("No such Employees");

        Employee e = findEmployeeWithSecondHighestRating(list);
        if (e == null)
            System.out.println("All Employee using company Transport");

        else {
            System.out.println(e.getId());
            System.out.println(e.getName());
        }

        sc.close();

    }

    // implement method1 case sensitive
    public static int findCountOfEmployeesUsingCompTransport(Employee[] list, String branch) {
        int count = 0;
        for (Employee e : list) {
            if (e.getCompanyTransport() && e.getBranch().equals(branch)) {
                count++;
            }
        }

        return count;
    }

    // method 2
    public static Employee findEmployeeWithSecondHighestRating(Employee[] list) {
        Employee firstHighest = null;
        Employee secondHighest = null;
        for (Employee e : list) {
            if (!e.getCompanyTransport()) {
                if (firstHighest == null || e.getRating() > firstHighest.getRating()) {
                    secondHighest = firstHighest;
                    firstHighest = e;

                } else if (secondHighest == null
                        || e.getRating() < firstHighest.getRating() && e.getRating() > secondHighest.getRating()) {
                    secondHighest = e;

                }
            }
        }

        return secondHighest;
    }

}

class Employee {
    private int employeeId;
    private String name;
    private String branch;
    private double rating;
    private boolean companyTransport;

    public Employee(int id, String name, String branch, double rating, boolean companyTransport) {
        this.employeeId = id;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.companyTransport = companyTransport;
    }
    // lets set getter only

    public int getId() {
        return this.employeeId;
    }

    public String getName() {
        return this.name;
    }

    public double getRating() {
        return this.rating;
    }

    public boolean getCompanyTransport() {
        return this.companyTransport;
    }

    public String getBranch() {
        return this.branch;
    }
}
