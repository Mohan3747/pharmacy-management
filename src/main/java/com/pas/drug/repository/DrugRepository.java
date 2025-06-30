package com.pas.drug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pas.drug.model.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> 
{

}