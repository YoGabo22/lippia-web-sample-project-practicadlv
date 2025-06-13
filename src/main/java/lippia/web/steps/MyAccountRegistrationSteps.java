package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.ProductService;

public class MyAccountRegistrationSteps {

    @Given("The client is in My Account Menu")
    public void theClientIsInMyAccountMenu() {
        ProductService.clickMyAccount();

    }


    @When("The client enters '(.*)' in the register email textbox")
    public void theClientEntersEmailsInTheRegisterEmailTextbox(String email) {
        ProductService.enterRegisterEmail(email);
}

    @And("The client enters '(.*)' in the register password textbox")
    public void theClientEntersPasswordsInTheRegisterPasswordTextbox(String password) {
        ProductService.enterRegisterPassword(password);
    }

    @Then("The registration must fail with a warning message {string}")
    public void theRegistrationMustFailWithAWarningMessageMessage(String message) {
        ProductService.checkRegisterkMessage(message);
    }
}
