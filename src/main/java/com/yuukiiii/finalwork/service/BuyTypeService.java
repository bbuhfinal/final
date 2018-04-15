package com.yuukiiii.finalwork.service;

import java.util.List;
import com.yuukiiii.finalwork.model.BuyType;
import com.yuukiiii.finalwork.repository.BuyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yuukiiii
 * on 2018/4/11 20:47
 */

@Service
public class BuyTypeService {

    @Autowired
    private BuyTypeRepository buyTypeRepository;

    public List<BuyType> getAllBuyTypeList(){
        return buyTypeRepository.findAll();
    }

    public BuyType getOneBuyType(Integer btid){
        return buyTypeRepository.getOne(btid);
    }

    public BuyType addBuyType(BuyType buyType){
        return buyTypeRepository.save(buyType);
    }

    public void deleteBuyTypeByid(Integer btid){
        buyTypeRepository.deleteById(btid);
    }

    public BuyType updateBuyType(BuyType buyType){
        return  buyTypeRepository.save(buyType);
    }

}
