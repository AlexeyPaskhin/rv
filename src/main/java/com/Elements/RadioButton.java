package com.Elements;

import org.openqa.selenium.By;

public class RadioButton extends Element {
    public RadioButton(By by) {
        super(by);
    }

    public void check() {
        if (!slaveElement().isSelected()) {
            slaveElement().click();
        }
    }
}
