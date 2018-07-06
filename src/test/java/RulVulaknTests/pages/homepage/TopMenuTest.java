package RulVulaknTests.pages.homepage;

import RulVulaknTests.BaseTestPage;
import com.pages.*;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TopMenuTest extends BaseTestPage {

    @Test(groups = {"regression"})
    public void checkGamesLink() {
        GamesPage gamesPage = new HomePage().getHeader().clickGamesLink();

        assertThat(gamesPage.GaminatorGamesExists(), is(true));
        assertThat(gamesPage.NewGamesExists(), is(true));
        assertThat(gamesPage.PopularGamesExsits(), is(true));
        assertThat(gamesPage.IgrosoftGamesExists(), is(true));
        assertThat(gamesPage.TablesGamesExists(), is(true));
        assertThat(gamesPage.SlotGamesExists(), is(true));
    }

    @Test(groups = {"regression"})
    public void checkLotteriesLink() {
        LotteriesPage lotteriesPage = new HomePage().getHeader().clickLotteriesLink();

//        assertThat(lotteriesPage.bannerExists(), is(true)); // only if DO NOT DEFAULT banner present
        assertThat(lotteriesPage.lotteriesExists(), is(true));
        assertThat(lotteriesPage.paginationExists(), is(true));
        assertThat(lotteriesPage.lotteryResultsButtonExists(), is(true));
        assertThat(lotteriesPage.participateInLoterriesExists(), is(true));
    }

    @Test(groups = {"regression"})
    public void checkTournamentsLink() {
        TournamentsPage tournamentsPage = new HomePage().getHeader().clickTournametsLink();

//        assertThat(tournamentsPage.BannerExists(), is(true)); // only if banner present
        assertThat(tournamentsPage.tournamentsExists(), is(true));
        assertThat(tournamentsPage.paginationExists(), is(true));
    }

    @Test(groups = {"regression"})
    public void checkNewsLink() {
        NewsPage newsPage = new HomePage().getHeader().clickNewsLink();

        assertThat(newsPage.BannerExists(), is(true));
        assertThat(newsPage.NewsExists(), is(true));
        assertThat(newsPage.PaginationExists(), is(true));
    }

    @Test(groups = {"regression"})
    public void checkVipLink() {
        VipPage vipPage = new HomePage().getHeader().clickVIPLink();

        assertThat(vipPage.getURL(), equalTo(customDataProvider.getBasicURL() + "vip"));
    }
}
