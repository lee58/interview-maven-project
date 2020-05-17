package com.interview.interview.service;

import com.interview.interview.mapper.InterviewMapper;
import com.interview.interviewMaven.mapper.InterviewMavenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@Service
public class InterviewService {
    @Autowired
    private InterviewMapper interviewMapper;
    @Autowired
    private InterviewMavenMapper interviewMavenMapper;


    @Transactional
    public int addUser(String name, Integer age) {
        int insert = interviewMapper.insert(name, age);
        int insertMaven = interviewMavenMapper.insert(name, age);
        int i = 1/age;
        return insert;
    }
}
