package salariati.test;

import org.junit.Before;
import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.controller.UIController;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeMock;
import salariati.validator.EmployeeValidator;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Integrare_Top_Down {
    private UIController uiController;

    @Before
    public void setUp(){
        EmployeeRepositoryInterface repositoryInterface = new EmployeeMock();
        EmployeeController controller = new EmployeeController(repositoryInterface);
        EmployeeValidator validator = new EmployeeValidator();
        uiController = new UIController(controller, validator);
    }

    @Test
    public void unit_test_A(){
        String result;
        result = uiController.addEmployee("LastName", "1960514135456", DidacticFunction.ASISTENT, "10");
        assertEquals("Added: LastName;1960514135456;ASISTENT;10", result);
    }

    @Test
    public void unit_test_B(){
        unit_test_A();

        String result;
        result = uiController.modifyFunction("1960514135456", DidacticFunction.LECTURER);
        assertEquals("Employee modified",result);
    }

    @Test
    public void unit_test_C(){
        unit_test_A();

        List<Employee> employees = uiController.getEmployeeBySalary();
        for(int i = 0; i < employees.size() - 1; i++){
            Employee e1 = employees.get(i);
            Employee e2 = employees.get(i+1);
            assertTrue(Integer.parseInt(e1.getSalary()) >= Integer.parseInt(e2.getSalary()));
        }

        unit_test_B();
    }

}
