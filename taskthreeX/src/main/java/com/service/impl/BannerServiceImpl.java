package com.service.impl;

import com.dao.BannerMapper;
import com.pojo.Banner;
import com.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("bannerServiceImpl")
public class BannerServiceImpl implements BannerService {
    @Resource
    BannerMapper bannerMapper;
    @Override
    public int deleteByPrimaryKey(Integer bannerId) { return 0; }

    @Override
    public int insert(Banner record) {
        return 0;
    }

    @Override
    public int insertSelective(Banner record) {
        return 0;
    }

//    @Override
//    public Author selectByPrimaryKey(Integer bannerId) {
//        return null;
//    }

    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        return 0;
    }

    @Override
    public List<Banner> selectByDynamic() {

        return bannerMapper.selectByDynamic();
    }


}
