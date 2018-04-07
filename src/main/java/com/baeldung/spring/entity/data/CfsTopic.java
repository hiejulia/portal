package com.baeldung.spring.entity.data;
import lombok.Data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Data
@Entity
@Table(name = "cfs_topic", catalog = "cfs")
public class CfsTopic {

    // Topic : id, title, description , date, feedbacks : Set : One to many
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description")
    private String description;


    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false, length = 10)
    private Date date;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cfsTopic")
    private Set<CfsFeedback> cfsFeedbacks = new HashSet<CfsFeedback>(0);
}
