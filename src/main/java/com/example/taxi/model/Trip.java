package com.example.taxi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trip {

    @Id
    @GeneratedValue
    private Long id;

    private double estimatedFare;
    private double fare;
    private double distance;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private LocalDateTime bookingTime;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "start_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "start_longitude"))
    })
    private Location startLocation;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "end_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "end_longitude"))
    })
    private Location endLocation;

    @ManyToOne
    @JoinColumn
    private UserVehicle userVehicle;

    @ManyToOne
    @JoinColumn
    private User client;

    @OneToMany(mappedBy = "trip")
    private List<Review> reviews;

    @OneToMany(mappedBy = "trip")
    private List<Message> messages;

}
