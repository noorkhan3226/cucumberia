package Steps;

import UTILS.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before
    public void Start(){
        openBrowser();
    }

    @After
    public void end(Scenario scenario){
        byte[] pic;
        if(scenario.isFailed()){
            pic = takeScreenshot("failed/" + scenario.getName());
        }else{
            pic = takeScreenshot("passed/" + scenario.getName());
        }
        //it will attach pics in report
        scenario.attach(pic, "image/png", scenario.getName());
        tearDown();
    }
}
