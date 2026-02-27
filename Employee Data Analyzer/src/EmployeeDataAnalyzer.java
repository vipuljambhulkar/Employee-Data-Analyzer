import java.util.List;

public class EmployeeDataAnalyzer {
    public static void main(String[] args){
        EmployeeManager employeeManager = new EmployeeManager();

        //Adding employee to the system
       employeeManager.addEmployee(new Employee("Vipul",1,"Engineer",70000));
       employeeManager.addEmployee(new Employee("kaka",2,"Engineer",50000));
       employeeManager.addEmployee(new Employee("atu",3,"Engineer",60000));

       // simulate multithreading processing employee by id
        Thread process1 = new EmployeeProcessor(employeeManager,1);
        Thread process2 = new EmployeeProcessor(employeeManager,2);
        Thread process3 = new EmployeeProcessor(employeeManager,4); //Non -Existing Employee

        process1.start();
        process2.start();
        process3.start();

        // Wait for thread to complete
        try {
            process1.join();
            process2.join();
            process3.join();
        }catch (InterruptedException e){
            System.out.println("error processing employee data:"+e.getMessage());
        }
        // filtering employee base on salary
        System.out.println("\nEmployees with salary >= 70000:");
        List<Employee> highEarners = employeeManager.FilterEmployeesBySalary(70000.0);
        highEarners.forEach(System.out::println);

        // Sorting employees by salary
        System.out.println("\nEmployees sorted by salary:");
        List<Employee> sortedEmployees = employeeManager.sortEmployeesBySalary();
        sortedEmployees.forEach(System.out::println);
    }
}
