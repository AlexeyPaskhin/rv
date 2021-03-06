package com.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class InputBox extends Element {
    public InputBox(By by) {
        super(by);
    }

    public void fillIn(String text) {
        sendKeys(text);
    }

    public void pressEnter() {
        slaveElement().sendKeys(Keys.ENTER);
    }

    public void fillInAndPressEnter(String text) {
        fillIn(text);
        pressEnter();
    }

    public void cleaIn(){
        while (!slaveElement().getAttribute("value").equals("")) {
            slaveElement().sendKeys(Keys.chord(Keys.CONTROL, "a"));
            slaveElement().sendKeys(Keys.BACK_SPACE);
        }
    }
}
