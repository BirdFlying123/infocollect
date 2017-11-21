package uestc.model.entity.vo;

public class ActivityVo {


    int id;
    String name;
    String institution;
    String lable;
    long createtime;

    public ActivityVo() {
    }

    public ActivityVo(int id, String name, String institution, String lable, long createtime) {
        this.id = id;
        this.name = name;
        this.institution = institution;
        this.lable = lable;
        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "ActivityVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", institution='" + institution + '\'' +
                ", lable='" + lable + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
