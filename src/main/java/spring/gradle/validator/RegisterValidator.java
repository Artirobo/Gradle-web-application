package spring.gradle.validator;

import spring.gradle.model.ModelRegistration;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by arti on 11/5/17.
 */

@Component
public class RegisterValidator implements Validator {


    private final static String UserName1 = "username";
    private final static String Password = "username";
    @Override
    public boolean supports(Class<?> clazz)
    {
        return ModelRegistration.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        ModelRegistration user = (ModelRegistration) target;
        String username = user.getUsername();
        String pass=user.getPassword();
        ValidationUtils.rejectIfEmpty(errors, UserName1, "userForm.username.empty");
        ValidationUtils.rejectIfEmpty(errors, Password, "userForm.Password.empty");
        if (username != null && username.isEmpty())
            errors.rejectValue(UserName1, "userForm.username.empty");

        if (pass != null && pass.isEmpty())
            errors.rejectValue(Password, "userForm.Password.empty");



    }


}
