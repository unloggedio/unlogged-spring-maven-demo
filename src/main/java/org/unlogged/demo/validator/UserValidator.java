package org.unlogged.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "user_id", "id.empty");
        ValidationUtils.rejectIfEmpty(errors, "username", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");

        User user = (User) target;
        if (user.getUser_id() <= 0) {
            errors.rejectValue("user_id", "ID is negative or Zero");
        }
        if (!user.getEmail().contains("@")) {
            errors.rejectValue("email", "Not a valid email");
        }
    }
}
