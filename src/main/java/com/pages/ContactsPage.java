package com.pages;

import com.Elements.Button;
import com.Elements.Checkbox;
import com.Elements.Element;
import com.Elements.InputBox;
import com.pages.landing.social.*;
import com.popups.RedHelperFrame;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.utils.DriverManager.getDriver;

@Getter
public class ContactsPage extends AbstractPage {
    private Element feebackBlock = new Element(By.xpath("//div[@class='feedback-cont cf']"));
    private Button ONLINE_CONSULTANT = new Button(By.xpath("//span[text()='Онлайн консультант']/.."));
    private Button FB_GROUP_BUTTON = new Button(By.xpath("//div[@class='feedback-cont cf']//a[@title='Казино Русский Вулкан в Facebook']"));
    private Button TWITTER_GROUP_BUTTON = new Button(By.xpath("//div[@class='feedback-cont cf']//a[@title='Казино Русский Вулкан в Twitter']"));
    private Button OK_GROUP_BUTTON = new Button(By.xpath("//div[@class='feedback-cont cf']//a[@title='Казино Русский Вулкан в Одноклассниках']"));
    private Button VK_GROUP_BUTTON = new Button(By.xpath("//div[@class='feedback-cont cf']//a[@title='Казино Русский Вулкан в VK']"));
    private Button YOUTUBE_GROUP_BUTTON = new Button(By.xpath("//div[@class='feedback-cont cf']//a[@title='Казино Русский Вулкан на Youtube']"));
    private Button GOOGLE_GROUP_BUTTON = new Button(By.xpath("//div[@class='feedback-cont cf']//a[@title='Казино Русский Вулкан на Google+']"));
    private Button INSTAGRAM_GROUP_BUTTON = new Button(By.xpath("//div[@class='feedback-cont cf']//a[@title='Казино Русский Вулкан в Instagram']"));

    private Element EMPTY_NAME_ERROR_TEXT = new Element(By.xpath("//span[text()='Заполните имя']"));
    private Element INVALID_EMAIL_ERROR_TEXT = new Element(By.xpath("//span[text()='Заполните e-mail']/../span[@class='errors']")); //we may have different errors text in case of empty and invalid email
    private Element EMPTY_MESSAGE_FIELD_ERROR_TEXT = new Element(By.xpath("//span[text()='Заполните текст сообщения']"));
    private Element FAILED_CAPTCHA_ERROR_TEXT = new Element(By.xpath("//span[text()='Неправильно введена каптча либо вы не прошли проверку']"));

    private InputBox NAME_FIELD = new InputBox(By.xpath("//input[@id='feedback-name']"));
    private InputBox EMAIL_FIELD = new InputBox(By.xpath("//input[@id='feedback-email']"));
    private InputBox MESSAGE_FIELD = new InputBox(By.xpath("//textarea[@id='feedback-message']"));
    private Element CAPTCHA_IFRAME = new Element(By.xpath("//form[@data-form-role='feedback']//iframe"));
    private Checkbox CAPTCHA_CHECKBOX = new Checkbox(By.xpath("//div[@class='recaptcha-checkbox-checkmark']"));
    private Button SUBMIT_FEEDBACK_BUTTON = new Button(By.xpath("//form[@data-form-role='feedback']/button[@type='submit']"));

    public Boolean feedBackBlockIsDisplayed() {
        return feebackBlock.isVisible();
    }

    @Step
    public RedHelperFrame clickOnlineConsult() {
        ONLINE_CONSULTANT.click();
        return new RedHelperFrame();
    }

    @Step
    public FBregisterPage clickFbGroup() {
        FB_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new FBregisterPage();
    }

    @Step
    public TwitterGroupPage clickTwitterGroup() {
        TWITTER_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new TwitterGroupPage();
    }

    @Step
    public OKRegisterPage clickOkGroup() {
        OK_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new OKRegisterPage();
    }

    @Step
    public VkRegisterPage clickVkGroup() {
        VK_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new VkRegisterPage();
    }

    @Step
    public YoutubeGroupPage clickYoutubeGroup() {
        YOUTUBE_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new YoutubeGroupPage();
    }

    @Step
    public GoogleGroupPage clickGoogleGroup() {
        GOOGLE_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new GoogleGroupPage();
    }

    @Step
    public InstagramGroupPage clickInstagramGroup() {
        INSTAGRAM_GROUP_BUTTON.click();
        switchToSocialFrame();
        return new InstagramGroupPage();
    }

    @Step
    public ContactsPage setToNameField(String s) {
        NAME_FIELD.cleaIn();
        NAME_FIELD.fillIn(s);
        return this;
    }

    @Step
    public ContactsPage setToEmailField(String s) {
        EMAIL_FIELD.cleaIn();
        EMAIL_FIELD.fillIn(s);
        return this;
    }

    @Step
    public ContactsPage setToMessageField(String s) {
        MESSAGE_FIELD.cleaIn();
        MESSAGE_FIELD.fillIn(s);
        return this;
    }

    @Step
    public ContactsPage clickSubmit() {
        SUBMIT_FEEDBACK_BUTTON.click();
        return this;
    }

}
