package spring.gradle.service;

import spring.gradle.model.USerTableLogin;
import spring.gradle.repository.UserloginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by arti on 9/3/17.
 */
@Service
public class UserLoginServiceImp  implements UserLogninService {

    @Autowired
    private UserloginRepo userLogninService;

    @Override
    public USerTableLogin getbyusername(String username) {
        return userLogninService.getbyUSername(username);
    }
}
