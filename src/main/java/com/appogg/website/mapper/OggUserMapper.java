package com.appogg.website.mapper;

import com.appogg.website.entity.OggUser;
import tk.mybatis.mapper.common.Mapper;

public interface OggUserMapper extends Mapper<OggUser> {

    OggUser selectByUserName(String userName);
}