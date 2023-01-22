package com.tripmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripmaster.models.Packages;

public interface PackageDao extends JpaRepository<Packages, Integer>{

}
