package com.appogg.website.mapper;

import com.appogg.website.entity.Hello;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface HelloMapper extends Mapper<Hello> {
}