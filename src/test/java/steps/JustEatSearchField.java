package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SearchPage;

public class JustEatSearchField {
    private SearchPage searchPage = new SearchPage();

    @Given("^User is open search \"([^\"]*)\"$")
    public void openJustEatUrl(String url) {
        searchPage.openJustEatUrl(url);
    }

    @Given("^I want food in (.*)$")
    public void enterKeyWordToInputField(String keyword) {
        searchPage.addTextToTheSearchField(keyword);
    }

    @When("I search for restaurants")
    public void clickOnSearchButton() {
        searchPage.clickOnSearchButton();
    }

    @When("I delete text from search field and click search button")
    public void deleteText() {
        searchPage.deleteTextFromSearchField();
    }

    @Then("I should see some restaurants in (.*)$")
    public void listOfRestaraunts(String query) {
        searchPage.checkQueryResult(query);
    }

    @Then("I should see error message")
    public void errorMessage() {
        searchPage.getErrorMessage();
    }
}