package thread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by AdrainHuang on 2017/2/4.
 */
public class DBUtil {

	//定义一个用于放置数据库连接的局部线程变量（使每个线程都拥有自己的选择）
	private static ThreadLocal<Connection> conContainer = new ThreadLocal<Connection>();
	//数据库配置
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/adrain?useUnincode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
	private static final String username = "root";
	private static final String password = "root";

	//定义一个数据库连接
//	private static Connection conn = null;

	//获取连接
	public static Connection getConnnection(){
		Connection conn = conContainer.get();
		try {
			if (conn == null){
				Class.forName(driver);
				conn = DriverManager.getConnection(url,username,password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  conn;
	}

	//关闭连接
	public static void closeConnection(){
		Connection conn = conContainer.get();
		if (conn != null){
			try {
				conn.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
