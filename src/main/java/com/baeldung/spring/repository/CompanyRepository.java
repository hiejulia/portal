package com.baeldung.spring.repository;





import com.baeldung.spring.entity.Company;

import java.util.List;

public interface CompanyRepository {
    // create new company
    Company save(Company company);

    // null if not found
    Company get(int id);


    // null if not found
    List<Company> getByName(String companyName);

    List<Company> getAll();

    Integer totalCount();

    List<Company> getAllByPage(int offsetData, int limitData);

    void delete(int id);

    void update(Company company);
}