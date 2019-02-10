package com.appogg.website.biz.menu;

import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggMenu;
import com.appogg.website.mapper.OggMenuMapper;
import com.appogg.website.msg.ObjectRestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OggMenuBiz extends BaseBiz<OggMenuMapper,OggMenu> {

    public ObjectRestResponse listMenu(){
        List<OggMenu> oggMenuList = this.mapper.selectAll();
        ObjectRestResponse objectRestResponse = new ObjectRestResponse().rel(true).data(oggMenuList);
        return objectRestResponse;
    }
}
