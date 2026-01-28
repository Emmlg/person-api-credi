package com.emmlg.persona_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auth")
public class AuthEntity {

    @Id
    @Column(name = "id_auth")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authId;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHashed;

    // Fk
    @OneToOne
    @JoinColumn(name = "id_person",nullable = false)
    private PersonEntity person;

    // Fk
    @ManyToOne
    @JoinColumn(name = "id_role",nullable = false)
    private RoleEntity role;
}
