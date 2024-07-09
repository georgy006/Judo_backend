package com.example.studioJudo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="user", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode
public class User { // implements UserDetails

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique=true)
    private String email;

    @Column(name = "password")
    String password;

    @Column(name = "phone_number")
    private String phoneNumber;

//    @Column(name = "date_of_birth")
//    private Date dateOfBirth;

    @Column(name = "is_trainer")
    private Boolean isTrainer;

    @ManyToOne
    @JoinColumn(name = "qualification_id")
    private Qualification qualification;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
