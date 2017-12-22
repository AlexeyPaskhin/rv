package RulVulaknTests.Registration;

import com.PreContidions.LandingPage;
import com.jcraft.jsch.JSchException;
import com.utils.CustomDataProvider;
import com.utils.RandomGenerate;
import com.utils.SSHManager;
import com.utils.User;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class RegisterData {


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
        User user=null;
        if (method.isAnnotationPresent(LandingPage.class)) {
            String[] pageNumber = method.getAnnotation(LandingPage.class).pageNo();
            obj = new Object[pageNumber.length][2];

            for (int i = 0; i < pageNumber.length; i++) {
                user = new User.Builder().withLogin("yr@playtini.ua").withPass("h8ppXBQS").build();

                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
             user = new User.Builder().withLogin("yr@playtini.ua").withPass("h8ppXBQS").build();
            obj[0][0] = user;
        }
        clearEmailFromDB(user);
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
               user = new User.Builder().withLogin("yr@playtini.ua").withPass("playtini123456").build();

                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
            user = new User.Builder().withLogin("yr@playtini.ua").withPass("playtini123456").build();
            obj[0][0] = user;
        }
        clearEmailFromDB(user);
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
                 user = new User.Builder().withLogin("yr+usd@playtini.ua").withPass("h8ppXBQS").build();

                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
            user = new User.Builder().withLogin("yr+usd@playtini.ua").withPass("h8ppXBQS").build();
            obj[0][0] = user;
        }
        clearEmailFromDB(user);
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
                 user = new User.Builder().withLogin("ai.test-11@mail.ru").withPass("h8ppXBQS").build();

                obj[i][0] = user;
                obj[i][1] = pageNumber[i];
            }
        } else {
            obj = new Object[1][1];
             user = new User.Builder().withLogin("ai.test-11@mail.ru").withPass("h8ppXBQS").build();
            obj[0][0] = user;
        }
        clearEmailFromDB(user);
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
                user = new User.Builder().withLogin("dtplaytini@yandex.ru").withPass("h8ppXBQS").build();

                obj[i][0] = user;
                obj[i][1] = pageNumber[i];

            }
        } else {
            obj = new Object[1][1];
            user = new User.Builder().withLogin("dtplaytini@yandex.ru").withPass("h8ppXBQS").build();
            obj[0][0] = user;
        }
        clearEmailFromDB(user);
        return obj;
    }

    private void clearEmailFromDB(User user) {
        String oldName = user.getLogin();

        String[] splitter = oldName.split("@");

        String newName = splitter[0] + "+" + RandomGenerate.randomString(2, 6) + splitter[1];

        try {
            SSHManager manager = new SSHManager();
            manager.executeQuery("docker exec -it psup-db-stage mysql -pmypass \"psup_app\"");
            manager.executeQuery("update players set email='" + newName + "' where email ='" + oldName + "';");
            Thread.sleep(1000);
            manager.disconnectFromConsole();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
