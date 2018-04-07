package com.baeldung.spring.dao;



        import com.baeldung.spring.entity.JobApplication;
        import com.baeldung.spring.entity.JobPosting;

        import java.util.List;



public interface ReportDao {



    public List<JobApplication> getJobApplications();
    public List<JobPosting> getJobPosting();

    public JobApplication getJobApplicationById(Long id);

}
