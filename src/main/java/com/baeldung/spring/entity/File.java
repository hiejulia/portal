package com.baeldung.spring.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "files")
@Data
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String type;

    private Long size;

    private Date date;

    @ManyToOne
    private JobSeeker owner;


}