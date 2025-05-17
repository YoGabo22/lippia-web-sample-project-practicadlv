package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.ProductConstants;
import org.testng.Assert;


public class ProductService {
    static String PrevNumberBasket;
    static String PrevTotalBasket;
    static String NewNumberBasket;
    static String NewTotalBasket;

    public static void clickAddToBasket() {
        WebActionManager.getElement(ProductConstants.ADD_TO_BASKET_BUTTON).click();
    }

    public static void clickShop() {
        WebActionManager.getElement(ProductConstants.SHOP_BUTTON).click();
    }

    public static void clickBookName(String book) {

        switch (book) {
            case "Selenium Ruby":
                WebActionManager.getElement(ProductConstants.SELENIUM_RUBY_BUTTON).click();
                break;
            case "Thinking in HTML":
                WebActionManager.getElement(ProductConstants.THINKING_HTML_BUTTON).click();
                break;
            case "Mastering JavaScript":
                WebActionManager.getElement(ProductConstants.MASTERING_JAVASCRIPT_BUTTON).click();
                break;

        }


    }


    public static void clickViewBasket() {
        WebActionManager.getElement(ProductConstants.VIEW_BASKET_BUTTON).click();
    }

    public static void clickUpdateBasket() {
        //Generar variable de clase de antes de update de la cantidad de items
        WebActionManager.getElement(ProductConstants.UPDATE_BASKET_BUTTON).click();
        var qBasketNew = WebActionManager.getElement(ProductConstants.QUANTITY_BASKET);
        var tBasketNew = WebActionManager.getElement(ProductConstants.TOTAL_BASKET);
        NewNumberBasket = qBasketNew.getText();
        NewTotalBasket = tBasketNew.getText();


    }

    public static void clickMyAccount() {
        WebActionManager.getElement(ProductConstants.MY_ACCOUNT_BUTTON).click();

    }


    public static void setBookQuantity(int quantity) {
        var qBasket = WebActionManager.getElement(ProductConstants.QUANTITY_BASKET);
        var tBasket = WebActionManager.getElement(ProductConstants.TOTAL_BASKET);
        PrevNumberBasket = qBasket.getText();
        PrevTotalBasket = tBasket.getText();
        qBasket.click();
        qBasket.clear();
        qBasket.sendKeys("4");

    }

    public static void checkBasket(boolean checknums, boolean checknums2) {
        Assert.assertNotEquals(PrevTotalBasket, NewTotalBasket);
        Assert.assertNotEquals(PrevNumberBasket, NewNumberBasket);

    }

    public static void clickHome() {
        WebActionManager.getElement(ProductConstants.HOME_BUTTON).click();

    }


    public static void clickLogin() {
        WebActionManager.getElement(ProductConstants.LOGIN_BUTTON).click();
    }

    public static void enterEmail(String emails) {
        var emailTextbox = WebActionManager.getElement(ProductConstants.EMAIL_TEXTBOX);
        emailTextbox.click();
        emailTextbox.sendKeys(emails);
    }

    public static void enterPassword(String passwords) {
        var passwordTextbox = WebActionManager.getElement(ProductConstants.PASSWORD_TEXTBOX);
        passwordTextbox.click();
        passwordTextbox.sendKeys(passwords);

    }

    public static void checkMessage(String message) {
        var errorMessages = WebActionManager.getText(ProductConstants.ERROR_MESSAGE);
        Assert.assertEquals(message, errorMessages);

    }


    public static void checkQuantity(int quantity) {
        var quantityStr = WebActionManager.getAttribute(ProductConstants.QUANTITY_BASKET, "value");
        var quantityNum = Integer.parseInt(quantityStr);
        Assert.assertEquals(quantity, quantityNum);

    }

    public static void clickCategories(String selectedCategory) {
        switch (selectedCategory) {
            case "Android":
                WebActionManager.getElement(ProductConstants.ANDROID_CATEGORY_BUTTON).click();
                break;
            case "HTML":
                WebActionManager.getElement(ProductConstants.HTML_CATEGORY_BUTTON).click();
                break;
            case "JavaScript":
                WebActionManager.getElement(ProductConstants.JAVASCRIPT_CATEGORY_BUTTON).click();
                break;
            case "selenium":
                WebActionManager.getElement(ProductConstants.SELENIUM_CATEGORY_BUTTON).click();
                break;

        }


    }

    public static void checkCategories(String selectedCategory) {
        var actualCategory = WebActionManager.getText(ProductConstants.SELECTED_SHOP_CATEGORY);
        Assert.assertEquals("Home / " + selectedCategory, actualCategory);
    }

    public static void clickSortCategory(String sortCategory) {
        switch (sortCategory) {
            case "Sort by popularity":
                WebActionManager.getElement(ProductConstants.POPULARITY_DROPDOWN_BUTTON).click();
                break;
            case "Sort by average rating":
                WebActionManager.getElement(ProductConstants.RATING_DROPDOWN_BUTTON).click();
                break;
            case "Sort by newness":
                WebActionManager.getElement(ProductConstants.NEWNESS_DROPDOWN_BUTTON).click();
                break;
            case "Sort by price: low to high":
                WebActionManager.getElement(ProductConstants.LOWTOHIGH_DROPDOWN_BUTTON).click();
                break;
            case "Sort by price: high to low":
                WebActionManager.getElement(ProductConstants.HIGHTOLOW_DROPDOWN_BUTTON).click();
                break;


        }

    }

    public static void checkSorting(String selectedSorting) {
        switch (selectedSorting) {
            case "Sort by popularity":
                Assert.assertEquals(DriverManager.getDriverInstance().getCurrentUrl(), "https://practice.automationtesting.in/shop/?orderby=popularity");
                break;
            case "Sort by average rating":
                Assert.assertEquals(DriverManager.getDriverInstance().getCurrentUrl(), "https://practice.automationtesting.in/shop/?orderby=rating");
                break;
            case "Sort by newness":
                Assert.assertEquals(DriverManager.getDriverInstance().getCurrentUrl(), "https://practice.automationtesting.in/shop/?orderby=date");

                break;
            case "Sort by price: low to high":
                Assert.assertEquals(DriverManager.getDriverInstance().getCurrentUrl(), "https://practice.automationtesting.in/shop/?orderby=price");
                break;
            case "Sort by price: high to low":
                Assert.assertEquals(DriverManager.getDriverInstance().getCurrentUrl(), "https://practice.automationtesting.in/shop/?orderby=price-desc");
                break;


        }
    }
}
