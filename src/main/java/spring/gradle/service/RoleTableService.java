package spring.gradle.service;

import spring.gradle.model.RoleTableLogin;

/**
 * Created by arti on 9/4/17.
 */
public interface RoleTableService {

    public RoleTableLogin getbyusername(Long id);
}
