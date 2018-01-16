package RulVulaknTests.authorization;

import com.utils.CustomDataProvider;
import com.utils.User;
import org.testng.annotations.DataProvider;

/**
 * Created by ai on 2018-01-15.
 */
public class AuthorizationData {

    private final CustomDataProvider customDataProvider = new CustomDataProvider();

    @DataProvider
    public Object[][] authorizationUserForVK(){
        User user = new User.Builder()
                .withLogin(customDataProvider.getAuthEmailVK())
                .withPass(customDataProvider.getAuthPassVK())
                .build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForFB(){
        User user = new User.Builder()
                .withLogin(customDataProvider.getAuthEmailFB())
                .withPass(customDataProvider.getAuthPassFB())
                .build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForOK(){
        User user = new User.Builder()
                .withLogin(customDataProvider.getAuthEmailOK())
                .withPass(customDataProvider.getAuthPassOK())
                .build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForMailRU(){
        User user = new User.Builder()
                .withLogin(customDataProvider.getAuthEmailMailRU())
                .withPass(customDataProvider.getAuthPassMailRU())
                .build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForYA(){
        User user = new User.Builder()
                .withLogin(customDataProvider.getAuthEmailYA())
                .withPass(customDataProvider.getAuthPassYA())
                .build();
        return new Object[][]{{user}};
    }
}
