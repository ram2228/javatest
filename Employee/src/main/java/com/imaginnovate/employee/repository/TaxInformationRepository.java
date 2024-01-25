package com.imaginnovate.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.employee.entity.TaxInformation;

@Repository
public interface TaxInformationRepository extends JpaRepository<TaxInformation, Integer> {
	
}
