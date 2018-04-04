package com.baeldung.spring.entity;

import com.baeldung.spring.Application;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * Each application needs to go through a number of "rounds", and in each round,
 * will determine whether the application has passed the round.
 */
@Entity
@Data
@Table(name = "rounds")
public class Round implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    // application map
    @ManyToOne
    @JoinColumn(name = "job_application_id")
    private JobApplication jobApplication;

    @Column(name = "round_index", nullable = false)
    private int index;

    // reviews
    @OneToMany(mappedBy = "round")
    @OrderBy("id asc")
    private List<Review> reviews;

    private boolean passed;


}