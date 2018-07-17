package com.pages.landing.social;

import com.pages.IAbstractPage;
import com.pages.mobile.HomeMobilePage;
import com.popups.ConfirmEmailPopup;

public interface SocialFrame extends IAbstractPage {

    SocialFrame setEmail(String email);

    SocialFrame setPassword(String password);

    ConfirmEmailPopup clickRegister();
    
    HomeMobilePage clickLogInMobile();

    /**
     * when we stay on a social page - for example, when go on our group in social network
     */
    SocialFrame clickLogInNotForVulkanAuth();


//    default void switchToSocialFrame() {
//        AbstractPage.parentWindow = getDriver().getWindowHandle();
//        for (String winHandle : getDriver().getWindowHandles()) {
//            switchToWindow(winHandle);
//        }
//        waitForPageToLoad();
//        String currURL = getURL();
//        if (currURL.contains("oauth.vk.com")) return new VkRegisterPage();
//        else if (currURL.contains("connect.ok.ru")) return new OKRegisterPage();
//        else if (currURL.contains("facebook.com")) return new FBregisterPage();
//        else if (currURL.contains("connect.mail.ru")) return new MailRuRegisterPage();
//        else if (currURL.contains("passport.yandex.ru")) return new YARegisterPage();
//        return null;
//    }

    ConfirmEmailPopup switchToConfirmEmail();
}
