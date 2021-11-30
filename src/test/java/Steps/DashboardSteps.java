package Steps;

import Pages.DashBoardPage;
import Pages.GlobarVariables;
import UTILS.CommonMethods;
import UTILS.DButills;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("user verify the dashboard options available on the page")
    public void user_verify_the_dashboard_options_available_on_the_page(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();

        DashBoardPage dash = new DashBoardPage();
        List<String> actualList = new ArrayList<>();

        for (WebElement ele : dash.dashboardTabs) {
            actualList.add(ele.getText());
        }
        System.out.println(actualList);
        System.out.println(expectedTabs);

        Assert.assertTrue(expectedTabs.equals(actualList));
    }


    @When("user clicks on Directory option")
    public void user_clicks_on_directory_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.DirectoryOption);
    }

    @When("selects Location dropdown")
    public void selects_location_dropdown() {
        DashBoardPage dash = new DashBoardPage();
        Select select = new Select(dash.Locations);

        List<WebElement> values = select.getOptions();


        for (WebElement value : values) {
            String optionText = value.getText();
            System.out.println(optionText);


        }


    }

    @When("user sees office names and countries")
    public void user_sees_office_names_and_countries() {
        DashBoardPage dash = new DashBoardPage();
        Assert.assertTrue(dash.Locations.isSelected());
    }

    @When("queries HRMS DATAbase")
    public void queries_hrms_dat_abase() {
        GlobarVariables.empListData = DButills.listOfMapsfromDb(" select name,country_code from ohrm_location");

    }

    @Then("validate HRMS Application Data against DataBase")
    public void validate_hrms_application_data_against_data_base() {
        DashBoardPage dash = new DashBoardPage();
        /*Select select = new Select(dash.Locations);

        List<WebElement> values = select.getOptions();

        for (WebElement value : values) {
            String optionText = value.getText();
            Assert.assertEquals(GlobarVariables.mapDataFromDb, optionText);*/


        //  Select select = new Select( dash.resultTable);

        //List<WebElement> values = dash.resultTable.get();

        for (int i=1; i< dash.resultTable2.size(); i++){
            String optionTextt = dash.resultTable2.get(i).getText();
            System.out.println(optionTextt);
            // for (WebElement value : values) {
            //  String optionText = value.getText();
            //  System.out.println(optionText);
            Assert.assertEquals(GlobarVariables.empListData, optionTextt);
        }
    }
}