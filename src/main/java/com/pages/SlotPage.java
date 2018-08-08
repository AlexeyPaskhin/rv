package com.pages;

import com.Elements.Frame;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * page of opened Game
 */
@Getter
public class SlotPage extends AbstractPage {
private Frame gameFrame = new Frame(By.xpath("//iframe[@id='game_iframe']"));
}
