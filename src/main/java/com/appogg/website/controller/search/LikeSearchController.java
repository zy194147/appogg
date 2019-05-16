package com.appogg.website.controller.search;


import com.appogg.website.msg.ObjectRestResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模糊搜索查询
 */

@RestController
@RequestMapping("/word/")
public class LikeSearchController {

    @RequestMapping("search")
    public ObjectRestResponse searchText(){
        System.out.println("search...text");
        return null;
    }
}
