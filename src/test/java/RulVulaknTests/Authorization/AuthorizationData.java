package RulVulaknTests.Authorization;

import com.utils.CustomDataProvider;
import com.utils.User;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by ai on 2018-01-15.
 */
public class AuthorizationData {

    @DataProvider
    public Object[][] authorizationUserForVK(Method method){
        User user = new User.Builder()
                .withLogin(new CustomDataProvider().getEmailVK())
                .withPass(new CustomDataProvider().getPassVK())
                .build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForFB(Method method){
        User user = new User.Builder()
                .withLogin(new CustomDataProvider().getEmailFB())
                .withPass(new CustomDataProvider().getPassFB())
                .build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForOK(Method method){
        User user = new User.Builder()
                .withLogin(new CustomDataProvider().getEmailOK())
                .withPass(new CustomDataProvider().getPassOK())
                .build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForMailRU(Method method){
        User user = new User.Builder()
                .withLogin(new CustomDataProvider().getEmailMailRU())
                .withPass(new CustomDataProvider().getPassMailRU())
                .build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForYA(Method method){
        User user = new User.Builder()
                .withLogin(new CustomDataProvider().getEmailYA())
                .withPass(new CustomDataProvider().getPassYA())
                .build();
        return new Object[][]{{user}};
    }
}
