package RulVulaknTests.achievements.collections;

import com.utils.CustomDataProvider;
import com.utils.User;
import org.testng.annotations.DataProvider;

public class UserAndGamesForCollections {

    @DataProvider
    public Object[][] userAndGamesForCollectionsProvider() {
        User user = new User().generateRandomUser(new CustomDataProvider());
        return new Object[][] {
                {"fruit-cocktail", "fruit_cocktail", "fruit_cocktail", "ggs",  user},
                {"book-of-ra", "book_of_ra", "book_of_ra2_gift", "ggs",  user},
                {"fairy-land", "fairy_land", "fairy_land", "ggs",  user},
                {"crazy-monkey", "crazy_monkey", "crazy_monkey_gift", "ggs",  user},
                {"sizzling-hot", "sizzling_hot", "sizzling_hot2_o", "ggs",  user},
                {"lucky-ladys-charm-deluxe", "lucky_ladies_charm", "lucky_ladies_charm2_deluxe", "ggs",  user},
                {"bananas-go-bahamas", "bananagobahamas", "bananagobahamas2_o", "ggs",  user},
                {"resident", "resident", "resident2_gift", "ggs",  user},
                {"garage", "garage", "garage", "ggs",  user},
                {"the-money-game", "moneygame", "moneygame2_o_gift", "ggs",  user},
                {"columbus", "columbus", "columbus2_o", "ggs",  user},
                {"gonzos-quest", "gonzo_quest", "gonzo_quest", "ggs",  user},
                {"starburst", "starburst", "starburst", "ggs",  user},
                {"secrets-of-atlantis", "secrets_of_atlantis", "secrets_of_atlantis", "ggs",  user},
                {"reel-rush", "reel_rush", "reel_rush", "ggs",  user},
                {"jack-and-the-beanstalk", "jack_and_beanstalk", "jack_and_beanstalk", "ggs",  user},
                {"wild-water", "wild_water", "wild_water", "ggs",  user},
                {"secret-of-nefertiti", "secret_of_nefertiti", "secret_of_nefertiti", "booongo",  user},
                {"kailash-mystery", "kailash_mystery", "kailash_mystery", "booongo",  user},
                {"kangaliens", "kangaliens", "kangaliens", "booongo",  user},
                {"88-wild-dragon", "88_wild_dragon", "88_wild_dragon", "booongo", user},
                {"fruiterra-fortune", "fruiterra_fortune", "fruiterra_fortune", "booongo", user}
        };
    }
}
