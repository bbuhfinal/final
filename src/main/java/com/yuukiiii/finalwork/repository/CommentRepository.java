package com.yuukiiii.finalwork.repository;

import com.yuukiiii.finalwork.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yuukiiii
 * on 2018/4/11 20:37
 */


public interface CommentRepository extends JpaRepository<Comment,Integer> {

}
