package com.baeldung.spring.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="notification_log")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="job_seeker_id")
    private JobSeeker jobSeeker;

//    @ManyToOne
//    @JoinColumn(name="job_opening_id")
//    private JobOpening jobOpening;

    //    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "send_date")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private String sendDate;

    private boolean isRead;

    private String bodyText;



}