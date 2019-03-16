package com.appogg.website.mapper;

import com.appogg.website.entity.OggFollow;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface OggFollowMapper extends Mapper<OggFollow> {

    /**
     * 取消关注
     * @param followUserId
     * @param followToUserId
     */
    public void unfollowUser(@Param("followUserId") int followUserId, @Param("followToUserId") int followToUserId);
}

