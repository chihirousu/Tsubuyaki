<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
	<div class="mx-auto" style="width: 300px;">
		<h1 class="mb-3" style="text-align: center">登録画面</h1>
		<form action="/dokoTsubu/RegisterServlet" method="post">
		  <div class="mb-3">
		    <label for="user_id" class="form-label">ユーザーiD</label>
		    <input type="text" name="user_id" required>
		  </div>
		  <div class="mb-3">
		    <label for="pass" class="form-label">パスワード</label>
		   <input type="text" name="pass" required>
		  </div>
		  <div class="mb-3">
		    <label for="mail" class="form-label">メールアドレス</label>
		   <input type="text" name="mail" required>
		  </div>
		  <div class="mb-3">
		    <label for="name" class="form-label">名前（漢字）</label>
		    <input type="text" name="name" required>
		  </div>
		   <div class="mb-3">
		    <label for="age" class="form-label">年齢</label>
		    <input type="text" name="age" required>
		  </div>
		  <button type="submit" class="btn btn-primary">登録する</button>
		</form>
	</div>
</body>
</html>