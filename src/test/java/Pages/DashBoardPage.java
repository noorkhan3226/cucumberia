package Pages;

import UTILS.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoardPage extends CommonMethods {

    @FindBy(id="welcome")
    public WebElement welcomeMessage;

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement PIMoption;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeButton;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    @FindBy(xpath="//*[@class='menu']/ul/li")
    public List<WebElement> dashboardTabs;



    @FindBy(id="menu_directory_viewDirectory")
    public WebElement DirectoryOption;


    @FindBy(id="searchDirectory_location")
    public WebElement Locations;






    @FindBy(id="menu_admin_viewAdminModule")
    public WebElement Admin;


    @FindBy(id="menu_admin_Job")
    public WebElement Jobtab;

    @FindBy(id="menu_admin_viewJobTitleList")
    public WebElement JobTitle;


    @FindBy(id="resultTable")
    public List<WebElement> resultTable;



    @FindBy(id="resultTable")
    public List<WebElement> resultTable2;


    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }
}
