package com.baeldung.spring.dao;

import com.baeldung.spring.entity.data.CfsTopic;

import java.util.Date;
import java.util.List;




public interface TopicDao {

    // get all topics
    public List<CfsTopic> getAllTopics();

    // get topic by id
    public CfsTopic getTopic(int topicId);

    // add new topic
    public void addTopic(String title, String description, Date data);

    // delete topic: id
    public void delTopic(Integer id);

    // update topic : topic
    public void updateTopic(CfsTopic topic);

}
