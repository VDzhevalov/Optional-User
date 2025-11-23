package app.controller;

import app.entity.User;
import app.repository.UserRepository;

import java.util.List;

import static app.view.UserView.print;

public class CommonAppController {

    public static void getUsersInfo(List<User> users, int id, String name, String email) {
        UserController userController = new UserController(new UserRepository(users));
        print(userController.findAllUsers());
        print(userController.findUserById(id));
        print(userController.findUsersByName(name));
        print(userController.findUserByEmail(email));
        print("");
    }
}
