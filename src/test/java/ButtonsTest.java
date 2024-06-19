import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest{

    @Test(description = "Verify double click button is working propertly")
    public void doubleClick(){
        browserHelper.open("https://demoqa.com/buttons");
        webElementActions.doubleClick(buttonsPage.doubleClickBtn);
        Assert.assertEquals(buttonsPage.getDoubleClickMessage.getText(),"You have done a double click");
    }


}
