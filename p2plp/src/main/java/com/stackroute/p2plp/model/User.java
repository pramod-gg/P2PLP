package com.stackroute.p2plp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "userDb")
public class User {

    private String firstName;
    private String lastName;
    @Id
    private String email;
    private String password;
}