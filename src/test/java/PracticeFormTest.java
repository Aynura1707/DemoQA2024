import com.demoqa.entities.Employee;
import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.entities.TextBoxEntity;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeFormTest  extends BaseTest{

    @Test
    void practiceTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
       PracticeFormEntity practiceFormEntity = randomUtils.generateRandomPracticeFormEntity();
       practiceFormPage
                .fillUpPracticeForm(practiceFormEntity);
    }

    @Test(description = "Practice form test")
    public void test123(){
        driver.get("https://demoqa.com/webtables");
      practiceFormPage.addNewEmployee(randomUtils.createMockEmployee());

      List<Employee> employee = practiceFormPage.getEmployeesFromTable();
      for (Employee employee1: employee){
         System.out.println(employee1);
     }



    }
}
