package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import salariati.controller.EmployeeController;
import salariati.controller.UIController;
import salariati.enumeration.DidacticFunction;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeMock;
import salariati.validator.EmployeeValidator;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddEmployeeHandler implements HttpHandler {

    private EmployeeRepositoryInterface repositoryInterface = new EmployeeMock();
    private EmployeeController controller = new EmployeeController(repositoryInterface);
    private EmployeeValidator validator = new EmployeeValidator();
    private UIController uiController = new UIController(controller, validator);


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        // parse request
        Map<String, Object> parameters = new HashMap<String, Object>();
        InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String query = br.readLine();
        parseQuery(query, parameters);

        // send response
        StringBuilder response = new StringBuilder();
        String salary, cnp, name;
        DidacticFunction didacticFunction = DidacticFunction.ASISTENT;

        name = (String) parameters.get("Name");
        cnp = (String) parameters.get("CNP");
        salary = (String) parameters.get("Salary");

        System.out.println("Response sending....");
        String rsp = uiController.addEmployee(name, cnp, didacticFunction, salary);
        System.out.println("Response = " + rsp);
        response.append("<div class = \"text\">");
        response.append(rsp);
        response.append("</div>");

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.toString().getBytes());
        os.close();
    }
    private static void parseQuery(String query, Map<String,
            Object> parameters) throws UnsupportedEncodingException {

        if (query != null) {
            String pairs[] = query.split("[&]");
            for (String pair : pairs) {
                String param[] = pair.split("[=]");
                String key = null;
                String value = null;
                if (param.length > 0) {
                    key = URLDecoder.decode(param[0],
                            System.getProperty("file.encoding"));
                }

                if (param.length > 1) {
                    value = URLDecoder.decode(param[1],
                            System.getProperty("file.encoding"));
                }

                if (parameters.containsKey(key)) {
                    Object obj = parameters.get(key);
                    if (obj instanceof List<?>) {
                        List<String> values = (List<String>) obj;
                        values.add(value);

                    } else if (obj instanceof String) {
                        List<String> values = new ArrayList<String>();
                        values.add((String) obj);
                        values.add(value);
                        parameters.put(key, values);
                    }
                } else {
                    parameters.put(key, value);
                }
            }
        }
    }
}
