package spring.gradle.service;

import spring.gradle.model.User;

import java.util.List;

/**
 * Created by arti on 8/19/17.
 */
public interface UserService {
    void save(User user);
    public void updatePerson(User p);
    public List<User> listPersons();
    public User getPersonById(Long id);
    public void removePerson(Long id);
}
