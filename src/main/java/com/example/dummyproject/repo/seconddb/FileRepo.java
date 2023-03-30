package com.example.dummyproject.repo.seconddb;

import com.example.dummyproject.model.entity.seconddb.File;
import com.example.dummyproject.model.entity.seconddb.VNPayRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepo extends JpaRepository<File, Integer> {

    boolean existsByName(String name);


    Optional<File> findByName(String name);
}
