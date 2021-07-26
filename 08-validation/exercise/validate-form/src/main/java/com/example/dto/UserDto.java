package com.example.dto;

import com.example.model.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private Long id;
    @NotEmpty
    @Size(min=5,max = 45)
    private String firstName;
    @NotEmpty
    @Size(min=5,max = 45)
    private String lastName;
    private String phoneNumber;
    @Min(18)
    private int age;
    @NotBlank
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto =(UserDto) target;
        String number = userDto.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("phoneNumber", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("phoneNumber", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "number.matches");
        }
    }
}
