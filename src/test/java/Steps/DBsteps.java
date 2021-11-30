package Steps;

import Pages.AddEmployeePAGE;
import Pages.GlobarVariables;
import UTILS.DButills;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBsteps {

    @Then("query HRMS database and get data")
    public void query_hrms_database_and_get_data()  {

        GlobarVariables.mapDataFromDb=DButills.mapFromDb("SELECT emp_firstname, emp_middle_name, emp_lastname "
                + "FROM hs_hr_employees "
                + "WHERE employee_id="+GlobarVariables.empId);
    }

    @When("captures employee id")
    public void captures_employee_id() {
        AddEmployeePAGE employeePAGE=new AddEmployeePAGE();
        GlobarVariables.empId =employeePAGE.employeeId.getAttribute("value");


    }

    @Then("verify employee data is matched in ui and db")
    public void verify_employee_data_is_matched_in_ui_and_db() {
        Assert.assertEquals(GlobarVariables.mapDataFromDb.get("emp_firstname") , GlobarVariables.firstName);
        Assert.assertEquals(GlobarVariables.mapDataFromDb.get("emp_middle_name") , GlobarVariables.middleName);
        Assert.assertEquals(GlobarVariables.mapDataFromDb.get("emp_lastname") , GlobarVariables.lastName);
    }
}
