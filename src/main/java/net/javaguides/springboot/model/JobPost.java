package net.javaguides.springboot.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private String JobTittle;
    private String JobDescription;
    private String Location;
    private String Price;
    private String Duration;

    public JobPost(Long id) {
        this.id = id;
    }

    public JobPost() {
    }

    public JobPost(String jobTittle, String jobDescription,String location,String price, String duration) {
        JobTittle = jobTittle;
        JobDescription=jobDescription;
        Location =location;
        Price = price;
        Duration = duration;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTittle() {
        return JobTittle;
    }

    public void setJobTittle(String jobTittle) {
        JobTittle = jobTittle;
    }

    public String getJobDescription() {
        return JobDescription;
    }

    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }
}
