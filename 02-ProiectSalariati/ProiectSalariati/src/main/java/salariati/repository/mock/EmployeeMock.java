package salariati.repository.mock;

import java.util.ArrayList;
import java.util.List;

import salariati.enumeration.DidacticFunction;

import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.validator.EmployeeValidator;

public class EmployeeMock implements EmployeeRepositoryInterface {

	private List<Employee> employeeList;
	private EmployeeValidator employeeValidator;
	
	public EmployeeMock() {
		
		employeeValidator = new EmployeeValidator();
		employeeList = new ArrayList<Employee>();
		
		Employee Ionel   = new Employee("Pacuraru", "1051296890876", DidacticFunction.ASISTENT, "3500");
		Employee Mihai   = new Employee("Dumitrescu", "1130394890876", DidacticFunction.LECTURER, "2500");
		Employee Ionela  = new Employee("Ionescu", "2110494890876", DidacticFunction.LECTURER, "1500");
		Employee Mihaela = new Employee("Pacuraru", "2120799890876", DidacticFunction.ASISTENT, "2500");
		Employee Vasile  = new Employee("Georgescu", "1010370890876", DidacticFunction.TEACHER,  "1500");
		Employee Marin   = new Employee("Puscas", "1020673890876", DidacticFunction.TEACHER,  "2500");
		
		employeeList.add( Ionel );
		employeeList.add( Mihai );
		employeeList.add( Ionela );
		employeeList.add( Mihaela );
		employeeList.add( Vasile );
		employeeList.add( Marin );
	}
	
	@Override
	public boolean addEmployee(Employee employee) {
		if ( employeeValidator.isValid(employee)) {
			employeeList.add(employee);
			return true;
		}
		return false;
	}
	
	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
		employeeList.remove(oldEmployee);
		employeeList.add(newEmployee);
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeByCriteria(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
