package com.example.dummyproject.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentResponse {
    private String userName;
    private String userEmail;
    private String commentString;
    private String topicId;
    private String replyTo;
}
