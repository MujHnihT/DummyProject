package com.example.dummyproject.repo;

import com.example.dummyproject.model.entity.UserComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCommentRepo  extends MongoRepository<UserComment, String> {

    public long count();

    List<UserComment> findByUserEmail(String userName);

    List<UserComment> findByTopicId(String topicId);

}