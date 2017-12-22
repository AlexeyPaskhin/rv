package com.pages;

import com.Elements.Button;
import com.Elements.Panel;
import com.popups.FastRegisterPopup;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage{
   private final Button REGISTER_BUTTON= new Button(By.cssSelector(".btn-registration-top"));
   private final Panel USER_PANE = new Panel(By.xpath("//div[@class='top-user-zone']"));

   public FastRegisterPopup clickRegister(){
       REGISTER_BUTTON.click();
       return new FastRegisterPopup();
   }

  public boolean RegisterButtonIsPresent(){

       return REGISTER_BUTTON.isPresent();
  }

  public boolean UserZoneIsPresent(){

      return USER_PANE.isPresent();
  }

}
