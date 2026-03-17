/**
 * Employee class — represents an employee in the system.
 *
 * YOUR TASK (Part B):
 *   1. Complete the constructor that takes all 4 parameters
 *   2. Add getters for all fields
 *   3. Add setters with validation:
 *      - setName: throw IllegalArgumentException if name is null or empty
 *      - setSalary: throw IllegalArgumentException if salary is negative
 *      - setDepartment: throw IllegalArgumentException if department is null or empty
 *   4. Override toString() to return a readable string like:
 *      "Employee{id=1, name='Ahmed', department='Engineering', salary=3500.0}"
 *   5. Add a getBonus() method that returns 5% of salary (salary * 0.05)
 */
public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    // Must validate: name not null/empty, department not null/empty, salary not negative ✅
    public Employee(int id, String name, String department, double salary) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null or empty.");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }

        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    //Getters and setters with validation 
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    // Override toString()
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }


    // getBonus() — returns 5% of salary 
    public double getBonus() {
        return salary * 0.05;
    }
}
