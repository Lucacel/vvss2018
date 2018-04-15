package salariati.controller;

import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.validator.EmployeeValidator;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class UIController {
    private EmployeeController employeeController;
    private EmployeeValidator validator;

    public UIController(EmployeeController employeeController, EmployeeValidator validator) {
        this.employeeController = employeeController;
        this.validator = validator;
    }

    public String addEmployee(String name, String CNP, DidacticFunction function, String salary){
        Employee employee = new Employee(name,CNP,function,salary);
        if (validator.isValid(employee)){
            employeeController.addEmployee(employee);
            return "Added: "+employee.toString();
        }
        else {
            return "Error to add: "+employee+toString();
        }

    }

    public String modifyFunction(String CNP, DidacticFunction function){
        List<Employee> employees = employeeController.getEmployeesList();
        for (Employee e:
             employees) {
            if (e.getCnp().equals(CNP)){
                Employee e2 = new Employee(e.getLastName(),e.getCnp(),function,e.getSalary());
                employeeController.modifyEmployee(e,e2);
                return "Employee: "+e+" modified to: "+e2;
            }
        }
        return "Error employee not found";
    }

    public List<Employee> getEmployeeBySalary(){
        List<Employee> employees = employeeController.getEmployeesList();
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int salary1 = Integer.parseInt(o1.getSalary());
                int salary2 = Integer.parseInt(o2.getSalary());
                return salary1 > salary2 ? -1 : (salary1 < salary2) ? 1 : 0;
            }
        });
        return employees;
    }
    public List<Employee> getEmployeeByAge(){
        List<Employee> employees = employeeController.getEmployeesList();
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int year1 = Integer.parseInt(o1.getCnp().substring(5,6));
                int month1 = Integer.parseInt(o1.getCnp().substring(3,4));
                int day1 = Integer.parseInt(o1.getCnp().substring(1,2));
                int date1 = (year1*100+month1)*100+day1;
                int year2 = Integer.parseInt(o2.getCnp().substring(5,6));
                int month2 = Integer.parseInt(o2.getCnp().substring(3,4));
                int day2 = Integer.parseInt(o2.getCnp().substring(1,2));
                int date2 = (year2*100+month2)*100+day2;
                return date1 > date2 ? -1 : (date1 < date2) ? 1 : 0;
            }
        });
        return employees;
    }


}
