package com.pages.landing.social;

import com.pages.AbstractPage;
import com.pages.IAbstractPage;
import com.popups.ConfirmEmailPopup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.utils.DriverManager.getDriver;

public interface SocialFrame extends IAbstractPage {
    SocialFrame setEmail(String email);

    SocialFrame setPassword(String password);

    ConfirmEmailPopup clickRegister();

    default SocialFrame swithToSocialFrame() {
        AbstractPage.parentWindow = getDriver().getWindowHandle();
        for (String winHandle : getDriver().getWindowHandles()) {
            swithToWindow(winHandle);
        }
        waitForPageToLoad();
        String currURL = getURL();
        if (currURL.contains("oauth.vk.com")) return new VkRegisterPage();
        else if (currURL.contains("connect.ok.ru")) return new OKRegisterPage();
        else if (currURL.contains("facebook.com")) return new FBregisterPage();
        else if (currURL.contains("connect.mail.ru")) return new MailRuRegisterPage();
        else if (currURL.contains("passport.yandex.ru")) return new YARegisterPage();
        return null;
    }

    ConfirmEmailPopup switchToConfirmEmail();
}
