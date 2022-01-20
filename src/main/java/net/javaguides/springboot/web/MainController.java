package net.javaguides.springboot.web;

import net.javaguides.springboot.model.JobPost;
import net.javaguides.springboot.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class MainController {


	@Autowired
	private JobPostService jobPostService;


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	
	/*@GetMapping("/")
	public String home() {
		return "index";
	}**/


	@GetMapping("/")
	public String listJobs(Model model) {
		model.addAttribute("jobPosts", jobPostService.getAllJobPosts());
		return "index";

	}


	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("jobPosts", jobPostService.getAllJobPosts());
		return "index";

	}



	@GetMapping("/jobpost/new")
	public String createStudentForm(Model model) {

		// create student object to hold student form data
		//JobPost jobPost = new JobPost();
		//model.addAttribute("jobPost", jobPost);
		model.addAttribute("jobPost", new JobPost());
		return "jobform";

	}
	@PostMapping("/index")
	public String saveStudent(@ModelAttribute("jobPost") JobPost jobPost) {
		jobPostService.saveJobPost(jobPost);
		return "redirect:/index";

	}

	@GetMapping("/index/{id}")
	public String deletePost(@PathVariable Long id) {
		jobPostService.deleteJobPostById(id);
		return "redirect:/index";
	}

}