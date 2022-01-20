package net.javaguides.springboot.service;

import net.javaguides.springboot.model.JobPost;
import net.javaguides.springboot.repository.JobPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostServiceImpl implements JobPostService {


    private JobPostRepository jobPostRepository;

    public JobPostServiceImpl(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    @Override
    public List<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    @Override
    public JobPost saveJobPost(JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }

    @Override
    public JobPost getJobPostById(Long id) {
        return jobPostRepository.findById(id).get();
    }

    @Override
    public JobPost updateJobPost(JobPost jobPost) {
        return jobPostRepository.save(jobPost);

    }

    @Override
    public void deleteJobPostById(Long id) {
        jobPostRepository.deleteById(id);

    }
}
