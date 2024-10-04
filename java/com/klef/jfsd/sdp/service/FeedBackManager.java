package com.klef.jfsd.sdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.model.Feedback;
import com.klef.jfsd.sdp.repository.FeedbackRepository;

@Service
public class FeedBackManager {
	    @Autowired
	    private FeedbackRepository feedbackRepository;

	    public void saveFeedback(Feedback feedback) {
	        feedbackRepository.save(feedback);
	    }
}
