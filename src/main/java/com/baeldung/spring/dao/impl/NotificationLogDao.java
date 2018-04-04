package com.baeldung.spring.dao.impl;

import com.baeldung.spring.dao.AbstractDao;
import com.baeldung.spring.entity.JobSeeker;
import com.baeldung.spring.entity.NotificationLog;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class NotificationLogDao extends AbstractDao<Long, NotificationLog> {

    public void addNotification(NotificationLog notification) {
        persist(notification);
    }

    // get notification log by user

    public List<NotificationLog> getAllNotifications(JobSeeker user) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("jobSeeker", user));
        return (List<NotificationLog>) criteria.list();
    }


    public List<NotificationLog> getUnreadNotifications(JobSeeker user) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("user", user));
        criteria.add(Restrictions.eq("isRead", false));

        return (List<NotificationLog>) criteria.list();
    }

    // get by id
    public NotificationLog getById(long notificationId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", notificationId));
        return (NotificationLog) criteria.uniqueResult();
    }


    // update
    public void updateNotificationAsRead(long notificationId, boolean isRead) {

        Query query = getSession().createSQLQuery("update notification_log set isRead=:isRead where id=:ID");
        query.setString("isRead", String.valueOf(isRead)); // set string
        query.setString("ID", String.valueOf(notificationId));
        query.executeUpdate();// execute update

    }


}
