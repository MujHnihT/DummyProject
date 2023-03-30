package com.example.dummyproject.model.entity.firstdb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comment")
@Data
public class UserComment {
    @Id
    private String id;
    private String userName;
    private String userEmail;
    private String replyTo;
    private String topicId;
    private String userComment;
}
