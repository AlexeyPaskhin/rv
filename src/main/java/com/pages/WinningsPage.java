package com.pages;

import com.Elements.Button;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class WinningsPage extends AbstractPage {
    private Button PLAY_GAME_BUTTON = new Button(By.xpath("//div[@class='winnings-item']//a[@class='btn-play']"));
    private Button LINK_GAME_TITLE = new Button(By.xpath("//div[@class='winnings-item']//h2/a"));
    private Button GAME_IMAGE = new Button(By.xpath("//div[@class='winnings-item']//img/.."));
}
