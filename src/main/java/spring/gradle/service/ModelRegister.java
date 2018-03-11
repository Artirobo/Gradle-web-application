package spring.gradle.service;


import spring.gradle.model.ModelRegistration;

import java.util.List;

/**
 * Created by arti on 11/5/17.
 */
public interface ModelRegister {
    void save(ModelRegistration user);
    public void updatePerson(ModelRegistration p);
    public List<ModelRegistration> listPersons();
    public ModelRegistration getPersonById(Long id);
    public void removePerson(Long id);
}
