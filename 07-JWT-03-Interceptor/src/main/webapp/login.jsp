<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
<form>
    <table align="center">
        <tr>
            <td>账号</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="reset" value="重置">
                <button onclick="login()" type="button">登录</button>
            </td>
        </tr>
    </table>
</form>
</body>
<script type="application/javascript">
    function login() {
        var data = $("form").serialize();

        $.ajax({
            type: "post",
            url: "/user/login",
            data: data,
            success: function (resp) {
                if (!resp.success) {
                    alert(resp.message);
                } else {
                    // 将token存储到本地存储
                    localStorage.setItem("token", resp.token);

                    // 跳转到主页
                    $(location).attr('href', "/index.jsp");
                }
            }
        })
    }
</script>
</html>