package com.appogg.website.biz.user;

import com.appogg.website.auth.UserCheck;
import com.appogg.website.biz.BaseBiz;
import com.appogg.website.entity.OggFollow;
import com.appogg.website.entity.OggUser;
import com.appogg.website.mapper.OggFollowMapper;
import com.appogg.website.mapper.OggUserMapper;
import com.appogg.website.msg.ObjectRestResponse;
import com.appogg.website.msg.TableResultResponse;
import com.appogg.website.util.Query;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class UserFollowBiz extends BaseBiz<OggFollowMapper,OggFollow> {

    @Autowired
    private OggUserMapper userMapper;

    @Autowired
    private UserCheck userCheck;

    /**
     * 关注我的
     * @param query
     * @return
     */
    public TableResultResponse listFollowers(Query query){

        List<OggFollow> followList = new ArrayList<>();
        List<OggUser> userList = new ArrayList<>();
        Page result = PageHelper.startPage(query.getPage(),query.getLimit());

        Example example = new Example(OggFollow.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString())) {
                    if ("userId".equals(entry.getKey())) {
                        // 查出关注我的 ( followToUserId 为我的 id )
                        criteria.andEqualTo("followToUserId",entry.getValue());
                    }
                }
            }
            example.setOrderByClause("create_date_time desc");
            followList = this.mapper.selectByExample(example);
        }
        for(OggFollow follow:followList){
            OggUser user = userMapper.selectByPrimaryKey(follow.getFollowToUserId());
            userList.add(user);
        }

        return new TableResultResponse<>(result.getTotal(),userList);
    }

    /**
     * 我关注的
     * @param query
     * @return
     */
    public TableResultResponse listToFollowers(Query query){


        List<OggFollow> followToList = new ArrayList<>();
        List<OggUser> userList = new ArrayList<>();

        Page result = PageHelper.startPage(query.getPage(),query.getLimit());

        Example example = new Example(OggFollow.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString())) {
                    if ("userId".equals(entry.getKey())) {
                        // 查出关注我的 ( followUserId 为我的 id )
                        criteria.andEqualTo("followUserId",entry.getValue());
                    }
                }
            }
            example.setOrderByClause("create_date_time desc");
            followToList = this.mapper.selectByExample(example);
        }
        for(OggFollow follow:followToList){
            OggUser user = userMapper.selectByPrimaryKey(follow.getFollowToUserId());
            userList.add(user);
        }

        return new TableResultResponse<>(result.getTotal(),userList);
    }

    /**
     * 关注状态   0 未关注, 1 已关注
     * @param query
     * @return
     */
    public ObjectRestResponse getFollowStatus(Query query, HttpServletRequest request){

        OggUser loginUser = userCheck.getLoginUser(request);

        List<OggFollow> followToList = new ArrayList<>();
        List<OggUser> userList = new ArrayList<>();
        int toFollowUserId ;

        Page result = PageHelper.startPage(query.getPage(),query.getLimit());

        Example example = new Example(OggFollow.class);
        if (query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString())) {
                    if ("userId".equals(entry.getKey())) {
                        criteria.andEqualTo("followToUserId",entry.getValue());
                        criteria.andEqualTo("followUserId",loginUser.getId());
                    }
                }
            }

            followToList = this.mapper.selectByExample(example);
        }
        if(followToList.size() > 0){
            return new ObjectRestResponse().data("1");

        } else {
            return new ObjectRestResponse().data("0");

        }

    }



    public ObjectRestResponse followUser(Query query, HttpServletRequest request){

        OggUser loginUser = userCheck.getLoginUser(request);
        int followToUserId = 0;
        if (query.entrySet().size() > 0) {
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (StringUtils.isNotBlank(entry.getValue().toString())) {
                    if ("userId".equals(entry.getKey())) {
                        System.out.println("lsdakjfslkdaj");
                        followToUserId = Integer.parseInt(entry.getValue().toString());
                    }
                }
            }
        }
        System.out.println("关注： " + followToUserId);
        OggUser user = userMapper.selectByPrimaryKey(followToUserId);
        if(user != null){
            OggFollow follow = new OggFollow();
            follow.setCreateDateTime(new Date());
            follow.setModifyDateTime(new Date());
            follow.setFollowUserId(loginUser.getId());
            follow.setFollowUserName(loginUser.getUserName());
            follow.setFollowToUserId(user.getId());
            follow.setFollowToUserName(user.getUserName());
            this.mapper.insert(follow);
            // 关注成功返回 1
            return new ObjectRestResponse().data("1");

        }
        // 关注失败返回 0
        return new ObjectRestResponse().data("0");

    }

}
