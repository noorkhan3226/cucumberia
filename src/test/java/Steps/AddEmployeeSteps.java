package Steps;

import Pages.AddEmployeePAGE;
import Pages.DashBoardPage;
import Pages.EmployeeListPage;
import Pages.GlobarVariables;
import UTILS.CommonMethods;
import UTILS.Constants;
import UTILS.ExcelReadingClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static UTILS.CommonMethods.sendText;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.PIMoption);
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.addEmployeeButton);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePAGE addEmployeePage = new AddEmployeePAGE();
        sendText(addEmployeePage.firtname, "Noor");
        sendText(addEmployeePage.middlename, "007breakmanager");
        sendText(addEmployeePage.lastname, "khan");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePAGE addEmployeePage = new AddEmployeePAGE();
        click(addEmployeePage.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePAGE addEmployeePage = new AddEmployeePAGE();
        addEmployeePage.employeeId.clear();
    }

    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePAGE addEmployeePage = new AddEmployeePAGE();
        click(addEmployeePage.createLoginCheckBox);
    }
    @When("user enters username password and confirmpassword")
    public void user_enters_username_password_and_confirmpassword() {
        AddEmployeePAGE addEmployeePage = new AddEmployeePAGE();
        sendText(addEmployeePage.createuserNAme, "noor10272021234");
        sendText(addEmployeePage.createpassword, "Hum@nhrm123");
        sendText(addEmployeePage.REpassword, "Hum@nhrm123");
    }


    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstName, String middleName, String lastName) {

        GlobarVariables.firstName=firstName;
        GlobarVariables.middleName=middleName;
        GlobarVariables.lastName=lastName;

        AddEmployeePAGE addEmployeePage = new AddEmployeePAGE();
        sendText(addEmployeePage.firtname, firstName);
        sendText(addEmployeePage.middlename, middleName);
        sendText(addEmployeePage.lastname, lastName);
    }

    @When("user enters {string} {string} and {string} for an employee")
    public void user_enters_and_for_an_employee(String firstName, String middleName, String lastName) {
        AddEmployeePAGE addEmployeePage = new AddEmployeePAGE();

        sendText(addEmployeePage.firtname, firstName);
        sendText(addEmployeePage.middlename, middleName);
        sendText(addEmployeePage.lastname, lastName);
    }

    @When("I add multiple employees and verify them that user has been added successfully")
    public void i_add_multiple_employees_and_verify_them_that_user_has_been_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String, String>> employeeNames = employees.asMaps();
        for(Map<String, String> employeeName : employeeNames){
            String valueFirstName = employeeName.get("firstName");
            String valueMiddleName = employeeName.get("middleName");
            String valueLastName = employeeName.get("lastName");

            AddEmployeePAGE addEmployeePage = new AddEmployeePAGE();
            sendText(addEmployeePage.firtname, valueFirstName);
            sendText(addEmployeePage.middlename, valueMiddleName);
            sendText(addEmployeePage.lastname, valueLastName);
            click(addEmployeePage.saveBtn);

            //Assertion in homework
            //verify the employee has been added
            DashBoardPage dash = new DashBoardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(3000);

        }

    }
    @When("user adds multiple employees from excel file usin {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_excel_file_usin_sheet_and_verify_the_added_employee(String sheetName) {
        List<Map<String, String>> newEmployees = ExcelReadingClass.excelInToMapList(Constants.TESTDATA_FILEPATH, sheetName);

        DashBoardPage dash = new DashBoardPage();
        AddEmployeePAGE add = new AddEmployeePAGE();

        Iterator<Map<String, String>> it = newEmployees.iterator();
        while(it.hasNext()){
            Map<String, String> mapNewEmp = it.next();
            sendText(add.firtname, mapNewEmp.get("FirstName"));
            sendText(add.middlename, mapNewEmp.get("MiddleName"));
            sendText(add.lastname, mapNewEmp.get("LastName"));
            click(add.saveBtn);
            //Assertion in HW
            click(dash.addEmployeeButton);
        }
    }

}
