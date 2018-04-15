package salariati.main;

import salariati.controller.UIController;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeMock;
import salariati.validator.EmployeeValidator;
import salariati.controller.EmployeeController;

import java.io.*;

import static salariati.enumeration.DidacticFunction.ASISTENT;
import static salariati.enumeration.DidacticFunction.LECTURER;
import static salariati.enumeration.DidacticFunction.TEACHER;

//functionalitati
//i.	 adaugarea unui nou angajat (nume, prenume, CNP, functia didactica, salariul de incadrare);
//ii.	 modificarea functiei didactice (asistent/lector/conferentiar/profesor) a unui angajat;
//iii.	 afisarea salariatilor ordonati descrescator dupa salariu si crescator dupa varsta (CNP).


public class StartApp {

	public static void main_menu(){
		System.out.println("-------------------------------");
		System.out.println("1)Add employee:");
		System.out.println("2)Modify didactic function");
		System.out.println("3)Print descended by salary");
		System.out.println("4)Print ascending by age");
		System.out.println("5)Exit");
		System.out.println("-------------------------------");
	}

	public static void nonGUIInterface(UIController uiController) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 0;
		while (t!=5)
		{
			main_menu();
			System.out.println("Option: ");
			t = Integer.parseInt(br.readLine());
			if (t == 1){
				System.out.println("Name: ");
				String name = br.readLine();
				System.out.println("CNP: ");
				String cnp = br.readLine();
				System.out.println("Function: ");
				String didacticFunction = br.readLine();
				DidacticFunction df;
				if (didacticFunction.equals("ASISTENT")){
					df = ASISTENT;
				}
				else if (didacticFunction.equals("LECTURER")){
					df = LECTURER;
				}
				else {
					df = TEACHER;
				}
				System.out.println("Salary: ");
				String salary = br.readLine();
				uiController.addEmployee(name,cnp,df,salary);
			}
			if (t == 2){
				System.out.println("CNP: ");
				String cnp = br.readLine();
				System.out.println("Function: ");
				String didacticFunction = br.readLine();
				DidacticFunction df;
				if (didacticFunction.equals("ASISTENT")){
					df = ASISTENT;
				}
				else if (didacticFunction.equals("LECTURER")){
					df = LECTURER;
				}
				else {
					df = TEACHER;
				}
				uiController.modifyFunction(cnp,df);
			}
			if (t == 3){
				for (Employee e:
					 uiController.getEmployeeBySalary()) {
					System.out.println(e);
				}
			}
			if (t == 4){
				for (Employee e:
						uiController.getEmployeeByAge()) {
					System.out.println(e);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		EmployeeRepositoryInterface employeesRepository = new EmployeeMock();
		EmployeeController employeeController = new EmployeeController(employeesRepository);

		UIController uiController = new UIController(employeeController,new EmployeeValidator());
		try {
			nonGUIInterface(uiController);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
