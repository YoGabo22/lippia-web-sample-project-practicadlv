package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.ProductService;

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

    @When("The client click the Add to Basket button of (.*) in Shop Page")
    public void theClientClickTheAddToBasketButtonOfBookNameInShopPage(String shopBook) {
        ProductService.clickShopBook(shopBook);
    }

    @And("The client click on Basket button in Shop Page")
    public void theClientClickOnBasketButtonInShopPage() {
        ProductService.clickBasket();
    }

    @And("Check taxes value")
    public void checkTaxesValue() {
        ProductService.checkDefaultTaxes();
    }

    @And("The client select Argentina country")
    public void theClientSelectArgentinaCountry() {
        ProductService.selectArgentinaCountry();
    }

    @Then("The client check the taxes are lower in India")
    public void theClientCheckTheTaxesAreLowerInIndia() {
        ProductService.checkFinalTaxes();

    }
}
