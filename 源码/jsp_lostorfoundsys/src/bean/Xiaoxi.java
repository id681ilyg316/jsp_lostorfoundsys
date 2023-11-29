package bean;

public class Xiaoxi {
    private  Integer id;
    private String zhuti;
    private  String neirong;
    private String shijian;
    private String wupin;
    private String lianxiren;
    private String tel;
    private String imagesName;

	public String getImagesName() {
		return imagesName;
	}

	public void setImagesName(String imagesName) {
		this.imagesName = imagesName;
	}

	public String getLianxiren() {
		return lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
    public String toString() {
        return "Xiaoxi{" +
                "id=" + id +
                ", zhuti='" + zhuti + '\'' +
                ", neirong='" + neirong + '\'' +
                ", shijian='" + shijian + '\'' +
                ", wupin='" + wupin + '\'' +
                ", wupin='" + lianxiren + '\'' +
                ", wupin='" + tel + '\'' +
                ", imagesPath='" + imagesName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZhuti() {
        return zhuti;
    }

    public void setZhuti(String zhuti) {
        this.zhuti = zhuti;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public String getWupin() {
        return wupin;
    }

    public void setWupin(String wupin) {
        this.wupin = wupin;
    }
}
