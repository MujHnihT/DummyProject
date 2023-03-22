package com.example.dummyproject.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddCommentRequest {
    @NotBlank
    @NotNull
    private String userName;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String userEmail;
    @NotBlank
    @NotNull
    private String commentString;

//    @NotBlank
//    @NotNull
    private String topicId;

    private String replyTo;
}
