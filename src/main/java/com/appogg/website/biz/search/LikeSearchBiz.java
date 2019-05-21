package com.appogg.website.biz.search;


import com.appogg.website.entity.OggArticle;
import com.appogg.website.entity.OggNeed;
import com.appogg.website.entity.OggSoft;
import com.appogg.website.mapper.OggArticleMapper;
import com.appogg.website.mapper.OggNeedMapper;
import com.appogg.website.mapper.OggSoftMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.util.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LikeSearchBiz {

    @Autowired
    private OggNeedMapper needMapper;
    @Autowired
    private OggSoftMapper softMapper;
    @Autowired
    private OggArticleMapper articleMapper;

    public ObjectRestResponse likeSearchWord(Query query){

        List<OggArticle> articleList;
        List<OggNeed> needList;
        List<OggSoft> softList;

        Map<String,Object> searchResultMap = new HashMap<String,Object>();



        Example articleExample = new Example(OggArticle.class);
        Example.Criteria articleCriteria = articleExample.createCriteria();

        Example softExample = new Example(OggSoft.class);
        Example.Criteria softCriteria = softExample.createCriteria();

        Example needExample = new Example(OggNeed.class);
        Example.Criteria needCriteria = needExample.createCriteria();

        if (query.entrySet().size() > 0) {
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString()) && !"0".equals(entry.getValue().toString())) {
                    if ("wd".equals(entry.getKey())) {

                        articleCriteria.andLike("articleTitleName","%" + entry.getValue().toString() + "%");

                        softCriteria.andLike("softTitleName","%" + entry.getValue().toString() + "%");

                        needCriteria.andLike("needTitleName","%" + entry.getValue().toString() + "%");

                        System.out.println(entry.getValue());
                    }
                }
            }
        }

        articleList = articleMapper.selectByExample(articleExample);
        softList = softMapper.selectByExample(softExample);
        needList = needMapper.selectByExample(needExample);

        searchResultMap.put("articleList",articleList);
        searchResultMap.put("softList",softList);
        searchResultMap.put("needList",needList);

        return new ObjectRestResponse().rel(true).data(searchResultMap);

    }
}
