package com.barber.be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "barbers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @Column(unique = true)
    private String email;

    private String phoneNumber;

    // Disponibilità, portfolio immagini, ecc.
    // Per semplicità qui non le mettiamo, ma da modellare in futuro

    @OneToMany(mappedBy = "barber")
    private Set<Appointment> appointments;
}
