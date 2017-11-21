package uestc.model.entity.vo;

public class VisitorSearchVo {
    String type;
    String desc;
    int page;
    int pagesize;

    public VisitorSearchVo() {
    }

    public VisitorSearchVo(String type, String desc, int page, int pagesize) {
        this.type = type;
        this.desc = desc;
        this.page = page;
        this.pagesize = pagesize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    @Override
    public String toString() {
        return "VisitorSearchVo{" +
                "type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", page=" + page +
                ", pagesize=" + pagesize +
                '}';
    }
}
