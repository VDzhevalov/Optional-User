package app.repository;

import app.entity.User;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    List<User> users;

    public UserRepository(List<User> users) {
        this.users = users;
    }

    public  Optional<List<User>> findAllUsers() {
        return Optional.ofNullable(users);
    }

    public Optional<User> findUserById(int id) {
        return findAllUsers()
                .flatMap(list -> list.stream()
                        .filter(user -> user.getId() == id)
                        .findFirst());
    }

    public Optional<User> findUserByEmail(String email) {
        return findAllUsers()
                .flatMap(list -> list.stream()
                        .filter(user -> user.getEmail().equals(email))
                        .findFirst());

    }

    public Optional<List<User>> findUsersByName(String name) {
        return findAllUsers()
                .map(list -> list.stream()
                        .filter(user -> user.getName().equals(name))
                        .toList())
                .filter(filtered -> !filtered.isEmpty());
    }

}
