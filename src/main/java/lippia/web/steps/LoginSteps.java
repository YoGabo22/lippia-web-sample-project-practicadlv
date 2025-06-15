package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.ProductService;

public class LoginSteps {


    @Given("The client is in 'My Account' Menu")
    public void theClientIsInMyAccountMenu() {
        ProductService.clickMyAccount();

    }

    @And("The client click the Login button")
    public void theClientClickTheLoginButton() {
        ProductService.clickLogin();
    }

    @Then("Go to Home Page button")
    public void goToHomePageButton() {
        ProductService.clickHome();
    }

    @When("The client enters '(.*)' in the email textbox")
    public void theClientEntersEmailInTheEmailTextbox(String email) {
        ProductService.enterEmail(email);

    }

    @And("The client enters '(.*)' in the password textbox")
    public void theClientEntersPasswordInThePasswordTextbox(String password) {
        ProductService.enterPassword(password);
    }

    @Then("The Login must fail with a warning message '(.*)'")
    public void theLoginMustFailWithAWarningMessageMessage(String message) {
        ProductService.checkMessage(message);

    }

    @And("The client click the Logout button")
    public void theClientClickTheLogoutButton() {
        ProductService.clickLogout();
    }

    @And("The client press Back button")
    public void theClientPressBackButton() {
        ProductService.navigateBack();
    }

    @Then("The email textbox is clickable")
    public void theEmailTextboxIsClickable() {
        ProductService.checkEmailTextBox();
    }
}
