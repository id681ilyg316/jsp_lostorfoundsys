package db;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	private static DataSource dataSource= null;
	static{
		dataSource = new ComboPooledDataSource("itcast");
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
}
