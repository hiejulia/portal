package com.baeldung.spring.entity.data;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Data
@Entity
@Table(name = "cfs_feedback", catalog = "cfs")
public class CfsFeedback implements Serializable {

    // Feedback : id, topic, name, email, feedback, date
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topicId", nullable = false)
    private CfsTopic cfsTopic;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "feedback", nullable = false)
    private String feedback;


    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false, length = 10)
    private Date date;

}
