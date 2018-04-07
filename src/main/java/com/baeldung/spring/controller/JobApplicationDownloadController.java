package com.baeldung.spring.controller;


import java.util.List;


import com.baeldung.spring.dao.JobApplicationDao;
import com.baeldung.spring.entity.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobApplicationDownloadController {

//    @Autowired
//    private LoginService loginService;

    @Autowired
    private JobApplicationDao jobApplicationDao;

    @RequestMapping(value = "/hrms/downloadExcelJobApplicationList/{id}", method = RequestMethod.GET)
    public ModelAndView downloadExcel(@PathVariable("id") int id) {

        JobApplication allUsers = jobApplicationDao.getJobApplication(id);

        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("excelView", "allUsers", allUsers);
    }

    // Download excel job application
//    @RequestMapping(value = "/hrms/downloadJExcelUserList", method = RequestMethod.GET)
//    public ModelAndView downloadJExcel() {
//
//        List<HrmsLogin> allUsers = loginService.getUserList();
//
//        // return a view which will be resolved by an excel view resolver
//        return new ModelAndView("excelJExcelView", "allUsers", allUsers);
//    }

    // download job application as pdf
    @RequestMapping(value = "/hrms/downloadPDFUserList/{id}", method = RequestMethod.GET)
    public ModelAndView downloadPDF(@PathVariable("id") int id) {

        JobApplication jobApplication = jobApplicationDao.getJobApplication(id);

        // return a view which will be resolved by an PDF view resolver
        return new ModelAndView("pdfView", "allUsers", jobApplication);
    }


}
