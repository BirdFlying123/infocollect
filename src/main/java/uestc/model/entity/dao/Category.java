package uestc.model.entity.dao;

import java.util.Date;

public class Category {
    private Integer id;

    private String parentid;

    private String name;

    private Integer status;

    private Date createtime;

    private Date updatetime;

    public Category(Integer id, String parentid, String name, Integer status, Date createtime, Date updatetime) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Category() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "Category{" +
                "id=" + id +
                ", parentid='" + parentid + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}