package com.klef.jfsd.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.jfsd.sdp.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    
}

