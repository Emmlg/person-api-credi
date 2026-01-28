package com.emmlg.persona_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class PersonEntity extends Auditable {

    @Id
    @Column(name = "id_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;

    @Column(length = 100)
    private String name;

    @Column(name = "last_name",length = 100)
    private String lastName;

    @Column(name = "email",length = 150,unique = true)
    private String email;

    private LocalDate birthdate;

    @Column(name = "is_activate",nullable = false)
    private boolean active;

}
