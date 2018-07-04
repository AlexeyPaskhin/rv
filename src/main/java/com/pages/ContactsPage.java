package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import com.pages.landing.social.FBregisterPage;
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
        System.out.println(getDriver().getTitle());
        return new FBregisterPage();
    }
}
