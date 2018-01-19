package RulVulaknTests.registration;

import com.PreContidions.LandingPage;
import com.utils.CustomDataProvider;
import com.utils.User;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class RegisterData {

    private final CustomDataProvider customDataProvider = new CustomDataProvider();

    @DataProvider
    public Object[][] randomUserProvider(Method method) {
        Object[][] obj;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                User user = new User().generateRandomUser(new CustomDataProvider());

                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
            User user = new User().generateRandomUser(new CustomDataProvider());
            obj[0][0] = user;
        }
        return obj;
    }

    @DataProvider
    public Object[][] createUserForVK(Method method) {
        Object[][] obj;
        User user;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                user = new User.Builder()
                        .withLogin(customDataProvider.getRegisterEmailVK())
                        .withPass(customDataProvider.getRegisterPassVK())
                        .build();

                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
             user = new User.Builder()
                     .withLogin(customDataProvider.getRegisterEmailVK())
                     .withPass(customDataProvider.getRegisterPassVK())
                     .build();

            obj[0][0] = user;
        }
        return obj;
    }

    @DataProvider
    public Object[][] createUserForFB(Method method) {
        Object[][] obj;
        User user=null;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
               user = new User.Builder()
                       .withLogin(customDataProvider.getRegisterEmailFB())
                       .withPass(customDataProvider.getRegisterPassFB())
                       .build();

                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
            user = new User.Builder()
                    .withLogin(customDataProvider.getRegisterEmailFB())
                    .withPass(customDataProvider.getRegisterPassFB())
                    .build();

            obj[0][0] = user;
        }
        return obj;
    }

    @DataProvider
    public Object[][] createUserForOK(Method method) {
        Object[][] obj;
        User user=null;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                 user = new User.Builder()
                         .withLogin(customDataProvider.getRegisterEmailOK())
                         .withPass(customDataProvider.getRegisterPassOK())
                         .build();

                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
            user = new User.Builder()
                    .withLogin(customDataProvider.getRegisterEmailOK())
                    .withPass(customDataProvider.getRegisterPassOK())
                    .build();

            obj[0][0] = user;
        }
        return obj;
    }

    @DataProvider
    public Object[][] createUserForMailRU(Method method) {
        Object[][] obj;
        User user=null;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                 user = new User.Builder()
                         .withLogin(customDataProvider.getRegisterEmailMailRU())
                         .withPass(customDataProvider.getRegisterPassMailRU())
                         .build();

                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
             user = new User.Builder()
                     .withLogin(customDataProvider.getRegisterEmailMailRU())
                     .withPass(customDataProvider.getRegisterPassMailRU())
                     .build();

            obj[0][0] = user;
        }
        return obj;
    }

    @DataProvider
    public Object[][] createUserForYA(Method method) {
        Object[][] obj;
        User user=null;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                user = new User.Builder()
                        .withLogin(customDataProvider.getRegisterEmailYA())
                        .withPass(customDataProvider.getRegisterPassYA())
                        .build();

                obj[i][0] = user;
                obj[i][1] = pageNumber[i];

            }
        } else {
            obj = new Object[1][1];
            user = new User.Builder()
                    .withLogin(customDataProvider.getRegisterEmailYA())
                    .withPass(customDataProvider.getRegisterPassYA())
                    .build();

            obj[0][0] = user;
        }
        return obj;
    }

//    private Object[][] userForLanding(String[] pageNumber){
//
//        Object [][] obj = new Object[pageNumber.length][2];
//
//        for (int i = 0; i < pageNumber.length; i++) {
//            User user = new User.Builder().withLogin("dtplaytini@yandex.ru").withPass("h8ppXBQS").build();
//
//            obj[i][0] = user;
//            obj[i][1] = pageNumber[i];
//
//    }
}
