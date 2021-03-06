package RulVulaknTests.registration;

import com.PreContidions.LandingPage;
import com.utils.CustomDataProvider;
import com.utils.User;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class RegisterData {

    private final CustomDataProvider customDataProvider = new CustomDataProvider();

    @DataProvider
    public Object[][] landingPageNumberProvider(Method method) throws IllegalAccessException {
        Object[][] obj;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][1];

            for (int i = 0; i < pageNumber.length; i++) {
                obj[i][0] = pageNumber[i];
            }
        } else throw new IllegalAccessException("Test with this data provider must has the @LandingPage annotation!");
        return obj;
    }

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
        User user = null;
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
    public Object[][] createUserForVKAndroid(Method method) {
        Object[][] obj;
        User user;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                user = new User.Builder()
                        .withLogin(customDataProvider.getRegisterEmailVKAndroid())
                        .withPass(customDataProvider.getRegisterPassVKAndroid())
                        .build();
                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
            user = new User.Builder()
                    .withLogin(customDataProvider.getRegisterEmailVKAndroid())
                    .withPass(customDataProvider.getRegisterPassVKAndroid())
                    .build();
            obj[0][0] = user;
        }
        return obj;
    }

    @DataProvider
    public Object[][] createUserForFB(Method method) {
        Object[][] obj;
        User user = null;
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
    public Object[][] createUserForFBAndroid(Method method) {
        Object[][] obj;
        User user;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                user = new User.Builder()
                        .withLogin(customDataProvider.getRegisterEmailFBAndroid())
                        .withPass(customDataProvider.getRegisterPassFBAndroid())
                        .build();
                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
            user = new User.Builder()
                    .withLogin(customDataProvider.getRegisterEmailFBAndroid())
                    .withPass(customDataProvider.getRegisterPassFBAndroid())
                    .build();
            obj[0][0] = user;
        }
        return obj;
    }

    @DataProvider
    public Object[][] createUserForOK(Method method) {
        Object[][] obj;
        User user = null;
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
    public Object[][] createUserForOKAndroid(Method method) {
        Object[][] obj;
        User user = null;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                user = new User.Builder()
                        .withLogin(customDataProvider.getRegisterEmailOKAndroid())
                        .withPass(customDataProvider.getRegisterPassOKAndroid())
                        .build();
                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
            user = new User.Builder()
                    .withLogin(customDataProvider.getRegisterEmailOKAndroid())
                    .withPass(customDataProvider.getRegisterPassOKAndroid())
                    .build();
            obj[0][0] = user;
        }
        return obj;
    }

    @DataProvider
    public Object[][] createUserForMailRU(Method method) {
        Object[][] obj;
        User user = null;
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
    public Object[][] createUserForMailRUAndroid(Method method) {
        Object[][] obj;
        User user = null;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                user = new User.Builder()
                        .withLogin(customDataProvider.getRegisterEmailMailRUAndroid())
                        .withPass(customDataProvider.getRegisterPassMailRUAndroid())
                        .build();
                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
            user = new User.Builder()
                    .withLogin(customDataProvider.getRegisterEmailMailRUAndroid())
                    .withPass(customDataProvider.getRegisterPassMailRUAndroid())
                    .build();
            obj[0][0] = user;
        }
        return obj;
    }

    @DataProvider
    public Object[][] createUserForYA(Method method) {
        Object[][] obj;
        User user = null;
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

    @DataProvider
    public Object[][] createUserForYAAndroid(Method method) {
        Object[][] obj;
        User user = null;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                user = new User.Builder()
                        .withLogin(customDataProvider.getRegisterEmailYAAndroid())
                        .withPass(customDataProvider.getRegisterPassYAAndroid())
                        .build();
                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
            user = new User.Builder()
                    .withLogin(customDataProvider.getRegisterEmailYAAndroid())
                    .withPass(customDataProvider.getRegisterPassYAAndroid())
                    .build();
            obj[0][0] = user;
        }
        return obj;
    }

    // for negative test cases
    @DataProvider
    public Object[][] randomUserProviderWithoutAtInEmail(Method method) {
        Object[][] obj;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                User user = new User().generateRandomUserWithEmailWithoutAt(new CustomDataProvider());
                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
            User user = new User().generateRandomUserWithEmailWithoutAt(new CustomDataProvider());
            obj[0][0] = user;
        }
        return obj;
    }
}
