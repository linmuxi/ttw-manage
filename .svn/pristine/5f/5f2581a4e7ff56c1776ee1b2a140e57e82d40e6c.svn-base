(function($) {
	function login() {
		var account = $("#account").val();
		var password = $("#password").val();
		$.ajax({
			type : "post",
			url : webRoot + "/page/mylogin",
			success : function(data) {
				if (data) {
					var obj = $.parseJSON(data);
					if (obj.flag) {
						window.location = webRoot + "/page/admin/index";
					} else {
				    	var msg = "";
						switch(obj.data.code){
						case "1":
							msg = "用户不存在";
							break;
						case "2":
							msg = "密码错误";
							break;
						case "3":
							msg = "账户被锁";
							break;
						case "4":
							msg = "用户失效";
							break;
						case "5":
							msg = "用户过期";
							break;
						case "6":
							msg = "密码过期";
							break;
						}
						lhgdialog.alert(msg);
					}
				}
			},
			data : {
				account : account,
				password : password
			},
			error : function(data) {
				lhgdialog.alert("登录异常，请联系管理员");
			}
		});
	}
	$("#btn_login").click(login);
	
	$("body").keydown(keyDownLogin);
})(jQuery);

function keyDownLogin(event) {
	if (event.keyCode == 13) {
		event.returnValue = false;
		event.cancel = true;
		loginForm.btn_login.click();
	}
}