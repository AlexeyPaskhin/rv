package com.popups.cashBoxFrames;

import com.Elements.Frame;
import static com.utils.DriverManager.getDriver;

public interface SwithToFrame {
    default void swithToFrame(Frame frame){
        getDriver().switchTo().frame(frame.slaveElement());
    }

    default void swtichToParent(){
        getDriver().switchTo().defaultContent();
    }
}
