package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.Employee;
import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.entities.TextBoxEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PracticeFormPage extends BasePage {

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "userEmail")
    public WebElement userEmailInput;

    @FindBy(xpath = "//div[contains(@class,'custom-radio')]")
    public List<WebElement> allGenderRadioBtns;

    @FindBy(xpath = "//div[contains(@class,'custom-checkbox')]")
    public List<WebElement> allHobbiesCheckBox;

    @FindBy(id = "gender-radio-3")
    public WebElement gender;

    @FindBy(id = "userNumber")
    public WebElement mobileNumber;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dataBirth;

    @FindBy(id = "subjectsInput")
    public WebElement subject;

    @FindBy(id = "hobbies-checkbox-")
    public WebElement hobbiesChekBtn;

    @FindBy(id = "uploadPicture")
    public WebElement pictureBtn;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "state")
    public WebElement dropDownState;

    @FindBy(id = "city")
    public WebElement dropDownCity;

    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(xpath = "//div[contains(@id,'react-select-3-option-')]")
    public List<WebElement> allSelectStateElements;

    @FindBy(xpath = "//div[contains(@id,'react-select-4-option-')]")
    public List<WebElement> allSelectCityElements;

    @FindBy(xpath = "//td[contains(text(),'Student Name')]/following-sibling::td")
    public WebElement tableStudentFullName;

    @FindBy(xpath = "//td[contains(text(),'Student Email')]/following-sibling::td")
    public WebElement tableStudentEmail;

    @FindBy(xpath = "//div[contains(@class,'modal-title')]")
    public WebElement tableTitle;

    public PracticeFormPage fillUpPracticeForm(PracticeFormEntity practiceFormEntity) {
        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFirstName())
                .sendKeys(lastNameInput,practiceFormEntity.getLastName())
                .sendKeys(userEmailInput, practiceFormEntity.getEmail());
        selectRandomGender();
        webElementActions
                .sendKeys(mobileNumber, randomPhoneNumber());
        clickRandomHobbies();
        webElementActions
                .sendKeys(subject, practiceFormEntity.getSubject())
                .sendKeys(currentAddress, practiceFormEntity.getCurrentAddress());
        selectRandomStateAndCity();
        webElementActions.click(submit);

        Assert.assertTrue(tableTitle.getText().contains("Thanks for submitting the form"));
        Assert.assertTrue(tableStudentFullName.getText().contains(practiceFormEntity.getFirstName()));
        Assert.assertTrue(tableStudentFullName.getText().contains(practiceFormEntity.getLastName()));
        Assert.assertTrue(tableStudentEmail.getText().contains(practiceFormEntity.getEmail()));
        return this;
    }

    private void clickRandomElement(List<WebElement> elements) {
        if (!elements.isEmpty()) {
            int randomIndex = random.nextInt(elements.size());
            WebElement randomRadioBtn = elements.get(randomIndex);
            webElementActions.click(randomRadioBtn);
        }
    }

    public PracticeFormPage selectRandomStateAndCity() {
        webElementActions.click(dropDownState);
        clickRandomElement(allSelectStateElements);
        webElementActions.click(dropDownCity);
        clickRandomElement(allSelectCityElements);
        return this;
    }

    public PracticeFormPage selectRandomGender() {
        clickRandomElement(allGenderRadioBtns);
        return this;
    }

    public PracticeFormPage clickRandomHobbies() {
        if (!allHobbiesCheckBox.isEmpty()) {
            int numberOfCheckboxesToClick = random.nextInt(allHobbiesCheckBox.size()) + 1;
            List<WebElement> shuffledElements = allHobbiesCheckBox;
            Collections.shuffle(shuffledElements, random);
            for (int i = 0; i < numberOfCheckboxesToClick; i++) {
                WebElement checkbox = shuffledElements.get(i);
                checkbox.click();
            }
        }
        return this;
    }

    public String randomPhoneNumber() {
        long firstDigit = 1 + random.nextInt(9);
        long remainingDigits = (long) (random.nextDouble() * 1_000_000_000L);
        String randomNumber = String.valueOf(firstDigit * 1_000_000_000L + remainingDigits);
        return randomNumber;
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstName1Input;

    @FindBy(id = "lastName")
    public WebElement lastName1Input;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;



    public PracticeFormPage addNewEmployee(Employee employee){
        webElementActions.click(addNewBtn)
                .sendKeys(firstName1Input,employee.getFirstName())
                .sendKeys(lastName1Input,employee.getLastName())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(emailInput,employee.getEmail())
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput, employee.getDepartment())
                .click(submitBtn);
        return this;


    }

    public ArrayList<Employee> getEmployeesFromTable(){
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>();

        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName1 = cells.get(0).getText();
            String lastName1 = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]","");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if(firstName1.isEmpty() || lastName1.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()){
                continue;
            }
            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            employees.add(new Employee(firstName1, lastName1, age, email,salary, department));
        }
        return employees;
    }


}
