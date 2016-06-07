(function($){
	//定义命名空间
	_admin = $.extend({},$.admin);
	
	//列表对象
	var table = null;
	
	var roleOperationTitle = function(title){
		$("#roleOperationTitle").html(title);
	};
	
	var roleOperationModalStatus = function(status){
		$("#roleOperation").modal(status);
	};
	
	var roleOperationIframe = function(src){
		$("#roleOperationIframe").attr("src",src);
	};
	
	//初始化事件
	function initEvent(){
		//添加角色
		$("#id_add_role").click(role.addRole);
		//iframe自适应高度
		$("#roleOperationIframe").resizeIframe({height:80});
	}
	
	//初始化表格
	function initTable(){
		table = $('#roleList').dataTable({
			"processing": true,
			"serverSide": true,
			"pagingType":"simple_numbers",  
			"search":{
				"regex":true		
			},
	        "ajax": {
	            "url": webRoot+"/page/admin/role/index",
	            "type": "POST"
	        },
	        "language": datatable_language,
	        "columns": [
	                    { "data": "roleId" },
	                    { "data": "roleName" },
	                    { "data": "roleDesc" },
	                    { "data": "enabled" },
	                    { "data": "commands" }
	                ],
			"columnDefs":[

				        	{
			              		"visible":false,
					        	"targets":0
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return '<a class="btn btn-xs btn-primary" title="赋模块" href="javascript:role.fromModule(\''+row['roleId']+'\',\''+row['roleName']+'\');"><i class="btn-icon-only icon-check"> </i></a>&nbsp;'+
				        			'<a class="btn btn-xs btn-primary" title="赋权限" href="javascript:role.fromAuth(\''+row['roleId']+'\',\''+row['roleName']+'\');"><i class="btn-icon-only icon-check"> </i></a>&nbsp;'+
				        			'<a class="btn btn-xs btn-primary" title="删除" href="javascript:role.deleteRole(\''+row['roleId']+'\');"><i class="btn-icon-only icon-remove"> </i></a>&nbsp;'+
				        			'<a class="btn btn-xs btn-primary" title="修改" href="javascript:role.updateRole(\''+row['roleId']+'\');"><i class="btn-icon-only icon-edit"> </i></a>';
					        	},
					        	"orderable":false,
					        	"targets":4
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return (data?"是":"否");
					        	},
					        	"targets":3
				        	}
			        ]
		});
	}
	
	var Role = function(ops){
		this.options = $.extend(true, {}, ops);
		init.call(this);
	};

	Role.prototype = {
			constructor:Role,
			//编辑角色回调函数
			formRoleHandler : function(){
				roleOperationModalStatus("hide");
				table.fnDraw(); 
			},
			//添加角色
			addRole : function(){
				roleOperationTitle("创建新角色");
				roleOperationModalStatus('show');
				roleOperationIframe(webRoot+"/page/admin/role/roleForm.jsp");
			},
			//修改角色
			updateRole : function(roleId){
				roleOperationTitle("修改角色");
				roleOperationModalStatus('show');
				roleOperationIframe(webRoot+"/page/admin/role/roleForm.jsp?roleId="+roleId);
			},
			//给角色赋予模块访问权限
			fromModule : function(roleId,roleName){
				roleOperationModalStatus("show"); 
				roleOperationTitle("给角色赋予模块权限");
				roleOperationIframe(webRoot+"/page/admin/role/getRoleModuleInfo?roleId="+roleId+"&roleName="+encodeURIComponent(encodeURIComponent(roleName)));
			},			
			//给角色赋予权限
			fromAuth : function(roleId,roleName){
				roleOperationModalStatus("show"); 
				roleOperationTitle("给角色赋予权限操作");
				roleOperationIframe(webRoot+"/page/admin/role/getRoleAuthInfo?roleId="+roleId+"&roleName="+encodeURIComponent(encodeURIComponent(roleName)));
			},
			//删除角色
			deleteRole : function(roleId){
				lhgdialog.confirm('确定要删除此条数据吗？', function(){
					$("body").mask("处理中..");
					SysRoleAction.delRole({roleId:roleId},function(data){
						$("body").unmask();
						if(data){
							lhgdialog.alert("删除成功");
							table.fnDraw();
						}else{
							lhgdialog.alert("删除失败");
						}
					});
				});
			},
			//处理权限保存操作
			handAuth : function(data){
				var _data = data;
				if(!_data){return;}
				var auths = _data.auths;
				if(_data.other.type == 3){
					//赋模块
					var modules = [];
					for(var i = 0;i<auths.length;i++){
						modules.push({moduleId:auths[i].id});
					}
					SysRoleAction.addRoleModule({roleId:_data.other.objId,modules:modules},function(data){
						if(data && data.result){
							lhgdialog.alert("保存成功");
						}else{
							lhgdialog.alert("保存失败");
						}
					});
				}else if(_data.other.type == 2){
					//赋权限
					var sysAuths = [];
					for(var i = 0;i<auths.length;i++){
						sysAuths.push({authorityId:auths[i].id});
					}
					SysRoleAction.addRoleAuth({roleId:_data.other.objId,auths:sysAuths},function(data){
						if(data && data.result){
							lhgdialog.alert("保存成功");
						}else{
							lhgdialog.alert("保存失败");
						}
					});
				}
			}
	};

	function init(){
        initTable.call(this);
	}
	
	$(function(){
        initEvent.call(this);
	});
	
	_admin.Role = Role;
	$.admin = _admin;
})(jQuery);

var role = new $.admin.Role({});

function getTargetObject(){
	return role;
}
