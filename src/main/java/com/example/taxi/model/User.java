package com.example.taxi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;
    private String phone;

    @OneToMany(mappedBy = "driver")
    private List<UserVehicle> userVehicles;

    @OneToMany(mappedBy = "client")
    private List<Trip> trips;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

}
