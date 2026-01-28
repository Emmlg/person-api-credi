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
public class Auth {

    @Id
    @Column(name = "id_auth")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authId;

    @Column(name = "password_hash")
    private String passwordHashed;

    // Fk
    @OneToOne
    @JoinColumn(name = "id_person")
    private PersonEntity personId;

    // Fk
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role roleId;
}
