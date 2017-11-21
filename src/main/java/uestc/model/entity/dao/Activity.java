package uestc.model.entity.dao;

import java.util.Date;

public class Activity {
    private Integer id;

    private Integer userid;

    private String name;

    private Integer categoryid;

    private String theme;

    private String content;

    private String contact;

    private String place;

    private Date starttime;

    private Date endtime;

    private Date createtime;

    private Date updatetime;

    public Activity(Integer id, Integer userid, String name, Integer categoryid, String theme, String content, String contact, String place, Date starttime, Date endtime, Date createtime, Date updatetime) {
        this.id = id;
        this.userid = userid;
        this.name = name;
        this.categoryid = categoryid;
        this.theme = theme;
        this.content = content;
        this.contact = contact;
        this.place = place;
        this.starttime = starttime;
        this.endtime = endtime;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Activity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", userid=" + userid +
                ", name='" + name + '\'' +
                ", categoryid=" + categoryid +
                ", theme='" + theme + '\'' +
                ", content='" + content + '\'' +
                ", contact='" + contact + '\'' +
                ", place='" + place + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}