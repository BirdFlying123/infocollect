package uestc.model.entity.vo;

public class ActivityDetailVo {

    int id;
    int userid;
    String name;
    int categoryid;
    String theme;
    String content;
    String contact;
    String place;
    long starttime;
    long endtime;
    long updatetime;
    long createtime;

    String institution;
    String lable;


    public ActivityDetailVo() {
    }

    public ActivityDetailVo(int id, int userid, String name, int categoryid, String theme, String content, String contact, String place, long starttime, long endtime, long updatetime, long createtime, String institution, String lable) {
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
        this.updatetime = updatetime;
        this.createtime = createtime;
        this.institution = institution;
        this.lable = lable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }

    public long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(long updatetime) {
        this.updatetime = updatetime;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "ActivityVo{" +
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
                ", updatetime=" + updatetime +
                ", createtime=" + createtime +
                ", institution='" + institution + '\'' +
                ", lable='" + lable + '\'' +
                '}';
    }
}


