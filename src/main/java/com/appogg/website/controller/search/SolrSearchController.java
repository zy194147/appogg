package com.appogg.website.controller.search;

import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.rest.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/solr/")
public class SolrSearchController {

    @RequestMapping("search")
    public ObjectRestResponse searchText(){
        System.out.println("search...text");
        return null;
    }

}
