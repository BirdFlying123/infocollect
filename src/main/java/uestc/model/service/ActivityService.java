package uestc.model.service;


import uestc.model.entity.vo.ActivityDetailVo;
import uestc.model.entity.vo.ActivityVo;

import java.util.List;

public interface ActivityService {
    public List<ActivityVo> listByCategoryId(int categoryid,int page,int pagesize);
    public List<ActivityVo> listByDesc(String desc,int page,int pagesize);
    public List<ActivityVo> listByEmail(String email);
    public int addActivity(ActivityDetailVo activityDetailVo);
    public int delete(int id,int userid);
    public ActivityDetailVo search(int id);
    public int update(ActivityDetailVo activityDetailVo);
}
