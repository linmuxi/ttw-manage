;(function($){
	//定义命名空间
	_admin = $.extend({},$.admin);
	
	//隐藏或显示用户编辑窗体
	var userFormModalStatus = function(status){
		$("#userModel").modal(status);
	};
	
	//设置用户编辑title
	var userFormModelTitle = function(title){
		$("#userFormTitle").html(title);
	};

	//设置用户编辑URL
	var userFormIframe = function(src){
		$("#userFormIframe").attr("src",src);
	};
	
	//列表
	var table = null;
	
	//初始化表格
	function initTable(){
		table = $('#userList').dataTable({
			"processing": true,
			"serverSide": true,
			"pagingType":"simple_numbers",  
			"search":{
				"regex":true		
			},
			"scrollX":true,
	        "ajax": {
	            "url": webRoot+"/page/admin/user/queryUserList",
	            "type": "POST"
	        },
	        "language": datatable_language,
	        "columns": [
	                    { "data": "username" },
	                    { "data": "account" },
	                    { "data": "lastLoginIp" },
	                    { "data": "lastLoginDate" },
	                    { "data": "orgName" },
	                    { "data": "enabled" },
	                    { "data": "accountNonExpired" },
	                    { "data": "accountNonLocked" },
	                    { "data": "credentialsNonExpired" },
	                    { "data": "commands" }
	                ],
			"columnDefs":[
				        	{
				        		"render":function(data,type,row){
						            return new Date(data).pattern("yyyy/MM/dd");
					        	},
					        	"targets":3
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return (data==1?"是":"否");
					        	},
					        	"targets":[5,6,7,8]
				        	},{
				        		"render":function(data,type,row){
				        			return '<a class="btn btn-xs btn-primary" title="授权" href="javascript:user.formRole(\''+row['userId']+'\',\''+row['account']+'\');"><i class="btn-icon-only icon-check"> </i></a>&nbsp;' +
				        			        '<a class="btn btn-xs btn-primary" title="修改" href="javascript:user.updateUser(\''+row['userId']+'\');"><i class="btn-icon-only icon-edit"> </i></a>&nbsp;' +
				        			        '<a class="btn btn-xs btn-primary" title="删除" href="javascript:user.deleteUser(\''+row['userId']+'\');"><i class="btn-icon-only icon-remove"> </i></a>&nbsp;';
					        	},
					        	"targets":9
				        	}
			        ]
		});
	}
	
	//初始化事件
	function initEvent(){
		$("#id_add_user").click(function(){
			userFormModalStatus("show"); 
			userFormModelTitle("新增用户");
			userFormIframe(webRoot+"/page/admin/user/userForm.jsp");
		});
		$("#userFormIframe").resizeIframe({height:80}); 
	}
	
	//初始化函数
	function init(){
        initTable.call(this);
        initEvent.call(this);
	}
	
	//定义任务对象
	var User = function(ops){
		this.options = $.extend(true, {}, ops);
		init.call(this);
	};
	
	User.prototype = {
		constructor:User,
		//编辑完用户后回调方法：隐藏弹出层、刷新列表
		formUserHandler:function(){
			userFormModalStatus("hide");
			table.fnDraw(); 
		},
		//赋角色
		formRole:function(userId,account){
			userFormModalStatus("show"); 
			userFormModelTitle("赋角色权限");
			userFormIframe(webRoot+"/page/admin/user/getUserRoleInfo?userId="+userId+"&account="+account);
		},
		//修改用户 
		updateUser:function(userId){
			userFormModalStatus("show"); 
			userFormModelTitle("修改用户");
			userFormIframe(webRoot+"/page/admin/user/userForm.jsp?userId="+userId);
		},
		deleteUser:function(userId){
			lhgdialog.confirm('确定要删除此条数据吗？', function(){
				$("body").mask("处理中..");
				SysUserAction.delUser({userId:userId},function(data){
					$("body").unmask();
					if(data){
						lhgdialog.alert("删除成功");
						table.fnDraw();
					}else{
						lhgdialog.alert("删除失败");
					}
				});
			}, function(){
				//lhgdialog.tips('执行取消操作');
			});
		},
		//回调处理-保存权限数据
		handAuth:function(data){
			var _data = data; 
			if(!_data){return;}
			var auths = _data.auths;
			var roles = [];
			for(var i = 0;i<auths.length;i++){
				roles.push({roleId:auths[i].id});
			}
			SysUserAction.addUserRole({userId:_data.other.objId,roles:roles},function(data){
				if(data && data.result){
					userFormModalStatus("hide"); 
					lhgdialog.alert("保存成功");
				}else{
					lhgdialog.alert("保存失败");
				}
			});
		}
	};
	
	_admin.User = User;
	$.admin = _admin;
})(jQuery); 

var user = new $.admin.User({});

function getTargetObject(){
	return user;
}


