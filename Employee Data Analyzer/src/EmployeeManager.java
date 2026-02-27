import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManager {
    private Map<Integer, Employee> employeedata;
    public EmployeeManager() {
        this.employeedata = new HashMap<>();
    }
    public void addEmployee(Employee employee) {
        this.employeedata.put(employee.getId(), employee);
    }
    public Optional<Employee> getEmployeeById(int id) {
        return Optional.ofNullable(this.employeedata.get(id));
    }
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(this.employeedata.values());
    }
    public List<Employee> FilterEmployeesBySalary(double minSalary) {
        return employeedata.values().stream()
                .filter(employee -> employee.getSalary() >= minSalary)
                .collect(Collectors.toList());
    }
    public List<Employee> sortEmployeesBySalary() {
        return employeedata.values().stream()
                .sorted(Comparator.comparingDouble(e -> e.getSalary()))
                .collect(Collectors.toList());
    }

}
