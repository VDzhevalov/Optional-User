package app.controller;

import app.entity.User;
import app.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String findUserById(int id) {
        return format("findUserById(%d): %s", id, userRepository.findUserById(id)
                .map(User::toString)
                .orElse("No data"));
    }

    public String findUserByEmail(String email) {
        return format("findUserByEmail(%s): %s", email, userRepository.findUserByEmail(email)
                .map(User::toString)
                .orElse("No data"));
    }

    public String findUsersByName(String name) {
        return format("ByName(%s): [%s]", name, userRepository.findUsersByName(name)
                .map(list -> list.stream()
                        .map(User::toString)
                        .collect(Collectors.joining(",\n")))
                .filter(s -> !s.isBlank())
                .orElse("No data"));
    }

    public String findAllUsers() {
        return format("All users(%d): %s", userRepository.findAllUsers().map(List::size).orElse(0), userRepository.findAllUsers().map(Object::toString).orElse("No data"));
    }
}
