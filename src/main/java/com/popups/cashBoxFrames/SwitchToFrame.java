package com.popups.cashBoxFrames;

import com.Elements.Frame;
import static com.utils.DriverManager.getDriver;

/**
 * Created by ai on 2018-01-17.
 */
public interface SwitchToFrame {
    default void switсhToFrame(Frame frame){
        getDriver().switchTo().frame(frame.slaveElement());
    }

    default void switchToParent(){
        getDriver().switchTo().defaultContent();
    }
}
