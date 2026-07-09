package com.lvb.projects.UserNotesApi.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //TODO verify if is possible to separate this field in an embeddable class
    private int id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    //TODO Study how to save/validate password properly
    @Column(nullable = false)
    private String password;

    private String nickname;

    private int age;

    // Will use this api for what?
    private String usageFor;


    // TODO verify later what address info is necessary
    private String country;

}
