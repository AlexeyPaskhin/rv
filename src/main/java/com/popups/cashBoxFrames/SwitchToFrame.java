package com.popups.cashBoxFrames;

import com.Elements.Frame;
import static com.utils.DriverManager.getDriver;

public interface SwitchToFrame {
    default void switсhToFrame(Frame frame){
        getDriver().switchTo().frame(frame.slaveElement());
    }

    default void switchToParent(){
        getDriver().switchTo().defaultContent();
    }
}
