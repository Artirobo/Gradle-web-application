package spring.gradle.validator;

import spring.gradle.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by arti on 8/21/17.
 */
@Component
public class UserValidator implements Validator {

    private final static String UserName = "username";

    @Override
    public boolean supports(Class<?> clazz)
    {
        return User.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String username = user.getUsername();
        ValidationUtils.rejectIfEmpty(errors, UserName, "userForm.username.empty");
        if (username != null && username.isEmpty())
            errors.rejectValue(UserName, "userForm.username.empty");

    }

    }

