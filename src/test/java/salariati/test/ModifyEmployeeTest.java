package salariati.test;

import org.junit.Before;
import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.controller.UIController;
import salariati.enumeration.DidacticFunction;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeMock;
import salariati.validator.EmployeeValidator;

import static org.junit.Assert.assertEquals;

public class ModifyEmployeeTest {
    private UIController uiController;

    @Before
    public void setUp(){
        EmployeeRepositoryInterface repositoryInterface = new EmployeeMock();
        EmployeeController controller = new EmployeeController(repositoryInterface);
        EmployeeValidator validator = new EmployeeValidator();
        uiController = new UIController(controller, validator);
    }

    @Test
    public void testModifyEmployeeValid(){
        String result;
        result = uiController.modifyFunction("1960519152485", DidacticFunction.ASISTENT);
        assertEquals("Employee modified",result);

        result = uiController.modifyFunction("1960519152486", DidacticFunction.ASISTENT);
        assertEquals("Employee modified",result);

        result = uiController.modifyFunction("1960519152487", DidacticFunction.ASISTENT);
        assertEquals("Employee modified",result);

        result = uiController.modifyFunction("1960519152489", DidacticFunction.ASISTENT);
        assertEquals("Employee modified",result);

        result = uiController.modifyFunction("1960519152480", DidacticFunction.LECTURER);
        assertEquals("Employee modified",result);
    }

    @Test
    public void testModifyEmployeeNonValid(){
        String result;
        result = uiController.modifyFunction("1960519152481", DidacticFunction.ASISTENT);
        assertEquals("Error employee not found",result);

        result = uiController.modifyFunction("1960519152482", DidacticFunction.ASISTENT);
        assertEquals("Error employee not found",result);

        result = uiController.modifyFunction("1960519152483", DidacticFunction.ASISTENT);
        assertEquals("Error employee not found",result);

        result = uiController.modifyFunction("1960519152484", DidacticFunction.ASISTENT);
        assertEquals("Error employee not found",result);

        result = uiController.modifyFunction("1960519152484", DidacticFunction.TEACHER);
        assertEquals("Error employee not found",result);
    }

}
