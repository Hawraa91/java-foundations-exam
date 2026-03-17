import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EmployeeManager — manages a collection of employees.
 * Uses an ArrayList for ordered storage and a HashMap for fast ID lookups.
 *
 * YOUR TASKS:
 *   Part B — Complete: addEmployee, findById, getEmployeesByDepartment
 *   Part D — Complete: removeEmployee, promoteToManager
 */
public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    // ================================================================
    // PART B — Basic Operations (complete these 3 methods)
    // ================================================================

    /**
     * Add an employee to both the list and the map.
     * If an employee with the same ID already exists, throw IllegalArgumentException.
     *
     * @param employee the employee to add
     * @throws IllegalArgumentException if employee with same ID already exists
     */
    public void addEmployee(Employee employee) {

        // Check if ID already exists in the map 
        if (employeeMap.containsKey(employee.getId())) {
            throw new IllegalArgumentException("Employee with ID " + employee.getId() + " already exists.");
        }
        //Add to both the list and the map 
        employees.add(employee);
        employeeMap.put(employee.getId(), employee);

    }

    /**
     * Find an employee by their ID using the HashMap.
     * Return null if not found.
     *
     * @param id the employee ID to search for
     * @return the Employee, or null if not found
     */
    public Employee findById(int id) {

        //Look up the employee in the map 
        if (employeeMap.containsKey(id)) {
            return employeeMap.get(id);
        }

        return null;
    }

    /**
     * Return a list of all employees in a given department.
     * The search should be case-insensitive.
     *
     * Example: getEmployeesByDepartment("engineering") should match
     *          employees in "Engineering", "ENGINEERING", etc.
     *
     * @param department the department name to filter by
     * @return list of matching employees (empty list if none found)
     */
    public List<Employee> getEmployeesByDepartment(String department) {
        // Loop through the employees list  and check department (case-insensitive) 
        // Add matching employees to a results list 
        List<Employee> results = new ArrayList<>();
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null.");
        }
         for (Employee employee : employees) {
             // Hint: use .equalsIgnoreCase() for case-insensitive comparison
             if (employee.getDepartment().equalsIgnoreCase(department)) {
                 results.add(employee);
             }
         }

        return results;
    }

    /**
     * Get all employees.
     * (This one is done for you.)
     */
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /**
     * Get total number of employees.
     * (This one is done for you.)
     */
    public int getEmployeeCount() {
        return employees.size();
    }

    // ================================================================
    // PART D — Exception Handling (complete these 2 methods)
    // ================================================================

    /**
     * Remove an employee by ID.
     * Must remove from BOTH the list and the map.
     *
     * @param id the employee ID to remove
     * @throws IllegalArgumentException if no employee with that ID exists
     */
    public void removeEmployee(int id) {
        //Find the employee by ID
         Employee employee = findById(id);
            if (employee == null) {
                throw new IllegalArgumentException("Employee with ID " + id + " not found.");
        }

        //Remove from both the list and the map
        employees.remove(employee);
        employeeMap.remove(employee.getId());

    }

    /**
     * Promote an employee to Manager.
     * This removes the existing employee and adds a new Manager
     * with the same id, name, department, salary, plus the given teamSize.
     *
     * @param id       the employee ID to promote
     * @param teamSize the team size for the new Manager
     * @return the newly created Manager
     * @throws IllegalArgumentException if no employee with that ID exists
     * @throws IllegalArgumentException if the employee is already a Manager
     */
    public Manager promoteToManager(int id, int teamSize) {
        //Find the employee by ID (throw if not found)
        //Check if already a Manager (use instanceof), throw if so
        //Message: "Employee <id> is already a Manager"
        Employee employee = findById(id);
        if (employee == null) {
            throw new IllegalArgumentException("Employee with ID " + id + " not found.");
        }
    
        if (employee instanceof Manager) {
            throw new IllegalArgumentException("Employee with ID " + id + " is already a Manager.");
        }

        // Create a new Manager with the same details + teamSize
        Manager newManager = new Manager(employee.getId(), employee.getName(), employee.getDepartment(), employee.getSalary(), teamSize);
        
        // Remove the old employee, add the new Manager
        employees.remove(employee);
        employees.add(newManager);

        // Return the new Manager
        return newManager;
    }
}
