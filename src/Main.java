/**
 * Main — demonstrate your Employee Management System.
 *
 * YOUR TASKS:
 *   Part C — Create Manager and Intern objects, demonstrate polymorphism
 *   Part D — Add try/catch blocks for exception handling
 *
 * This file should compile and run, printing output that proves
 * all your code works correctly.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== PART A: Salary Utilities ===");
        //Test all 4 SalaryUtils methods and print results
        // Example: done
        System.out.println("Annual salary: " + SalaryUtils.calculateAnnualSalary(3000));
        System.out.println("Tax on 25000: " + SalaryUtils.calculateTax(25000));
        System.out.println("Net salary: " + SalaryUtils.calculateNetSalary(25000));
        System.out.println("After 10% raise: " + SalaryUtils.applyRaise(3000, 10));


        System.out.println("\n=== PART B: Employee Manager ===");
        //Create an EmployeeManager
        EmployeeManager EmpManager = new EmployeeManager();
        // Create and add at least 3 employees to it
        Employee emp1 = new Employee(1, "Sara", "Engineering", 5000);
        Employee emp2 = new Employee(2, "Hasan", "Marketing", 4500);
        Employee emp3 = new Employee(3, "Ali", "Engineering", 5500);

        EmpManager.addEmployee(emp1);
        EmpManager.addEmployee(emp2);
        EmpManager.addEmployee(emp3);


        // Demonstrate findById 
        //found
        System.out.println("Found employee with ID 1: " + EmpManager.findById(1).getName());


        // Demonstrate getEmployeesByDepartment
        System.out.println("Employees in Engineering:");    
        for (Employee emp : EmpManager.getEmployeesByDepartment("engineering")) {
            System.out.println(" - " + emp.getName());
        }

        System.out.println("\n=== PART C: Inheritance & Polymorphism ===");
        //Create at least 1 Manager and 1 Intern
        Manager manager1 = new Manager(5, "Khalid", "HR", 6000, 5);
        Intern intern1 = new Intern(4, "Ahmed", "IT", 1200, "UOB");

        //Add all employees (Employee, Manager, Intern) to the manager
        EmpManager.addEmployee(manager1);
        EmpManager.addEmployee(intern1);

        // Loop through getAllEmployees() and call getBonus() on each
        for (Employee emp : EmpManager.getAllEmployees()) {
            System.out.println(emp.getName() + " bonus: " + emp.getBonus());
        }
        //Print: "<name> bonus: <amount>" for each one
        //This demonstrates polymorphism — same method call, different behavior



        
        System.out.println("\n=== PART D: Exception Handling ===");
        //Use try/catch to demonstrate: 
        // Each try/catch should print the error message gracefully

        //   1. Trying to remove an employee that doesn't exist
        System.out.println("Trying to remove employee with ID 10...");
        try {
            EmpManager.removeEmployee(10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //   2. Trying to promote an employee that's already a Manager
        System.out.println("Trying to promote employee with ID 5 (already a Manager)...");
        try {  
            EmpManager.promoteToManager(5, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //   3. Trying to create an Employee with invalid data (negative salary)
        System.out.println("Trying to create an employee with negative salary...");
        try {
            Employee emp4 = new Employee(6, "Fatima", "Marketing", -1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
