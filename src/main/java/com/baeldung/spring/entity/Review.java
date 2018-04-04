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
@Table(name = "reviews")
@Data
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Round round;

    @ManyToOne
    private Company reviewer;

    private String comments;

    /**
     * Ranking is usually done only in the last round; for other rounds this
     * field can be empty;
     */
    private Integer rank;

    private Date date;

}