package RulVulaknTests.Authorization;

import com.utils.User;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by ai on 2018-01-15.
 */
public class AuthorizationData {

    @DataProvider
    public Object[][] authorizationUserForVK(Method method){
        User user = new User.Builder().withLogin("+380667598342").withPass("h8ppXBQS").build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForFB(Method method){
        User user = new User.Builder().withLogin("+380667598342").withPass("h8ppXBQS").build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForOK(Method method){
        User user = new User.Builder().withLogin("ai@playtini.ua").withPass("h8ppXBQS").build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForMailRU(Method method){
        User user = new User.Builder().withLogin("test.vulkan@mail.ru").withPass("h8ppXBQS").build();
        return new Object[][]{{user}};
    }

    @DataProvider
    public Object[][] authorizationUserForYA(Method method){
        User user = new User.Builder().withLogin("test.vulkan2017@yandex.ru").withPass("h8ppXBQS").build();
        return new Object[][]{{user}};
    }
}
