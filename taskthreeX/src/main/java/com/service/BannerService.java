package com.service;

import com.pojo.Banner;

import java.util.List;

/**
 * @author wangqing
 */
public interface BannerService {
    int deleteByPrimaryKey(Integer bannerId);

    int insert(Banner record);

    int insertSelective(Banner record);

//    Author selectByPrimaryKey(Integer bannerId);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> selectByDynamic();


}
