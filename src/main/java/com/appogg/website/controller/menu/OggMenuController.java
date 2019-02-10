package com.appogg.website.controller.menu;

import com.appogg.website.biz.menu.OggMenuBiz;
import com.appogg.website.entity.OggMenu;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.rest.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu/")
public class OggMenuController extends BaseController<OggMenuBiz,OggMenu> {

    @RequestMapping("list")
    public ObjectRestResponse listMenu(){
        return this.baseBiz.listMenu();
    }
}
