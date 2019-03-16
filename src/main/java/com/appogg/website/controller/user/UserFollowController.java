package com.appogg.website.controller.user;

import com.appogg.website.biz.user.UserFollowBiz;
import com.appogg.website.entity.OggFollow;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.rest.BaseController;
import com.appogg.website.util.Query;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/follow/")
public class UserFollowController extends BaseController<UserFollowBiz, OggFollow> {


    /**
     * 查找关注我的
     * @param params
     * @return
     */
    @GetMapping("listFollow")
    public TableResultResponse<OggFollow> listFollowers(@RequestParam Map<String,Object> params){

        Query query = new Query(params);
        return this.baseBiz.listFollowers(query);
    }

    /**
     * 查找我关注的
     * @param params
     * @return
     */
    @GetMapping("listFollowTo")
    public TableResultResponse<OggFollow> listToFollowers(@RequestParam Map<String,Object> params){

        Query query = new Query(params);
        return this.baseBiz.listToFollowers(query);
    }



    @GetMapping("status")
    public ObjectRestResponse getFollowStatus(@RequestParam Map<String,Object> params, HttpServletRequest request){

        Query query = new Query(params);
        return this.baseBiz.getFollowStatus(query,request);
    }

    @GetMapping("followUser")
    public ObjectRestResponse followUser(@RequestParam Map<String,Object> params, HttpServletRequest request){

        Query query = new Query(params);
        return this.baseBiz.followUser(query,request);
    }


}
