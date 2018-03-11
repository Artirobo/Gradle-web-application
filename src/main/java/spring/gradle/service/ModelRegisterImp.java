package spring.gradle.service;

import spring.gradle.model.ModelRegistration;
import spring.gradle.repository.ModelRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by arti on 11/5/17.
 */
@Service
public class ModelRegisterImp implements  ModelRegister {
    @Autowired
    private ModelRegistrationRepo modelRegistrationRepo;


    @Override
    @Transactional
    public void save(ModelRegistration user) {
        modelRegistrationRepo.save(user);
    }

    @Override
    @Transactional
    public void updatePerson(ModelRegistration p) {

    }

    @Override
    @Transactional
    public List<ModelRegistration> listPersons() {
        return modelRegistrationRepo.findAll();
    }

    @Override
    @Transactional
    public ModelRegistration getPersonById(Long id) {
        return modelRegistrationRepo.findOne(id);
    }

    @Override
    @Transactional
    public void removePerson(Long id) {
modelRegistrationRepo.delete(id);
    }
}
