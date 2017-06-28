package bawei.com.zhoudao1502s20170522;

/**
 * date:2017/5/22
 * author:周道(leovo)
 * funcation:
 */

public class Bean {
    private int pic;
    private String name;
    private String news;

    public Bean(int pic, String name, String news) {
        this.pic = pic;
        this.name = name;
        this.news = news;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
