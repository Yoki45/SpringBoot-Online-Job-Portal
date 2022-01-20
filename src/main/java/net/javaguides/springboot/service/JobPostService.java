package net.javaguides.springboot.service;

import net.javaguides.springboot.model.JobPost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobPostService {

    List<JobPost> getAllJobPosts();

    JobPost saveJobPost(JobPost jobPost);

    JobPost getJobPostById(Long id);

    JobPost updateJobPost(JobPost jobPost);

    void deleteJobPostById(Long id);
}
