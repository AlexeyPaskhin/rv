package RulVulaknTests.gamespage;

import RulVulaknTests.BaseTestPage;
import com.pages.GamesPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class GamesPageTest extends BaseTestPage {
    @Test
    public void checkPopularGames(){
    GamesPage games = home.getHeader().clickGamesLink();
    assertThat(games.getAllPopularGames(), hasSize(20) );
    }

    @Test
    public void checkNewGames(){

    }

    @Test
    public void checkGaminatorGames(){

    }
    @Test
    public void checkIgrosoftGames(){

    }

    @Test
    public void checkSearch(){

    }
}
