package app.utils;

import app.controller.CommonAppController;
import app.entity.User;

import java.util.List;

public class AppStarter {

    public static void start() {
        List<User> users = null;
        CommonAppController.getUsersInfo(users, 0,"Alice", "alice@test.com");

        users = List.of(new User(1, "Tom", "tom@test.com"), new User(2, "John", "john@@test.com"));
        CommonAppController.getUsersInfo(users, 0,"Alice", "alice@test.com");

        users = List.of(new User(0, "Alice", "alice@test.com"), new User(1, "Tom", "tom@test.com"), new User(2, "Tom", "another_tom@@test.com"));
        CommonAppController.getUsersInfo(users, 1,"Tom", "another_tom@@test.com");
    }
}
