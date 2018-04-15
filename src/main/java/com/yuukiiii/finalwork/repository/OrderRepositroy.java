package com.yuukiiii.finalwork.repository;

import com.yuukiiii.finalwork.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yuukiiii
 * on 2018/4/11 20:39
 */


public interface OrderRepositroy extends JpaRepository<Order,Integer> {
}
