package com.pages.mobile;

import com.Elements.Button;
import com.Elements.Panel;
import com.pages.AbstractPage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.utils.DriverManager.setImplicity;


@Getter
public class HomeMobilePage extends AbstractPage {
    private Button LOGIN_BUTTON = new Button(By.className("bottom-menu__login-btn"));
    private Button REGISTER_BUTTON = new Button(By.className("bottom-menu__registr-btn"));
    private Button GAMES_BUTTON = new Button(By.xpath("//a[@class='bottom-menu__icon-btn' and @href='/games']"));
    private Button PROFILE_BUTTON = new Button(By.xpath("//a[@class='bottom-menu__icon-btn' and @href='/users/profile']"));
    private Panel FIRST_BONUS_PANEL = new Panel(By.id("hundred-bonus-popup"));

    public HomeMobilePage() {
        waitForPageToLoad();
    }

    @Step
    public AuthMobilePage clickLogin() {
        LOGIN_BUTTON.click();
        return new AuthMobilePage();
    }

    @Step
    public RegisterMobilePage clickRegister() {
        REGISTER_BUTTON.click();
        return new RegisterMobilePage();
    }

    @Step
    public boolean firstBonusPanelIsPresent() {
        refreshPage();
        waitForPageToLoad();
        return FIRST_BONUS_PANEL.isPresent();
    }

}
