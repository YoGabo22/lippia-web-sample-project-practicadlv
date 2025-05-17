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

    @Then("The registration must fail with a warning message '(.*)'")
    public void theRegistrationMustFailWithAWarningMessageMessage(String message) {
        ProductService.checkMessage(message);

    }
}
