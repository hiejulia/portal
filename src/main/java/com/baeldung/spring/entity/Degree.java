package com.baeldung.spring.entity;


import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Degree implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String school;

    private Integer year;


}