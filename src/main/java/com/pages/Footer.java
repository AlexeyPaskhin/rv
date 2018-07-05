package com.pages;

import com.Elements.Button;
import org.openqa.selenium.By;

public class Footer extends AbstractPage {
    Button FB_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан в Facebook']"));
    Button TWITTER_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан в Twitter']"));
    Button OK_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан в Одноклассниках']"));
    Button VK_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан в VK']"));
    Button YOUTUBE_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан на Youtube']"));
    Button GOOGLE_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан на Google+']"));
    Button INSTAGRAM_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан в Instagram']"));


}
