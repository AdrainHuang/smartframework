package thread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AdrainHuang on 2017/2/4.
 */
public class ProductServiceImpl implements ProductService{

	private static final String UPDATE_PRODUCT_SQL = "update product set price = ? where id = ?";

	private static final String INSERT_LOG_SQL = "insert into log (created, description) values (?,?)";


	public void updateProductPrice(long productId, int price) {
		try {
			Connection conn = DBUtil.getConnnection();
			//关闭自动提交事务（开启事务)
			conn.setAutoCommit(false);
			//更新产品
			updateProduct(conn,UPDATE_PRODUCT_SQL,productId,price);
			//插入日志
			insertLog(conn,INSERT_LOG_SQL,"Create product");
			//提交事物
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void insertLog(Connection conn, String insertLogSql, String logDescription) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(insertLogSql);
		pstmt.setString(1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
		pstmt.setString(2, logDescription);
		int rows = pstmt.executeUpdate();
		if (rows != 0){
			System.out.println("Insert log success!");
		}
	}

	private void updateProduct(Connection conn, String updateProductSql, long productId, int price) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(updateProductSql);
		pstmt.setInt(1,price);
		pstmt.setLong(2, productId);
		int rows = pstmt.executeUpdate();
		if (rows != 0){
			System.out.println("Update product success");
		}
	}
}
