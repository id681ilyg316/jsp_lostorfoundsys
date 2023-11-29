package dao;

import java.sql.SQLException;

import db.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bean.Guanliyuan;
import bean.Users;


public class GuanliyuanDao {

    //按姓名查询单个
    public Guanliyuan find(String zhanghao)throws SQLException{
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select* from guanliyuan where zhanghao=?";
        Guanliyuan guanliyuan = (Guanliyuan) runner.query(sql, new BeanHandler(Guanliyuan.class), new Object[]{zhanghao});
        return guanliyuan;
    }
    //修改用户操作
    public int update(Guanliyuan guanliyuan)throws SQLException{
        int b = 0;
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "update guanliyuan set zhanghao=?,mima=? where id=?";
        int num = runner.update(sql, new Object[]{guanliyuan.getZhanghao(),guanliyuan.getMima(),guanliyuan.getId() });
        if(num>0)
            b = 1;
        return b;
    }
    
    public String getPassword(String zhanghao) {
		String mima=null;
		try {
			Guanliyuan guanliyuan= this.find(zhanghao);
			if(guanliyuan!=null) {
			 mima=guanliyuan.getMima();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mima;
	}
}

