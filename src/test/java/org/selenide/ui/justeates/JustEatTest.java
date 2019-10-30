package org.selenide.ui.justeates;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class JustEatTest {
  @Test
  public void searchField() {
    open("https://just-eat.es/");
    $(By.cssSelector("[data-test-id='address']")).val("Madrid Etorbidea, 28012, Donostia-San Sebastian, Spain");
    $(By.cssSelector("[data-test-id='submit']")).click();
    $(By.cssSelector("[data-test-id='streetNumber']")).val("2").pressEnter();
    $$("[data-test-id='restaurant_info']").shouldHave(sizeGreaterThan(1));

  }
}