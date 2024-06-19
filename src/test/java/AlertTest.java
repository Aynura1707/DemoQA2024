import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertTrue;

public class AlertTest extends BaseTest {

    @Test
    void alertTest() throws InterruptedException {
        step("перейти по ссылке", () -> {
            driver.get("https://demoqa.com/alerts");
        });
        step("нажать на кноку алерт", () -> {
            webElementActions.click(alertPage.confirmAlertBtn);
        });
        step("принять алерт", () -> {
            Thread.sleep(3000);
            alertHelper.acceptAlert();
            Thread.sleep(3000);
        });





    }
}
