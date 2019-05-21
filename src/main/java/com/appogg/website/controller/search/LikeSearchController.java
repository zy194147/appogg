package com.appogg.website.controller.search;


import com.appogg.website.biz.search.LikeSearchBiz;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 模糊搜索查询
 */

@RestController
@RequestMapping("/word/")
public class LikeSearchController {


    @Autowired
    private LikeSearchBiz likeSearchBiz;

    @GetMapping("search")
    public ObjectRestResponse searchText(@RequestParam Map<String,Object> params){

        Query query = new Query(params);
        return this.likeSearchBiz.likeSearchWord(query);
    }
}
