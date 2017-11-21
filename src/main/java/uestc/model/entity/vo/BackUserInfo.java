package uestc.model.entity.vo;

import java.util.Date;

public class BackUserInfo {
    private String id;
    private String email;
    private String institution;
    private Date createtime;
    private String ifChecked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getIfChecked() {
        return ifChecked;
    }

    public void setIfChecked(String ifChecked) {
        this.ifChecked = ifChecked;
    }

    @Override
    public String toString() {
        return "BackUserInfo{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", institution='" + institution + '\'' +
                ", createtime=" + createtime +
                ", ifChecked='" + ifChecked + '\'' +
                '}';
    }
}
