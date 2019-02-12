package com.appogg.website.biz.user;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggArticle;
import com.appogg.website.entity.OggUser;
import com.appogg.website.mapper.OggUserMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.util.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;

@Service
public class OggUserBiz extends BaseBiz<OggUserMapper,OggUser> {

    public ObjectRestResponse selectUserDetail(Query query){
        int userId = 0;
        OggUser user = null;
        Example example = new Example(OggUser.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("userId".equals(entry.getKey())) {
                        userId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
            if(userId != 0){
                user = this.mapper.selectByPrimaryKey(userId);
            }
        }
        return new ObjectRestResponse().rel(true).data(user);
    }

}
