package com.pages.mobile;

import com.Elements.Button;
import com.pages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class HomeMobilePage extends AbstractPage {
    public Button LOGIN_BUTTON = new Button(By.className("bottom-menu__login-btn"));
    public Button GAMES_BUTTON = new Button(By.xpath("//a[@class='bottom-menu__icon-btn' and @href='/games']"));
    public Button PROFILE_BUTTON = new Button(By.xpath("//a[@class='bottom-menu__icon-btn' and @href='/users/profile']"));

    public HomeMobilePage() {
        waitForPageToLoad();
    }

    @Step
    public AuthMobilePage clickLogin() {
        LOGIN_BUTTON.click();
        return new AuthMobilePage();
    }
}
