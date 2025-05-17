package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.PracticeHomeService;
import lippia.web.services.ProductService;

public class PracticeHomeSteps extends PageSteps {

    @Given("The client is in the Home Page")
    public void theClientIsInTheHomePage() {
        PracticeHomeService.navigateToHomePage();
    }

    @When("The client tap on Shop menu button")
    public void theClientTapOnShopMenuButton() {
        ProductService.clickShop();
    }

    @And("The client tap on Home menu button")
    public void theClientTapOnHomeMenuButton() {
        ProductService.clickHome();

    }

    @And("The client click the Add to Basket button")
    public void theClientClickTheAddToBasketButton() {
        ProductService.clickAddToBasket();
    }



    @Then("The client view the Home Page has '(.*)' Sliders only")
    public void theClientViewTheHomePageHasThreeSlidersOnly(int qSliders) {
        PracticeHomeService.checksliders(qSliders);
    }


    @Then("The client view the Home Page has '(.*)' Arrivals only")
    public void theClientViewTheHomePageHasArrivalsOnly(int qArrivals) {
        PracticeHomeService.checksArrivals(qArrivals);

    }

    @When("The client click in the image (.*) in the Arrivals")
    public void theClientClickInTheImageBookNameInTheArrivals(String book) {
        ProductService.clickBookName(book);

    }

    @And("The client increments Quantity value to '(.*)'")
    public void theClientIncrementsQuantityValueTo(int quantity) {
        ProductService.setBookQuantity(quantity);




    }

    @And("The client click on View Basket button")
    public void theClientClickOnViewBasketButton() {
        ProductService.clickViewBasket();
    }

    @And("The client click on Update Basket to reflect changes")
    public void theClientClickOnUpdateBasketToReflectChanges() {
        ProductService.clickUpdateBasket();
    }


    @Then("The Quantity change to '(.*)' value")
    public void theQuantityChangeToBooksQuantityValue(int quantity) {
        ProductService.checkQuantity(quantity);


    }
}
