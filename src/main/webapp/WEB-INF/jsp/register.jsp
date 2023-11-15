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
		    <label for="userId" class="form-label">ユーザーiD</label>
		    <input type="text" class="form-control" id="userId" name="user_id" required>
		  </div>
		  <div class="mb-3">
		    <label for="passwoed" class="form-label">パスワード</label>
		    <input type="text" class="form-control" id="password" name="password" required>
		  </div>
		  <div class="mb-3">
		    <label for="Mail" class="form-label">メールアドレス</label>
		    <input type="text" class="form-control" id="Mail" name="Mail" required>
		  </div>
		  <div class="mb-3">
		    <label for="Name" class="form-label">名前（漢字）</label>
		    <input type="text" class="form-control" id="Name" name="name" required>
		  </div>
		   <div class="mb-3">
		    <label for="age" class="form-label">年齢</label>
		    <input type="text" class="form-control" id="age" name="age" required>
		  </div>
		  <button type="submit" class="btn btn-primary">登録する</button>
		</form>
	</div>
</body>
</html>