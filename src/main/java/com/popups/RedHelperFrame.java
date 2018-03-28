package com.popups;

import com.Elements.Element;
import com.Elements.Frame;
import com.pages.AbstractPage;
import com.popups.cashBoxFrames.SwitchToFrame;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Red Helper - chat for support
 */

public class RedHelperFrame extends AbstractPage implements SwitchToFrame {
    private Frame RED_HELPER_FRAME = new Frame(By.xpath("//iframe[@id='rh-chatFrame']"));
    private final Element RED_HELPER_ONLINE_PANEL = new Element(By.xpath("//div[@id='online']"));

    @Step
    public RedHelperFrame switchToRedHElperFrame() {
        switсhToFrame(RED_HELPER_FRAME);
        return new RedHelperFrame();
    }

    public boolean isRedHelperFrameOpened() {
        return RED_HELPER_ONLINE_PANEL.isPresent();
    }
}
