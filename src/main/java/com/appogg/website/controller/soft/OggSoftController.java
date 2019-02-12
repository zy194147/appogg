package com.appogg.website.controller.soft;

import com.appogg.website.biz.article.OggArticleBiz;
import com.appogg.website.biz.soft.OggSoftBiz;
import com.appogg.website.entity.OggSoft;
import com.appogg.website.rest.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soft")
public class OggSoftController extends BaseController<OggSoftBiz,OggSoft> {
}
