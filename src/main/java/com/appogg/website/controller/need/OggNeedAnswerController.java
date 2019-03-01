package com.appogg.website.controller.need;

import com.appogg.website.biz.need.OggNeedAnswerBiz;
import com.appogg.website.entity.OggNeedAnswer;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import com.appogg.website.vo.need.NeedAnswerVO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/need/answer/")
public class OggNeedAnswerController extends BaseController<OggNeedAnswerBiz,OggNeedAnswer> {

    @RequestMapping("detail")
    public TableResultResponse selectCommentByArticleId(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return this.baseBiz.selectAnswerByQuery(query);
    }
    @PostMapping("add")
    public ObjectRestResponse addCommentByArticleId(@RequestBody NeedAnswerVO answerVO){
        return this.baseBiz.insertNeedAnswer(answerVO);
    }

}
