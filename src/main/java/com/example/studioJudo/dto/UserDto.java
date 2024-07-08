package com.example.studioJudo.dto;

import com.example.studioJudo.models.Qualification;
import com.example.studioJudo.models.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Builder
public record UserDto (

    @NotNull
    Integer id,

    @NotBlank
    @Length(max = 100)
    String firstName,

    @NotBlank
    @Length(max = 100)
    String lastName,

    @Length(max = 100)
//    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
    String email,

    @JsonIgnore
    String password,

    @Length(max = 20)
    String phoneNumber,

    @NotBlank
    Boolean isTrainer,

    Integer qualificationId,

    Integer roleId

){

}
