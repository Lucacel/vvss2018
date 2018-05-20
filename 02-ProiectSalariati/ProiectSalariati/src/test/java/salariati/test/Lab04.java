package salariati.test;

import org.junit.Before;
import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.controller.UIController;
import salariati.model.Employee;
import salariati.repository.implementations.EmployeeImpl;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeMock;
import salariati.validator.EmployeeValidator;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Lab04 {

    private UIController uiController;

    @Before
    public void setUp(){
        EmployeeRepositoryInterface repositoryInterface = new EmployeeMock();
        EmployeeController controller = new EmployeeController(repositoryInterface);
        EmployeeValidator validator = new EmployeeValidator();
        uiController = new UIController(controller, validator);
    }

    @Test
    public void BBT_testGetEmployeesBySalary_valid()
    {
        List<Employee> employees = uiController.getEmployeeBySalary();
        for(int i = 0; i < employees.size() - 1; i++){
            Employee e1 = employees.get(i);
            Employee e2 = employees.get(i+1);
            assertTrue(Integer.parseInt(e1.getSalary()) >= Integer.parseInt(e2.getSalary()));
        }
    }

    @Test
    public void BBT_testGetEmployeesBySalary_nonValid()
    {
        uiController = new UIController(new EmployeeController(new EmployeeImpl()),new EmployeeValidator());
        List<Employee> employees = uiController.getEmployeeBySalary();
        assertEquals(0,employees.size());
    }




}
