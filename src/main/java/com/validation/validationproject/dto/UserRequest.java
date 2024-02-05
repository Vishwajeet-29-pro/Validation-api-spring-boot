package com.validation.validationproject.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "user name should not be null")
    private String name;
    @Email(message = "Invalid email")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
    private String mobile;
    private String gender;
    @NotBlank
    private String nationality;
    @Min(18)
    @Max(60)
    private int age;
}
















