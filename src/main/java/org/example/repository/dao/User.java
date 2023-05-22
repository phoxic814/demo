package org.example.repository.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String last_name;
}

/**
 * CREATE TABLE slave.`user_detail` (
 * 	user_id INT primary key NOT NULL,
 * 	first_name varchar(100) NULL,
 * 	last_name varchar(100) NULL
 * )
 * ENGINE=InnoDB;
 */