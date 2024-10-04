package com.klef.jfsd.sdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.klef.jfsd.sdp.model.Feedback;
import com.klef.jfsd.sdp.service.FeedBackManager;

@Controller
public class FeedbackController {
    @Autowired
    private FeedBackManager feedbackService;

    @PostMapping("/submitFeedback")
    public String submitFeedback(@RequestBody Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return "feedback-success"; 
    }
}