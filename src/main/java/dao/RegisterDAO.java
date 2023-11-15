package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class RegisterDAO {

	private final String JDBC_URL ="jdbc:postgresql://localhost:5432/postgres";
	private final String DB_USER = "uejochihiro";
	private final String DB_PASS = "kooy0913";

	public boolean create(User user) {
		// JDBCドライバを読み込む
		try {
			Class.forName("org.postgresql.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		// データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文の準備
			String sql = "INSERT INTO ACCOUNTS(USER_ID,PASS,MAIL,NAME,AGE) VALUES(?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
//			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, user.getuser_id());
			pStmt.setString(2, user.getPass());
			pStmt.setString(3, user.getMail());
			pStmt.setString(4, user.getName());
			pStmt.setInt(5, user.getAge());
//			
			// INSERT文を実行（resultには追加された行数が代入される）
			int result = pStmt.executeUpdate();
			
			

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}