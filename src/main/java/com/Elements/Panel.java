package com.Elements;

import org.openqa.selenium.By;


public class Panel extends Element {
    public Panel(By by) {
        super(by);
    }





    public Button getButtonByXpath(String xpath) {
        String fullXpath = getXpath(super.by) + xpath;
        return new Button(By.xpath(fullXpath));
    }

    public Panel getPanelByXpath(String xpath) {
        String fullXpath = getXpath(super.by) + xpath;
        return new Panel(By.xpath(fullXpath));
    }













    private  <T extends Element> T getElement(String xpath) {
        //TODO: Imeplement generic type of object
        String fullXpath = getXpath(super.by) + xpath;
        return (T)new Button(By.xpath(fullXpath));
    }
}
