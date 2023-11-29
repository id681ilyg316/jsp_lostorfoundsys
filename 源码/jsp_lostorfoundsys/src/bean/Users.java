package bean;

public class Users {
    private Integer id;
    private String xuehao;
    private String mima;
    private String xingming;
    private String sex;
    private String xibie;
    private String dianhua;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", xuehao='" + xuehao + '\'' +
                ", mima='" + mima + '\'' +
                ", xingming='" + xingming + '\'' +
                ", sex='" + sex + '\'' +
                ", xibie='" + xibie + '\'' +
                ", dianhua='" + dianhua + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXuehao() {
        return xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getXibie() {
        return xibie;
    }

    public void setXibie(String xibie) {
        this.xibie = xibie;
    }

    public String getDianhua() {
        return dianhua;
    }

    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }
}
