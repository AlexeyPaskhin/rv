package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.Elements.Panel;
import com.popups.WelcomeBonusGiftPopup;
import com.popups.RedHelperFrame;
import com.utils.User;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class HomePage extends AbstractPage {
    private final Panel CONTENT_PANE = new Panel(By.xpath("//div[@class='wrap cf']"));
    private final WelcomeBonusGiftPopup WELCOME_BONUS_GIFT_POPUP = new WelcomeBonusGiftPopup();

    private final Button RED_HELPER_BUTTON = new Button(By.xpath("//*[@id=\"rh-badge\"]//img"));
    private final String HOME_PAGE_TITLE_NOT_AUTHORIZAD_USER = "Казино Вулкан: официальный сайт Русского Вулкана – казино онлайн";
    private final String HOME_PAGE_TITLE_FOR_AUTHORIZED_USER = "Игровые автоматы Вулкан бесплатно и на деньги";

    public Element CAROUSEL_NOT_AUTH = new Element(By.xpath("//div[@class='slider']//div[@class='overview']"));
    public Element WINNERS_OF_DAY = new Element(By.xpath("//div[@class='winners']//div[@class='overview']"));
    public Button ALL_GAMES_BUTTON = new Button(By.xpath("//span[text()='Все игры']/.."));
    public Element GAME_ITEM = new Element(By.xpath("//div[@class='games-block']//div[@class='item-wrap   ']"));


    public HeaderAuthorizedUser logInUser(User user) {
        return getNotAuthorizedHeader()
                .typeEmailInHeadField(user.getLogin())
                .typePassInHeadField(user.getPass())
                .clickLogin()
                .getAuthorizedHeader();
    }

    public HeaderAuthorizedUser logInUser(String login, String pass) {
        return getNotAuthorizedHeader()
                .typeEmailInHeadField(login)
                .typePassInHeadField(pass)
                .clickLogin()
                .getAuthorizedHeader();
    }

    public HomePage registerUser(User user) {
        return getNotAuthorizedHeader()
                .clickRegister()
                .typeLogin(user.getLogin())
                .typePass(user.getPass())
                .agreeWithRules()
                .selectCurrencyRUB()
                .clickRegisterButton()
                .pressPlayWithBonus();
    }

    public HeaderNotAutorizedUser getNotAuthorizedHeader() {
        return new HeaderNotAutorizedUser();
    }

    public HeaderAuthorizedUser getAuthorizedHeader() {
        return new HeaderAuthorizedUser();
    }

    public Header getHeader() {
        if (getAuthorizedHeader().getCASH_BOX_BUTTON().isPresent()) return getAuthorizedHeader();
        else return getNotAuthorizedHeader();
    }

    public WelcomeBonusGiftPopup getWelcomeBonusGiftPopup() {
        return WELCOME_BONUS_GIFT_POPUP;
    }

    public void waitForHomePageLoaded() {
        CONTENT_PANE.waitForElementToBeVisible(15);
        PRELOADER.waitForElementToBeInvisible(10);
    }

    @Step
    public Boolean isNomePageLoaded() {
        return CONTENT_PANE.isVisible();
    }

    @Step
    public RedHelperFrame openRedHelperFrame() {
        if (RED_HELPER_BUTTON.isVisible()) {
            RED_HELPER_BUTTON.click();
        } else {
            RED_HELPER_BUTTON.waitForElementToBeClickable(3);
            RED_HELPER_BUTTON.click();
        }
        return new RedHelperFrame();
    }

    @Step
    public boolean isHomePageOpenedForNotAuthorized() {
        return this.getTitle().equals(HOME_PAGE_TITLE_NOT_AUTHORIZAD_USER);
    }

    @Step
    public boolean isHomePageOpenedForAuthorizedUser() {
        return this.getTitle().equals(HOME_PAGE_TITLE_FOR_AUTHORIZED_USER);
    }

    public HomePage clickAllGamesButton() {
        ALL_GAMES_BUTTON.click();
        return this;
    }
}
