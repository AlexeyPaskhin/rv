package RulVulaknTests.homepage.topmenu;

import RulVulaknTests.BaseTestPage;
import com.pages.*;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TopMenuTest extends BaseTestPage {


    @Test
    public void checkGamesLink(){
        GamesPage gamesPage = new HomePage().getHeader().clickGamesLink();

        assertThat(gamesPage.GaminatorGamesExists(), is(true));
        assertThat(gamesPage.NewGamesExists(), is(true));
        assertThat(gamesPage.PopularGamesExsits(), is(true));
        assertThat(gamesPage.IgrosoftGamesExists(), is(true));
        assertThat(gamesPage.TablesGamesExists(),is(true));
        assertThat(gamesPage.SlotGamesExists(),is(true));

    }
    @Test
    public void checkLotteriesLink(){
        LotteriesPage lotteriesPage = new HomePage().getHeader().clickLotteriesLink();
        assertThat(lotteriesPage.bannerExists(), is(true));
        assertThat(lotteriesPage.lotteriesExists(), is(true));
        assertThat(lotteriesPage.paginationExists(),is(true));
        assertThat(lotteriesPage.lotteryResultsButtonExists(),is(true));
        assertThat(lotteriesPage.participateInLoterriesExists(),is(true));
    }
    @Test
    public void checkTournamentsLink(){
        TournamentsPage tournamentsPage = new HomePage().getHeader().clickTournametsLink();
        assertThat(tournamentsPage.BannerExists(), is(true));
        assertThat(tournamentsPage.TournamentsExists(),is(true));
        assertThat(tournamentsPage.PaginationExists(), is(true));

    }

    @Test
    public void checkNewsLink(){
        NewsPage newsPage = new HomePage().getHeader().clickNewsLink();
        assertThat(newsPage.BannerExists(), is(true));
        assertThat(newsPage.NewsExists(),is(true));
        assertThat(newsPage.PaginationExists(), is(true));
    }

    @Test
    public void checkVipLink(){
        VipPage vipPage = new HomePage().getHeader().clickVIPLink();
        assertThat(vipPage.getURL(), equalTo(customDataProvider.getBasicURL()+"vip"));
    }


}
