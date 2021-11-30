package Pages;

import UTILS.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePAGE extends CommonMethods {

    @FindBy(id="firstName")
    public WebElement firtname;

    @FindBy(id="middleName")
    public WebElement middlename;

    @FindBy(id="lastName")
    public WebElement lastname;

    @FindBy(id="photofile")
    public WebElement photograph;

    @FindBy(id="chkLogin")
    public WebElement createLoginCheckBox;

    @FindBy(id="user_password")
    public WebElement createpassword;

    @FindBy(id="re_password")
    public WebElement REpassword;

    @FindBy(id="user_name")
    public WebElement createuserNAme;

    @FindBy(id="btnSave")
    public WebElement saveBtn;

    @FindBy(id="employeeId")
    public WebElement employeeId;


    @FindBy(xpath = "//h1[text()='Add Employee']")
    public WebElement headerValue;




    public AddEmployeePAGE(){
        PageFactory.initElements(driver,this);
    }
}
