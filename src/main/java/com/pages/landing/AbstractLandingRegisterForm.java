package com.pages.landing;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.InputBox;
import com.Elements.RadioButton;
import com.pages.AbstractPage;
import com.pages.landing.social.SocialFrame;
import com.pages.landing.social.VkRegisterPage;
import com.popups.GiftPopup;
import org.openqa.selenium.By;

public abstract class AbstractLandingRegisterForm extends AbstractPage{
//    private final InputBox EMAIL_INPUT ;
//    private final InputBox PASSWORD_INPUT;
//    private final RadioButton CURRENCY_RUB_RADIO ;
//    private final RadioButton CURRENCY_USD_RADIO ;
//    private final Checkbox AGREE_CHECKBOX ;
//    private final Button REGISTER_BUTTON ;
//
//    public FastRegister typeLogin(String login) {
//        EMAIL_INPUT.fillIn(login);
//        return this;
//    }
//
//    public FastRegister typePass(String pass) {
//        PASSWORD_INPUT.fillIn(pass);
//        return this;
//    }
//
//    public FastRegister selectCurrencyRUB() {
//        CURRENCY_RUB_RADIO.click();
//        return this;
//    }
//
//    public FastRegister selectCurrencyUSD() {
//        CURRENCY_USD_RADIO.click();
//        return this;
//
//    }
//
//    public FastRegister agreeWithRules() {
//        AGREE_CHECKBOX.click();
//        return this;
//    }
//
//    public GiftPopup clickRegisterButtonToGift() {
//        //wait(1500);
//        REGISTER_BUTTON.clickUntilDisappeared();
//        return new GiftPopup();
//    }
//
//    public SocialFrame swithToSocialFrame() {
//        parentWindow = handleCurrentWindow();
//        swithToWindow(SOCIAL_LOGIN_WINDOW);
//        String currURL = getURL();
//        if (currURL.contains("oauth.vk.com")) return new VkRegisterPage();
//        return null;
//    }

}
