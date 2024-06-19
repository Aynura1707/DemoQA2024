import org.testng.annotations.Test;

public class ProgressBarTest extends BaseTest {

    @Test
    public void progressTest() throws InterruptedException {
        driver.get("https://demoqa.com/progress-bar");
        progressBarPage.startAndStopProgressBar();
    }
}
