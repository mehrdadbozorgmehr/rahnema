package com.rehnemacollege.backend.repository;

import com.rehnemacollege.backend.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
