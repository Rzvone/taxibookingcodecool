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
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "vehicle")
    private List<UserVehicle> userVehicles;

    private String plate;
    private String model;
    private String brand;
    private String color;

}
