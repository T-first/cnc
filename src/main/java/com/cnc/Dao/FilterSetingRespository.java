package com.cnc.Dao;

import com.cnc.entity.FilterSetingParams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface FilterSetingRespository extends JpaRepository<FilterSetingParams,Integer> {
//    @Modifying
//    @Query("update cnc  set c. attentionNum= ?1 ,c.alarmNum=?2 where c.alarmNum = ?3")
//    int updateSetting(BigDecimal a, BigDecimal b,Integer c);


}