package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import config.DBconfig;

public class RegisterDAO {
	
	private final String JDBC_URL ="jdbc:postgresql://localhost:5432/postgres";
	private final String DB_USER = "uejochihiro";
	private final String DB_PASS = "kooy0913";

	
	public void register(String name, String password) throws FileNotFoundException {

	

	// データベースへの接続
	// try〜catch〜resources構文を使用
	try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
		
		// 実行SQL
		  String sql = "SELECT ID,NAME,TEXT FROM ACCOUNTS ORDER BY ID DESC";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	      // SELECTを実行
	      ResultSet rs = pStmt.executeQuery();
	      
		// オートコミット機能を無効化
		conn.setAutoCommit(false);

		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			// 変数register_sqlの一番目の?にnameをセット
			stmt.setString(1, name);
			// 変数register_sqlの一番目の?にpassをセット
			stmt.setString(2, password);
			// SQLの実行
			stmt.executeUpdate();

			// コミット
			conn.commit();
			System.out.println("コミット処理を行いました");
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("ロールバック処理を行いました");
			e.printStackTrace();
		}
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
}
}