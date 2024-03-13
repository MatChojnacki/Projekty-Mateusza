package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

    @Query(value = "SELECT * FROM COMPANIES WHERE LEFT(COMPANY_NAME, 3) = :prefix", nativeQuery = true)
    List<Company> findByFirstThreeCharsOfName(@Param("prefix") String prefix);
}
