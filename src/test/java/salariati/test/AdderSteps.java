package salariati.test;

import net.thucydides.core.annotations.Step;

public class AdderSteps {
    HomePage page;
    ResponsePage responsePage;

    @Step
    public void opens_home_page(){
        page.open();
    }

    @Step
    public void set_input_name(String keywords){
        page.set_input_name(keywords);
    }

    @Step
    public void set_input_cnp(String keywords){
        page.set_input_cnp(keywords);
    }

    @Step
    public void set_input_salary(String keywords){
        page.setInputSalary(keywords);
    }

    @Step
    public void submit_btn(){
        page.set_submit();
    }

    @Step
    public String get_response(){
        String result = responsePage.get_responseText();
        return result;
    }

}
