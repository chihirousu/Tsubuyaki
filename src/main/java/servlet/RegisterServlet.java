package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegisterLogic;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID  = 1L;


	// 登録画面を表示させる
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	// 登録画面より入力された値をもとにデータベースへ顧客情報を登録する
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 文字コードの設定
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		int num = Integer.parseInt(age);
		//↑が通っているか確認
		System.out.println(user_id);
		System.out.println(mail);
		System.out.println(pass);
		System.out.println(name);
		System.out.println(age);

		if(user_id != null && user_id.length() != 0 && mail != null && mail.length() != 0 && 
				pass != null && pass.length() != 0 && name != null && name.length() != 0 &&
				age != null && age.length() != 0) {
			User user = new User(user_id,name,pass,mail,num);
			RegisterLogic registerLogic = new RegisterLogic();
			registerLogic.execute(user);
			System.out.println("実行されたよ");
		}else {
			request.setAttribute("erroMsg","入力されてない箇所があります");
			System.out.println("実行されtenai");
		}

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
	}


}





