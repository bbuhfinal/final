package com.yuukiiii.finalwork.service;

import java.util.ArrayList;
import java.util.List;

import com.yuukiiii.finalwork.model.BigComment;
import com.yuukiiii.finalwork.model.Comment;
import com.yuukiiii.finalwork.model.UserSftwrCom;
import com.yuukiiii.finalwork.repository.CommentRepository;
import com.yuukiiii.finalwork.repository.SoftwareRepository;
import com.yuukiiii.finalwork.repository.UserRepository;
import com.yuukiiii.finalwork.repository.UserSftwrComRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yuukiiii
 * on 2018/4/12 09:49
 */

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserSftwrComRepository userSftwrComRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SoftwareRepository softwareRepository;


    public Comment addComment(Comment comment,Integer userid,Integer softwareid){
        Comment comment1 = commentRepository.save(comment);
        UserSftwrCom userSftwrCom = new UserSftwrCom();
        userSftwrCom.setCommentid(comment1.getCommentid());
        userSftwrCom.setSoftwareid(softwareid);
        userSftwrCom.setUserid(userid);
        userSftwrComRepository.save(userSftwrCom);
        return comment1;
    }

    public void deleteCommentById(Integer commentid){
        commentRepository.deleteById(commentid);
        userSftwrComRepository.deleteByCommentid(commentid);
    }

    public List<BigComment> getAllComment(){
        List<Comment> commentList = commentRepository.findAll();
        List<BigComment> bigComments = new ArrayList<>();
        for(Comment comment : commentList){
            BigComment bigComment = new BigComment();
            bigComment.setComment(comment);
            UserSftwrCom userSftwrCom = userSftwrComRepository.getOne(comment.getCommentid());
            Integer softwareid = userSftwrCom.getSoftwareid();
            bigComment.setSoftwareid(softwareid);
            bigComment.setSoftwarename(softwareRepository.getOne(softwareid).getSoftwarename());
            Integer userid = userSftwrCom.getUserid();
            bigComment.setUserid(userid);
            bigComment.setUsername(userRepository.getOne(userid).getUsername());
        }
        return bigComments;
    }

    public BigComment getOneComment(Integer userid,Integer softwareid){
        BigComment bigComment = new BigComment();
        UserSftwrCom userSftwrCom = userSftwrComRepository.findByUseridAndSoftwareid(userid,softwareid);
        bigComment.setComment(commentRepository.getOne(userSftwrCom.getCommentid()));
        bigComment.setUserid(userSftwrCom.getUserid());
        bigComment.setUsername(userRepository.getOne(userSftwrCom.getUserid()).getUsername());
        bigComment.setSoftwareid(userSftwrCom.getSoftwareid());
        bigComment.setSoftwarename(softwareRepository.getOne(userSftwrCom.getSoftwareid()).getSoftwarename());

        return bigComment;
    }

    public Comment updateComment(Comment comment){
        return commentRepository.save(comment);
    }
}
