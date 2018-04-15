package com.yuukiiii.finalwork.service;

import java.util.List;
import com.yuukiiii.finalwork.model.Software;
import com.yuukiiii.finalwork.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yuukiiii
 * on 2018/4/12 14:35
 */

@Service
public class SoftwareService {

    @Autowired
    private SoftwareRepository softwareRepository;

    public Software addSoftware(Software software){
        return softwareRepository.save(software);
    }

    public void deleteSoftwareById(Integer softwareid){
        softwareRepository.deleteById(softwareid);
    }

    public List<Software> getAllSoftware(){
        return softwareRepository.findAll();
    }

    public Software getOneSoftwareById(Integer softwareid){
        return softwareRepository.getOne(softwareid);
    }

    public Software updateSoftware(Software software){
        return softwareRepository.save(software);
    }
}
