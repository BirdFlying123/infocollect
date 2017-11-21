package uestc.model.entity.vo;

public class CategoryIdInfo2 {
    int id;
    String desc;

    public CategoryIdInfo2() {
    }

    public CategoryIdInfo2(int id, String desc) {
        this.id = id;
        this.desc = desc;
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

    @Override
    public String toString() {
        return "CategoryIdInfo2{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
