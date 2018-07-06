package com.pages;

import com.Elements.Element;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class ContactsPage extends AbstractPage {
    Element feebackBlock = new Element(By.xpath("//div[@class='feedback-cont cf']"));


    public Boolean feedBackPageIsDisplayed() {
        return feebackBlock.isVisible();
    }

}
