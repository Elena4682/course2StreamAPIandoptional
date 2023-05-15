package pro.sky.course2StreamAPIandoptional;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public abstract class EmployeeServiceImpl implements EmployeeService{
    private static final int MAX_SIZE = 50;
    private final List<Employee> employees = new ArrayList<>();
    @Override
    public Employee add(String firstName, String lastName, int department, int salary){
        Employee employee = new Employee(firstName,lastName,department,salary);
        if (employees.size()> MAX_SIZE){
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }
    @Override
    public Employee delete(String firstName, String lastName, int department, int salary){
        Employee employee = new Employee(firstName,lastName,department,salary);
        if(employees.contains(employee)){
            employees.remove(employee);
            return employee;
        }
        throw  new EmployeeNotFoundException();
    }
    @Override
    public Employee find (String firstName, String lastName,int department, int salary){
        Employee employee = new Employee(firstName,lastName,department,salary);
        if(employees.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Collection<Employee> findAll() {
        return employees;
    }
}
