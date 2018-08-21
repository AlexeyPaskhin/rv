package com.pages;

import com.Elements.Element;
import com.Elements.Frame;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * page of opened Game
 */
@Getter
public class SlotPage extends AbstractPage {
private Frame gameFrame = new Frame(By.xpath("//iframe[@id='game_iframe']"));
private Element BOOONGO_INNER_CONTENT = new Element(By.xpath("//div[@class='gr-viewport']"));
private Element GGS_INNER_CONTENT = new Element(By.xpath("//div[@id='container']"));

public SlotPage switchToGameFrame() {
    gameFrame.waitForFrameToBeAvailableAndSwitchToIt(10);
    return this;
}

}
