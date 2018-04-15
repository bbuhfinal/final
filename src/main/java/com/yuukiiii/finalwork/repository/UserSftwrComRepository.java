package com.yuukiiii.finalwork.repository;

import com.yuukiiii.finalwork.model.UserSftwrCom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yuukiiii
 * on 2018/4/11 20:41
 */


public interface UserSftwrComRepository extends JpaRepository<UserSftwrCom,Integer> {

    public void deleteByCommentid(Integer commentid);

    public UserSftwrCom findByUseridAndSoftwareid(Integer userid,Integer softwareid);
}
