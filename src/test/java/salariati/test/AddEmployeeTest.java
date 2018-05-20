package salariati.test;

import static org.junit.Assert.*;

import salariati.controller.UIController;
import salariati.model.Employee;

import org.junit.Before;
import org.junit.Test;

import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeMock;
import salariati.validator.EmployeeValidator;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;

public class AddEmployeeTest {

	private UIController uiController;

	@Before
	public void setUp() {
		EmployeeRepositoryInterface employeeRepository  = new EmployeeMock();
		EmployeeController controller 					= new EmployeeController(employeeRepository);
		EmployeeValidator employeeValidator 			= new EmployeeValidator();
		uiController   									= new UIController(controller, employeeValidator);
	}

	@Test
	public void testAddNewEmployee_BVA_nonvalid() {
		String result;
		result = uiController.addEmployee("LastName", "1960514135456", DidacticFunction.ASISTENT, "9");
		assertEquals("Error to add: LastName;1960514135456;ASISTENT;9", result);
	}

	@Test
	public void testAddNewEmployee_BVA_valid(){
		String result;
		result = uiController.addEmployee("LastName", "1960514135456", DidacticFunction.ASISTENT, "10");
		assertEquals("Added: LastName;1960514135456;ASISTENT;10", result);
	}


	@Test
	public void testAddNewEmployee_ECP_nonvalid() {
		String result;
		result = uiController.addEmployee("LastName", "1960514135456", DidacticFunction.ASISTENT, "-3000");
		assertEquals("Error to add: LastName;1960514135456;ASISTENT;-3000", result);
	}

	@Test
	public void testAddNewEmployee_ECP_valid(){
		String result;
		result = uiController.addEmployee("LastName", "1960514135456", DidacticFunction.ASISTENT, "3000");
		assertEquals("Added: LastName;1960514135456;ASISTENT;3000", result);
	}



}
