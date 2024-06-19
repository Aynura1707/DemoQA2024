import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.AlertHelper;
import com.demoqa.helper.BrowserHelper;
import com.demoqa.helper.WebElementActions;
import com.demoqa.pages.*;
import com.demoqa.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public  class BaseTest {
    protected WebDriver driver;
    protected RandomUtils randomUtils;
    protected WebElementActions webElementActions;
    protected AlertHelper alertHelper;
    protected BrowserHelper browserHelper;
    protected TextBoxPage textBoxPage;
    protected AlertPage alertPage;
    protected ProgressBarPage progressBarPage;
    protected PracticeFormPage practiceFormPage;
    protected ButtonsPage buttonsPage;




    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = DriverManager.getDriver();
        randomUtils = new RandomUtils();
        webElementActions= new WebElementActions();
        alertHelper = new AlertHelper(driver);
        browserHelper= new BrowserHelper(driver);

        textBoxPage = new TextBoxPage();
        practiceFormPage= new PracticeFormPage();
        alertPage = new AlertPage();
        progressBarPage = new ProgressBarPage();
        buttonsPage = new ButtonsPage();
    }

    @AfterClass
    public void tearDown() {
         DriverManager.closeDriver();
    }
}