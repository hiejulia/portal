package com.baeldung.spring.dao;

import com.baeldung.spring.entity.data.CfsFeedback;
import com.baeldung.spring.entity.form.FeedbackForm;

import java.util.List;

public interface FeedbackDao {

    // get all feedbacks by topic id
    public List<CfsFeedback> getAllFeedbacks(Integer topicId);

    // add feedback : topic Id, feedbackForm
    public void addFeedback(Integer topicId, FeedbackForm feedback);

    // delete feedback : topicId,feedback Id
    public void delFeedback(Integer topicId, Integer feedbackId);

    // update feedback : topic id, feedback form
    public void updateFeedback(Integer topicId, FeedbackForm feedback);

    // get feedback : by topicid, and by feedback id
    public CfsFeedback getFeedback(Integer topicId, Integer feedbackId);
}
