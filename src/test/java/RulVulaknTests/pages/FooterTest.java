package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import com.pages.landing.social.OKRegisterPage;
import com.pages.landing.social.SocialFrame;
import com.pages.landing.social.VkRegisterPage;
import com.utils.User;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FooterTest extends BaseTestPage {

    @Test(dataProvider = "authorizationUserForFB", dataProviderClass = AuthorizationData.class, groups = {"regression"})
    @Description("go To Our Fb Group via footer")
    public void goToOurFbGroup(User user) {
        SocialFrame socialFrame = home.getHeader()
                .clickContactsLink()
                .clickFbGroup()
                .setEmail(user.getLogin())
                .setPassword(user.getPass())
                .clickLogIn();
        assertEquals(socialFrame.getURL(), customDataProvider.getFbGroupURL());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Twitter Group via footer")
    public void goToOurTwitterGroup() {
        TwitterGroupPage twitterGroupPage = home.getHeader()
                .clickContactsLink()
                .clickTwitterGroup();
        assertEquals(twitterGroupPage.getURL(), customDataProvider.getTwitterGroupURL());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Ok Group via footer")
    public void goToOurOkGroup() {
        OKRegisterPage okRegisterPage = home.getHeader()
                .clickContactsLink()
                .clickOkGroup();
        assertEquals(okRegisterPage.getURL(), customDataProvider.getOkGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Vk Group via footer")
    public void goToOurVkGroup() {
        VkRegisterPage vkRegisterPage = home.getHeader()
                .clickContactsLink()
                .clickVkGroup();
        assertEquals(vkRegisterPage.getURL(), customDataProvider.getVkGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Youtube Group via footer")
    public void goToOurYoutubeGroup() {
        YoutubeGroupPage youtubeGroupPage = home.getHeader()
                .clickContactsLink()
                .clickYoutubeGroup();
        assertEquals(youtubeGroupPage.getURL(), customDataProvider.getYoutubeGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Google Group via footer")
    public void goToOurGoogleGroup() {
        GoogleGroupPage googleGroupPage= home.getHeader()
                .clickContactsLink()
                .clickGoogleGroup();
        assertEquals(googleGroupPage.getURL(), customDataProvider.getGoogleGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Instagram Group via footer")
    public void goToOurInstagramGroup() {
        InstagramGroupPage instagramGroupPage= home.getHeader()
                .clickContactsLink()
                .clickInstagramGroup();
        assertEquals(instagramGroupPage.getURL(), customDataProvider.getInstagramGroupUrl());
    }
}
