package RulVulaknTests.cashbox;

import com.pages.HomePage;
import com.utils.Card;
import com.utils.CustomDataProvider;
import com.utils.User;
import org.testng.annotations.DataProvider;

/**
 * Created by ai on 2018-01-18.
 */
public class CashboxData {

    private final CustomDataProvider customDataProvider = new CustomDataProvider();

    @DataProvider(parallel = true)
    public Object[][] randomUserAuthProvider() {
        User user = new User().generateRandomUser(new CustomDataProvider());
        Card card = new Card.Builder()
                .withNumber(customDataProvider.getCardNumberMaster())
                .withHolder(customDataProvider.getCardHolderMaster())
                .withCvv(customDataProvider.getCardCvvMaster())
                .build();

        return new Object[][]{{user, card}};
    }

    @DataProvider(parallel = true)
    public Object[][] userAuthProvider() {
        User user = new User.Builder()
                .withLogin(customDataProvider.getAuthEmail())
                .withPass(customDataProvider.getAuthPass())
                .build();
        Card card = new Card.Builder()
                .withNumber(customDataProvider.getCardNumberMaster())
                .withHolder(customDataProvider.getCardHolderMaster())
                .withCvv(customDataProvider.getCardCvvMaster())
                .build();

        return new Object[][]{{user, card}};
    }

}
