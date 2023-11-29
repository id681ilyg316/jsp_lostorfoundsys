package bean;

public class Guanliyuan {
    private Integer id;
    private String zhanghao;
    private String mima;

    @Override
    public String toString() {
        return "Guanliyuan{" +
                "id=" + id +
                ", zhanghao='" + zhanghao + '\'' +
                ", mima='" + mima + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZhanghao() {
        return zhanghao;
    }

    public void setZhanghao(String zhanghao) {
        this.zhanghao = zhanghao;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }
}
