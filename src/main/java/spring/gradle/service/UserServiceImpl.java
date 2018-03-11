package spring.gradle.service;

import spring.gradle.model.User;
import spring.gradle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arti on 8/19/17.
 */

@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }


    @Override
    @Transactional
    public List<User> listPersons() {
            List<User> ab =new ArrayList<User>();
        ab=userRepository.findAll();
        if(ab.size()>0){
            return userRepository.findAll();

        }
        return  null;

    }

    @Override
    @Transactional
    public User getPersonById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public void removePerson(Long id) {
       userRepository.delete(id);
    }

    @Override
    @Transactional
    public void updatePerson(User p) {
        userRepository.setUpdatebyId(p.getUsername(),p.getId());
    }
}
