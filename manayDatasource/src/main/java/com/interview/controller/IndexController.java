package com.interview.controller;

import com.interview.interview.mapper.InterviewMapper;
import com.interview.interview.service.InterviewService;
import com.interview.interviewMaven.mapper.InterviewMavenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大都督
 * @create 2020/4/3
 */
@RestController
public class IndexController {
    @Autowired
    private InterviewMapper interviewMapper;
    @Autowired
    private InterviewMavenMapper interviewMavenMapper;
    @Autowired
    private InterviewService interviewService;

    @RequestMapping("/addInterviewUser")
    public Integer addInterviewUser(String userName, Integer age) {
        return interviewMapper.insert(userName, age);
    }

    @RequestMapping("/addInterviewMavenUser")
    public Integer addInterviewMavenUser(String userName, Integer age) {
        return interviewMavenMapper.insert(userName, age);
    }
    @RequestMapping("/addInterviewUserByservice")
    public Integer addInterviewUserByservice(String userName, Integer age) {
        return interviewService.addUser(userName, age);
    }
}
