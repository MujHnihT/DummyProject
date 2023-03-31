package com.example.dummyproject.repo;

import com.example.dummyproject.model.entity.QrContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QrContentRepository extends JpaRepository<QrContent, Integer>{

    List<QrContent> findByUserId(Integer userId);

//    Optional<QrContent> findById(Integer userId);

}
