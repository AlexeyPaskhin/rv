package RulVulaknTests.pages;

import RulVulaknTests.BaseTestPage;
import RulVulaknTests.authorization.AuthorizationData;
import com.listeners.RussianVulcanListener;
import com.pages.ContactsPage;
import com.pages.landing.social.*;
import com.popups.RedHelperFrame;
import com.utils.User;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners({RussianVulcanListener.class})
public class ContactsPageTest extends BaseTestPage {

    @Test(groups = {"regression"})
    @Description("open RedHelper via contacts panel")
    public void openRedHelper() {
        RedHelperFrame redHelperFrame = home.getHeader()
                .clickContactsLink()
                .clickOnlineConsult()
                .switchToRedHElperFrame();
        assertTrue(redHelperFrame.isRedHelperFrameOpened());
    }

    @Test(dataProvider = "authorizationUserForFB", dataProviderClass = AuthorizationData.class, groups = {"regression"})
    @Description("go To Our Fb Group via contacts panel")
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
    @Description("go To Our Twitter Group via contacts panel")
    public void goToOurTwitterGroup() {
        TwitterGroupPage twitterGroupPage = home.getHeader()
                .clickContactsLink()
                .clickTwitterGroup();
        assertEquals(twitterGroupPage.getURL(), customDataProvider.getTwitterGroupURL());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Ok Group via contacts panel")
    public void goToOurOkGroup() {
        OKRegisterPage okRegisterPage = home.getHeader()
                .clickContactsLink()
                .clickOkGroup();
        assertEquals(okRegisterPage.getURL(), customDataProvider.getOkGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Vk Group via contacts panel")
    public void goToOurVkGroup() {
        VkRegisterPage vkRegisterPage = home.getHeader()
                .clickContactsLink()
                .clickVkGroup();
        assertEquals(vkRegisterPage.getURL(), customDataProvider.getVkGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Youtube Group via contacts panel")
    public void goToOurYoutubeGroup() {
        YoutubeGroupPage youtubeGroupPage = home.getHeader()
                .clickContactsLink()
                .clickYoutubeGroup();
        assertEquals(youtubeGroupPage.getURL(), customDataProvider.getYoutubeGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Google Group via contacts panel")
    public void goToOurGoogleGroup() {
        GoogleGroupPage googleGroupPage= home.getHeader()
                .clickContactsLink()
                .clickGoogleGroup();
        assertEquals(googleGroupPage.getURL(), customDataProvider.getGoogleGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("go To Our Instagram Group via contacts panel")
    public void goToOurInstagramGroup() {
        InstagramGroupPage instagramGroupPage= home.getHeader()
                .clickContactsLink()
                .clickInstagramGroup();
        assertEquals(instagramGroupPage.getURL(), customDataProvider.getInstagramGroupUrl());
    }

    @Test(groups = {"regression"})
    @Description("submit Feedback Form With Empty Required Fields. we cannot deal with with captcha so we do nothing with it")
    public void submitFeedbackFormWithEmptyRequiredFields() {
        ContactsPage contactsPage = home.getHeader()
                .clickContactsLink()
                .setToNameField("")
                .setToEmailField("")
                .setToMessageField("")
                .clickSubmit();
        assertTrue(contactsPage.getEMPTY_NAME_ERROR_TEXT().isPresent());
        assertTrue(contactsPage.getINVALID_EMAIL_ERROR_TEXT().isPresent());
        assertTrue(contactsPage.getEMPTY_MESSAGE_FIELD_ERROR_TEXT().isPresent());
        assertTrue(contactsPage.getFAILED_CAPTCHA_ERROR_TEXT().isPresent());
    }

    @Test(groups = {"regression"})
    @Description("submit Feedback Form With Empty Required Fields. we cannot deal with with captcha so we do nothing with it")
    public void submitFeedbackFormWithInvalidEmail() {
        ContactsPage contactsPage = home.getHeader()
                .clickContactsLink()
                .setToEmailField(customDataProvider.getEmail()+"@")
                .clickSubmit();
        assertTrue(contactsPage.getINVALID_EMAIL_ERROR_TEXT().isPresent());
    }

}
