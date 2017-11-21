package uestc.model.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import uestc.model.dao.ActivityMapper;
import uestc.model.dao.CategoryMapper;
import uestc.model.dao.UserMapper;
import uestc.model.entity.dao.Activity;
import uestc.model.entity.dao.User;
import uestc.model.entity.vo.ActivityDetailVo;
import uestc.model.entity.vo.ActivityVo;
import uestc.model.entity.vo.CategoryIdInfo2;
import uestc.model.service.ActivityService;
import uestc.model.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("activityServiceImpl")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    @Qualifier("activityMapper")
    private ActivityMapper activityMapper;

    @Autowired
    @Qualifier("categoryMapper")
    private CategoryMapper categoryMapper;

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Override
    public List<ActivityVo> listByCategoryId(int categoryid, int page, int pagesize) {
        List<Activity> activities=new ArrayList<>();
        activities=activityMapper.selectAllByCategoryId(categoryid,page,pagesize);

        List<ActivityVo> activityVos=new ArrayList<>();
        if(activities==null)
            return null;
        for(Activity activity:activities){
            ActivityVo activityVo=new ActivityVo();

            activityVo.setId(activity.getId());
            activityVo.setName(activity.getName());

            User user= userMapper.selectByPrimaryKey(activity.getUserid());
            activityVo.setInstitution(user.getInstitution());

            activityVo.setCreatetime(activity.getCreatetime().getTime());
            //为每个活动赋值分类lable
            //获得lable
            activityVo.setLable(getLableByCategoryid(activity.getCategoryid()));

            activityVos.add(activityVo);

        }
        return activityVos;
    }

    @Override
    public List<ActivityVo> listByDesc(String desc,int page,int pagesize) {
        List<Activity> activities=new ArrayList<>();
        if(StringUtils.isEmpty(desc)){
            //查出所有活动
            activities=activityMapper.selectAll(null,page*pagesize,pagesize);
        }
        else {
            activities=activityMapper.selectAll(desc,page*pagesize,pagesize);
        }
        List<ActivityVo> activityVos=new ArrayList<>();
        if(activities==null)
            return null;
        for(Activity activity:activities){
            ActivityVo activityVo=new ActivityVo();

            activityVo.setId(activity.getId());
            activityVo.setName(activity.getName());

            User user= userMapper.selectByPrimaryKey(activity.getUserid());
            activityVo.setInstitution(user.getInstitution());

            activityVo.setCreatetime(activity.getCreatetime().getTime());
            //为每个活动赋值分类lable
            //获得lable
            activityVo.setLable(getLableByCategoryid(activity.getCategoryid()));

            activityVos.add(activityVo);

        }
        return activityVos;
    }

    @Override
    public List<ActivityVo> listByEmail(String email) {

        User user = userService.getUserByEmail(email);
        //1.获取userid 和institution
        int userid = user.getId();
        String institution = user.getInstitution();

        //2.依据userid查activity
        List<Activity> activities = new ArrayList<>();
        activities = activityMapper.selectByUserId(userid);

        List<ActivityVo> activityVos = new ArrayList<>();
        for (Activity activity : activities) {
            ActivityVo activityVo = new ActivityVo();

            activityVo.setId(activity.getId());
            activityVo.setName(activity.getName());
            activityVo.setInstitution(institution);
            activityVo.setCreatetime(activity.getCreatetime().getTime());
            //3.为每个活动赋值分类lable
            //获得lable
            activityVo.setLable(getLableByCategoryid(activity.getCategoryid()));

            activityVos.add(activityVo);
        }

        return activityVos;
    }

    @Override
    public int addActivity(ActivityDetailVo activityDetailVo) {
        Activity activity = new Activity();

        activity.setUserid(activityDetailVo.getUserid());
        activity.setName(activityDetailVo.getName());
        activity.setCategoryid(activityDetailVo.getCategoryid());
        activity.setTheme(activityDetailVo.getTheme());
        activity.setContent(activityDetailVo.getContent());
        activity.setContact(activityDetailVo.getContact());
        activity.setPlace(activityDetailVo.getPlace());
        activity.setStarttime(new Date(activityDetailVo.getStarttime()));
        activity.setEndtime(new Date(activityDetailVo.getEndtime()));
        activity.setCreatetime(new Date());
        activity.setUpdatetime(new Date());

        int count = activityMapper.insert(activity);
        if (count != 0)
            return activity.getId();
        return -1;
    }

    @Override
    public int delete(int id, int userid) {
        return activityMapper.delete(id, userid);
    }

    @Override
    public ActivityDetailVo search(int id) {
        //1.获取activity
        Activity activity = activityMapper.selectByPrimaryKey(id);
        int userid = activity.getUserid();
        int categoryid = activity.getCategoryid();

        //1.获取lable
        String lable = getLableByCategoryid(categoryid);

        //2.获取institution
        String institution = userMapper.selectByPrimaryKey(userid).getInstitution();

        ActivityDetailVo activityDetailVo = new ActivityDetailVo();

        activityDetailVo.setId(activity.getId());
        activityDetailVo.setName(activity.getName());
        activityDetailVo.setTheme(activity.getTheme());
        activityDetailVo.setContent(activity.getContent());
        activityDetailVo.setContact(activity.getContact());
        activityDetailVo.setLable(lable);
        activityDetailVo.setPlace(activity.getPlace());
        activityDetailVo.setInstitution(institution);

        activityDetailVo.setStarttime(activity.getStarttime().getTime());
        activityDetailVo.setEndtime(activity.getEndtime().getTime());

        return activityDetailVo;
    }

    @Override
    public int update(ActivityDetailVo activityDetailVo) {
        Activity activity = new Activity();

        activity.setId(activityDetailVo.getId());
        activity.setUserid(null);
        activity.setName(activityDetailVo.getName());

        //todo
        activity.setCategoryid(activityDetailVo.getCategoryid());

        activity.setTheme(activityDetailVo.getTheme());
        activity.setContent(activityDetailVo.getContent());
        activity.setContact(activityDetailVo.getContact());
        activity.setPlace(activityDetailVo.getPlace());
        activity.setStarttime(new Date(activityDetailVo.getStarttime()));
        activity.setEndtime(new Date(activityDetailVo.getEndtime()));
        activity.setCreatetime(null);
        activity.setUpdatetime(new Date());
        int row = activityMapper.updateByPrimaryKeySelective(activity);
        return row;
    }

    private String getLableByCategoryid(int categoryid) {
        //todo
        StringBuilder lable = new StringBuilder();
        CategoryIdInfo2 categoryIdInfo2 = categoryMapper.selectNameAndParentById(categoryid);
        lable.append(categoryIdInfo2.getDesc());
        lable.append(";");

        categoryIdInfo2 = categoryMapper.selectNameAndParentById(categoryIdInfo2.getId());
        lable.append(categoryIdInfo2.getDesc());
        return lable.toString();
    }
}
