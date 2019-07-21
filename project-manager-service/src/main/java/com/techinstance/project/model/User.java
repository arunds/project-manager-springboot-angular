package com.techinstance.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@EqualsAndHashCode
@JsonDeserialize(as = User.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empId;
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {

    }

    @Override
    public String toString() {
        return String.format(
                "User[empId=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }


}
