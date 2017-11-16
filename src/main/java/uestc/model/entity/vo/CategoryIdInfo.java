package uestc.model.entity.vo;

import java.util.List;

public class CategoryIdInfo {
    int id;
    String desc;
    List<CategoryIdInfo2> categoryIdInfo2s;

    public CategoryIdInfo() {
    }

    public CategoryIdInfo(int id, String desc, List<CategoryIdInfo2> categoryIdInfo2s) {
        this.id = id;
        this.desc = desc;
        this.categoryIdInfo2s = categoryIdInfo2s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<CategoryIdInfo2> getCategoryIdInfo2s() {
        return categoryIdInfo2s;
    }

    public void setCategoryIdInfo2s(List<CategoryIdInfo2> categoryIdInfo2s) {
        this.categoryIdInfo2s = categoryIdInfo2s;
    }

    @Override
    public String toString() {
        return "CategoryIdInfo{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", categoryIdInfo2s=" + categoryIdInfo2s +
                '}';
    }
}
