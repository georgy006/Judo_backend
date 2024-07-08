package com.example.studioJudo.models;

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
public class User {

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
    Qualification qualification;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "user_qualification",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "qualification_id")
//    )
//    private List<Qualification> qualifications;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private List<Role> roles;
}
