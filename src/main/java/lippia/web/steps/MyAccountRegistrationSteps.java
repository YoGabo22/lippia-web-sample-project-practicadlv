package lippia.web.steps;

import com.crowdar.core.actions.WebActionManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lippia.web.services.ProductService;

public class MyAccountRegistrationSteps {

    @Given("The client is in My Account Menu")
    public void theClientIsInMyAccountMenu() {
        ProductService.clickMyAccount();

    }


}
