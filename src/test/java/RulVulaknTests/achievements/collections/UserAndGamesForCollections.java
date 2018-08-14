package RulVulaknTests.achievements.collections;

import com.utils.CustomDataProvider;
import com.utils.User;
import org.testng.annotations.DataProvider;

public class UserAndGamesForCollections {
    private static User user;

    @DataProvider
    public Object[][] userAndGamesForCollectionsProvider() {
        if (user == null) user = new User().generateRandomUser(new CustomDataProvider());

    }
}
