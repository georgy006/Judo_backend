package com.example.studioJudo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="session")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date sessionDate;
    private Time startTime;
    private Time endTime;
    private String description;

    @OneToOne(mappedBy = "session")
    @JsonIgnore
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
