package com.tripmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tripmaster.models.Feedback;

@Service
public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

}
