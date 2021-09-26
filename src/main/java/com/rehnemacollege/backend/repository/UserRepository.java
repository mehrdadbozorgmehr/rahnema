package com.rehnemacollege.backend.repository;

import com.rehnemacollege.backend.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private static Map<Integer, User> repo = new HashMap<>();

    public void addOrUpdate(User user) {
        repo.put(user.getId(), user);
    }

    public User get(Integer id) {
        return repo.get(id);
    }

    public Collection<User> getAll() {
        return repo.values();
    }
}
