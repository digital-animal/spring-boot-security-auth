package com.zahid.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
// @Data
@NoArgsConstructor
public class User {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Getter
    @Setter
    @Column(name = "email", nullable = true, unique = true)
    private String email;

    @Getter
    @Setter
    @Column(name = "password", nullable = true)
    private String password;

    // @Getter
    // @Setter
    // @Column(name = "date_of_birth", nullable = true)
    // private String dateOfBirth;

    // @Getter
    // @Setter
    // @Column(name = "address", nullable = true)
    // private String address;

    // public User(String firstName, String lastName, String email, String dateOfBirth, String address) {
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.email = email;
    //     this.dateOfBirth = dateOfBirth;
    //     this.address = address;
    // }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}
