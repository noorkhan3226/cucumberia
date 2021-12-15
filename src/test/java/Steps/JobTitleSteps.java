package Steps;

import Pages.DashBoardPage;
import Pages.GlobarVariables;
import UTILS.CommonMethods;
import UTILS.DButills;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class JobTitleSteps extends CommonMethods {

    @When("user clicks on Admin option")
    public void user_clicks_on_admin_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.Admin);
    }

    @When("selects Job dropdown")
    public void selects_job_dropdown() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.Jobtab);
    }

    @When("clicks on Job Titles")
    public void clicks_on_job_titles() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.JobTitle);
    }

    @When("queries HRMS DATAbase for Job titles")
    public void queries_hrms_dat_abase_for_job_titles() {
        GlobarVariables.empListData = DButills.listOfMapsfromDb("select distinct * from ohrm_job_title where is_deleted=0 order by 2 asc");

    }

    @Then("user verifies that all job titles are in ascending oder")
    public void user_verifies_that_all_job_titles_are_in_ascending_oder() {
        DashBoardPage dash = new DashBoardPage();
    //  Select select = new Select( dash.resultTable);

        //List<WebElement> values = dash.resultTable.get();

        for (int i=1; i< dash.resultTable.size(); i++){
            String optionText = dash.resultTable.get(i).getText();
            System.out.println(optionText);
       // for (WebElement value : values) {
          //  String optionText = value.getText();
          //  System.out.println(optionText);
            Assert.assertEquals(GlobarVariables.empListData, optionText);

        }

    }
}
