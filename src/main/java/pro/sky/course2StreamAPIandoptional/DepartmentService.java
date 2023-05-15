package pro.sky.course2StreamAPIandoptional;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee max(int dept) {
        return employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == dept)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }


    public Employee min(int dept) {
        return employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == dept)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }

    public List<Employee> allByDept(int dept) {
        var list = employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == dept)
                .collect(Collectors.toList());
        if (list.isEmpty())
            throw new RuntimeException();
        return list;
    }
    public Map<Integer, List<Employee>> all() {
            return employeeService.getEmployees()
                    .stream()
                    .collect(Collectors.groupingBy(e -> e.getDepartment()));
        }
    }



