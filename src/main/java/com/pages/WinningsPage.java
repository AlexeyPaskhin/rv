package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.utils.DriverManager.getDriver;
import static org.testng.Assert.assertTrue;

@Getter
public class WinningsPage extends AbstractPage {
    private Button PLAY_GAME_BUTTON = new Button(By.xpath("//div[@class='winnings-item']//a[@class='btn-play']"));
    private Button LINK_GAME_TITLE = new Button(By.xpath("//div[@class='winnings-item']//h2/a"));
    private Button GAME_IMAGE = new Button(By.xpath("//div[@class='winnings-item']//img/.."));

    public List<Element> goToGamesLinks() {
        List<Element> brokenElements = new ArrayList<>();
        for (Element link : getLINK_GAME_TITLE().getAllElements()) {
            String gameTitle = link.getText();
            String[] splitKeywords = gameTitle.split("\\W+");  //we receive in some game titles special characters that doesn't match with page title so we delete them
            link.click();
            for (String keyWord : splitKeywords) {
                if(!getDriver().getTitle().contains(keyWord)) {
                    brokenElements.add(link);
                }
            }
            goBack();
        }
        return brokenElements;
    }

    public List<Element> clickGamesImages() {
        List<Element> brokenElements = new ArrayList<>();
        for (Element image : getGAME_IMAGE().getAllElements()) {
            String gameTitle = image.getSubElementByXpath("/img").getAttribute("title");
            String[] splitKeywords = gameTitle.split("\\W+");  //we receive in some game titles special characters that doesn't match with page title so we delete them
            image.click();
            for (String keyWord : splitKeywords) {
                if(!getDriver().getTitle().contains(keyWord)) {
                    brokenElements.add(image);
                }
            }
            goBack();
        }
        return brokenElements;
    }

    public List<Element> clickPlayButtons() {
        List<Element> brokenElements = new ArrayList<>();
        for (Element button : getPLAY_GAME_BUTTON().getAllElements()) {
            String gameTitle = button.getSubElementByXpath("/../..//a").getText();
            String[] splitKeywords = gameTitle.split("\\W+");  //we receive in some game titles special characters that doesn't match with page title so we delete them
            button.click();
            for (String keyWord : splitKeywords) {
                if(!getDriver().getTitle().contains(keyWord)) {
                    brokenElements.add(button);
                }
            }
            goBack();
        }
        return brokenElements;
    }

}
