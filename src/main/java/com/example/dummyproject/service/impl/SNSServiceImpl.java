package com.example.dummyproject.service.impl;

import com.example.dummyproject.common.CommonClass;
import com.example.dummyproject.common.CommonResponseEnum;
import com.example.dummyproject.model.entity.firstdb.UserComment;
import com.example.dummyproject.model.request.AddCommentRequest;
import com.example.dummyproject.model.response.BaseResponse;
import com.example.dummyproject.model.response.CommentResponse;
import com.example.dummyproject.repo.firstdb.UserCommentRepo;
import com.example.dummyproject.service.SNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SNSServiceImpl implements SNSService {

    @Autowired
    UserCommentRepo repo;

    @Override
    public ResponseEntity<BaseResponse> sendComment(AddCommentRequest req) {
        BaseResponse response = new BaseResponse();
        try {
            UserComment userComment = new UserComment();
            userComment.setUserComment(req.getUserName());
            userComment.setUserEmail(req.getUserEmail());
            userComment.setUserComment(req.getCommentString());
            userComment.setReplyTo(req.getReplyTo());
            userComment.setTopicId(req.getTopicId());
            repo.save(userComment);
            response.setResponseCode(CommonResponseEnum.SUCCESS.responseCode);
            response.setMessage(CommonResponseEnum.SUCCESS.message);
            return ResponseEntity.status(CommonResponseEnum.SUCCESS.responseCode).body(response);

        } catch (Exception e) {
            response.setResponseCode(CommonResponseEnum.INTERNAL_ERROR.responseCode);
            response.setMessage(CommonResponseEnum.INTERNAL_ERROR.message);
            response.setData(e.getMessage());
            return ResponseEntity.status(CommonResponseEnum.INTERNAL_ERROR.responseCode).body(response);

        }
    }

    @Override
    public ResponseEntity<BaseResponse> getComment() {
        BaseResponse baseResponse = new BaseResponse();

        try {
            List<UserComment> comments = repo.findAll();
            List<CommentResponse> response = new ArrayList<>();
            comments.forEach(comment -> {
                CommentResponse commentResponse = new CommentResponse();
                commentResponse.setUserName(comment.getUserName());
                commentResponse.setReplyTo(comment.getReplyTo());
                commentResponse.setCommentString(comment.getUserComment());
                commentResponse.setTopicId(comment.getTopicId());
                commentResponse.setUserEmail(CommonClass.censorEmail(comment.getUserEmail()));
                response.add(commentResponse);
            });
            baseResponse.setResponseCode(CommonResponseEnum.SUCCESS.responseCode);
            baseResponse.setMessage(CommonResponseEnum.SUCCESS.message);
            baseResponse.setData(response);
            return ResponseEntity.status(CommonResponseEnum.SUCCESS.responseCode).body(baseResponse);
        } catch (Exception e) {
            baseResponse.setResponseCode(CommonResponseEnum.INTERNAL_ERROR.responseCode);
            baseResponse.setMessage(CommonResponseEnum.INTERNAL_ERROR.message);
            baseResponse.setData(e.getMessage());
            return ResponseEntity.status(CommonResponseEnum.INTERNAL_ERROR.responseCode).body(baseResponse);
        }

    }
}
