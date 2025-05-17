package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.actions.WebActionManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.constants.ProductConstants;
import lippia.web.services.ProductService;
import lippia.web.services.ShopService;
import lippia.web.services.SuperiorBarNavigationBarService;

public class ShopSteps extends PageSteps {

    @And("The client is in Shop Menu")
    public void theClientIsInShopMenu() {
        ProductService.clickShop();
    }

    @When("The client click on '(.*)' button")
    public void theClientClickOnCategoryButton(String selectedCategory) {
        ProductService.clickCategories(selectedCategory);


    }

    @Then("The client is in the '(.*)' Page")
    public void theClientIsInTheCategoryPage(String selectedCategory) {
        ProductService.checkCategories(selectedCategory);
    }

    @When("The client click on sorting '(.*)' button")
    public void theClientClickOnSortingSortCategoryButton(String SortCategory) {
        ProductService.clickSortCategory(SortCategory);
    }

    @Then("The client see the Shop Page sorting by '(.*)'")
    public void theClientSeeTheShopPageSortingBySortCategory(String selectedSorting) {
        ProductService.checkSorting(selectedSorting);
    }
}
