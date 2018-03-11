package spring.gradle.service;

import spring.gradle.model.RoleTableLogin;
import spring.gradle.repository.RoleLoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by arti on 9/4/17.
 */
@Service
public class RoleTableServiceImp implements RoleTableService {

   @Autowired
   private RoleLoginRepo roleLoginRepo;

    @Override
    public RoleTableLogin getbyusername(Long id) {
        roleLoginRepo.retriveById(id);
        return null;
    }
}
