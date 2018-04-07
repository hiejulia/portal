package com.baeldung.spring.dao;



public interface LoginDao {

    public Tblstudentuser getStudentUser(Login login);
    public Tblfacultyuser getFacultyUser(Login login);
    public Tbladminuser getAdmin(Login login);

}
