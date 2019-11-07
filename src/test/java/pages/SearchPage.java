package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;


public class SearchPage {

    String keyword;

    public void openJustEatUrl(String url){
        open(url);
    }

    public void addTextToTheSearchField(String keyword){
        this.keyword = keyword;
        $(By.cssSelector("[data-test-id='address-box-input']")).val(keyword);
    }

    public void clickOnSearchButton() {
        $(By.cssSelector("[data-test-id='find-restaurants-button']")).click();
    }

    public void checkQueryResult(String query) {
        $$(By.cssSelector("[data-test-id='restaurant_info']")).shouldHave(sizeGreaterThan(1));
        $(".c-dishSearch-locationHeader-title").getText().contains(query);
    }

    public void deleteTextFromSearchField() {
        $(By.cssSelector("[data-test-id='address-box-input']")).clear();
        $(By.cssSelector("[data-test-id='find-restaurants-button']")).click();
    }

    public void getErrorMessage() {
        $(By.id("errorMessage")).shouldHave(Condition.text("Please enter a full, valid postcode"));
    }
}
