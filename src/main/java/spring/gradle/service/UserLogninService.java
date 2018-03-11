package spring.gradle.service;


import spring.gradle.model.USerTableLogin;

/**
 * Created by arti on 9/3/17.
 */
public interface UserLogninService  {
    public USerTableLogin  getbyusername(String username);

}
