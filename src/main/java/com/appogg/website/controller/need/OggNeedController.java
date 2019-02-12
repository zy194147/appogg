package com.appogg.website.controller.need;

import com.appogg.website.biz.need.OggNeedBiz;
import com.appogg.website.entity.OggNeed;
import com.appogg.website.rest.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/need/")
public class OggNeedController extends BaseController<OggNeedBiz,OggNeed> {
}
