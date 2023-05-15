package pro.sky.course2StreamAPIandoptional;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee add(String firstName, String lastName, int department, int salary);

    Employee delete(String firstName, String lastName);

    Employee delete(String firstName, String lastName, int department, int salary);

    Employee find (String firstName, String lastName);

    Employee find(String firstName, String lastName, int department, int salary);

    Collection<Employee> findAll();
    Collection<Employee> getEmployees();
}
