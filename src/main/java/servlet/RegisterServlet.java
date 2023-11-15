package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


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

			// 登録画面で入力された値を取得
			String user_name = request.getParameter("name");
			String user_password = request.getParameter("user_password");

			// ユーザーのセッションを取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			RegisterDAO register = new RegisterDAO();
			// 登録処理を実行
			register.register(user_name, user_password);
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
			dispatcher.forward(request, response);
		}
	}