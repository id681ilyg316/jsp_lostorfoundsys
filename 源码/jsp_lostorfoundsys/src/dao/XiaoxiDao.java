package dao;

import db.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Users;
import bean.Xiaoxi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

public class XiaoxiDao {
    //查询所有，返回List集合
    public ArrayList<Xiaoxi> findAll()throws SQLException{
        //创建QueryRunner对象
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        //编写sql语句
        String sql = "select * from xiaoxi";
        //调用方法
        ArrayList<Xiaoxi> list = (ArrayList<Xiaoxi>) runner.query(sql, new BeanListHandler(Xiaoxi.class));
        return list;
    }
    /*查找寻物*/
    public ArrayList<Xiaoxi> findsearchAll()throws SQLException{
        //创建QueryRunner对象
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        //编写sql语句
        String sql = "select * from xiaoxi where leixing='寻物'";
        //调用方法
        ArrayList<Xiaoxi> list = (ArrayList<Xiaoxi>) runner.query(sql, new BeanListHandler(Xiaoxi.class));
        return list;
    }
    
    /*查找招领*/
    public ArrayList<Xiaoxi> findfindAll()throws SQLException{
        //创建QueryRunner对象
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        //编写sql语句
        String sql = "select * from xiaoxi where leixing='招领'";
        //调用方法
        ArrayList<Xiaoxi> list = (ArrayList<Xiaoxi>) runner.query(sql, new BeanListHandler(Xiaoxi.class));
        return list;
    }
    
    //按id查询单个
    public Xiaoxi find(int id) throws SQLException{
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select* from xiaoxi where id=?";
        Xiaoxi xiaoxi = (Xiaoxi) runner.query(sql, new BeanHandler(Xiaoxi.class), new Object[]{id});
        return xiaoxi;
    }
  //按user_id查询单个
    public Xiaoxi findByUser(int user_id) throws SQLException{
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select* from xiaoxi where user_id=?";
        Xiaoxi xiaoxi = (Xiaoxi) runner.query(sql, new BeanHandler(Xiaoxi.class), new Object[]{user_id});
        return xiaoxi;
    }
    

    //按主题模糊查询
      public ArrayList<Xiaoxi> findmohuAll(String zhuti)throws SQLException{
        //创建QueryRunner对象
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        //编写sql语句
        String sql = "select* from xiaoxi where zhuti like ? order by id";
        //调用方法
        ArrayList<Xiaoxi> list = (ArrayList<Xiaoxi>) runner.query(sql, new BeanListHandler(Xiaoxi.class), new Object[]{zhuti});
        System.out.println(runner.query(sql, new BeanListHandler(Xiaoxi.class), new Object[]{zhuti}));
        return list;
    }
      
    //添加寻物消息操作
    public int insertsearch(Xiaoxi xiaoxi) throws SQLException{
        int b = 0;
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "insert into xiaoxi (leixing,zhuti,wupin,neirong,lianxiren,tel,shijian,imagesName) values('寻物',?,?,?,?,?,?,?)";
        int num = runner.update(sql,new Object[]{xiaoxi.getZhuti(),xiaoxi.getWupin(),xiaoxi.getNeirong(),xiaoxi.getLianxiren(),xiaoxi.getTel(),xiaoxi.getShijian(),xiaoxi.getImagesName()});
        if(num >0)
            b=1;
        return b;
    }
    //添加招领消息操作
    public int insertfind(Xiaoxi xiaoxi) throws SQLException{
        int b = 0;
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "insert into xiaoxi (leixing,zhuti,wupin,neirong,lianxiren,tel,shijian,imagesName) values('招领',?,?,?,?,?,?,?)";
        int num = runner.update(sql,new Object[]{xiaoxi.getZhuti(),xiaoxi.getWupin(),xiaoxi.getNeirong(),xiaoxi.getLianxiren(),xiaoxi.getTel(),xiaoxi.getShijian(),xiaoxi.getImagesName() });
        if(num >0)
            b=1;
        return b;
    }
    //修改消息操作
    public int update(Xiaoxi xiaoxi)throws SQLException {
        int b = 0;
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "update xiaoxi set zhuti=?,wupin=?,neirong=?,tupianming=?,tupiandizhi=?,shijian=?,user_id=? where id=?";
        int num = runner.update(sql, new Object[]{xiaoxi.getZhuti(),xiaoxi.getWupin(),xiaoxi.getNeirong(),xiaoxi.getLianxiren(),xiaoxi.getTel(),xiaoxi.getShijian(),xiaoxi.getId() });
        if(num>0)
            b = 1;
        return b;
    }
    //删除单个消息
    public int delete(int id)throws SQLException{
        int b = 0;
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "delete from xiaoxi where id=?";
        int num = runner.update(sql, id);
        if(num>0)
            b=1;
        return b;
    }
}
