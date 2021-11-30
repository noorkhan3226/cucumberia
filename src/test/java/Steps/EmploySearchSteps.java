package Steps;

import Pages.DashBoardPage;
import Pages.EmployeeListPage;
import Pages.LoginPage;
import UTILS.CommonMethods;
import UTILS.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EmploySearchSteps extends CommonMethods {



    @Given("user is navigated to HRMS")
    public void user_is_navigated_to_hrms() {
openBrowser();
    }

    @Given("user is loggen in with valid admin credentials")
    public void user_is_loggen_in_with_valid_admin_credentials() {
        LoginPage login=new LoginPage();
        sendText(login.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordBox,ConfigReader.getPropertyValue("password"));
        click(login.Loginbtna);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() throws InterruptedException {
        DashBoardPage dash=new DashBoardPage();
        Thread.sleep(2000);
        click(dash.PIMoption);
        Thread.sleep(2000);
        click(dash.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage emplist=new EmployeeListPage();
        sendText(emplist.idEmployee,"20119000");
    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage emplist=new EmployeeListPage();
        click(emplist.searchButton);
        //tearDown();
    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed()  {

        System.out.println("Info is displayed");
        }





    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() throws InterruptedException {
        EmployeeListPage emplist=new EmployeeListPage();
        Thread.sleep(3000);
        sendText(emplist.employyeNAMEField,"sohail");
    }
}
