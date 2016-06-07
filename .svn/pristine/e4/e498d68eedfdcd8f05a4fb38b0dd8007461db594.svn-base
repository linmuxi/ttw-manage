;(function($){
	//定义命名空间
	_admin = $.extend({},$.admin);
	
	
	//隐藏或显示权限编辑窗体
	var authorityFormModalStatus = function(status){
		$("#authorityModel").modal(status);
	};
	
	//设置权限编辑title
	var authorityFormModelTitle = function(title){
		$("#authorityTitle").html(title);
	};

	//设置权限编辑URL
	var authorityFormIframe = function(src){
		$("#authorityFormIframe").attr("src",src);
	};
	
	
	//列表
	var table = null;
	//初始化表格
	function initTable(){
		table = $('#authorityList').dataTable({
			"processing": true,
			"serverSide": true,
			"pagingType":"simple_numbers",  
			"search":{
				"regex":true		
			},
	        "ajax": {
	            "url": webRoot+"/page/admin/authority/queryAuthorityList",
	            "type": "POST"
	        },
	        "language": datatable_language,
	        "columns": [
	                    { "data": "authorityMark" },
	                    { "data": "authorityName" },
	                    { "data": "authorityDesc" },
	                    { "data": "message" },
	                    { "data": "enable" },
	                    { "data": "lastUpdateDate" },
	                    { "data": "commands" }
	                ],
			"columnDefs":[
				        	{
				        		"render":function(data,type,row){
						            return new Date(data).pattern("yyyy/MM/dd");
					        	},
					        	"targets":5
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return (data==1?"可用":"不可用");
					        	},
					        	"targets":4
				        	},{
				        		"render":function(data,type,row){
				        			return '<a class="btn btn-xs btn-primary" title="赋资源" href="javascript:authority.formResource(\''+row['authorityId']+'\',\''+row['authorityName']+'\');"><i class="btn-icon-only icon-check"> </i></a>&nbsp;' +
				        			        '<a class="btn btn-xs btn-primary" title="修改" href="javascript:authority.updateAuthority(\''+row['authorityId']+'\');"><i class="btn-icon-only icon-edit"> </i></a>&nbsp;' +
				        			        '<a class="btn btn-xs btn-primary" title="删除" href="javascript:authority.deleteAuthority(\''+row['authorityId']+'\');"><i class="btn-icon-only icon-remove"> </i></a>&nbsp;';
					        	},
					        	"targets":6
				        	}
			        ]
		});
	}
	
	
	//初始化事件
	function initEvent(){
		$("#id_add_authority").click(function(){
			authorityFormModalStatus("show"); 
			authorityFormModelTitle("新增权限");
			authorityFormIframe(webRoot+"/page/admin/authority/authorityForm.jsp");
		});
		$("#resourceAuthIframe").resizeIframe({height:80}); 
	}
	
	
	
	//初始化函数
	function init(){
        initTable.call(this);
        initEvent.call(this);
	}
	
	//定义任务对象
	var Authority = function(ops){
		this.options = $.extend(true, {}, ops);
		init.call(this);
	};
	
	
	
	Authority.prototype = {
			constructor:Authority,
			//编辑完权限后回调方法：隐藏弹出层、刷新列表
			formAuthorityHandler:function(){
				authorityFormModalStatus("hide");
				table.fnDraw(); 
			},
			//赋资源
			formResource:function(authorityId,authorityName){
				authorityFormModalStatus("show"); 
				authorityFormModelTitle("赋资源权限");
				authorityFormIframe(webRoot+"/page/admin/authority/getAuthorityResourceInfo?authorityId="+authorityId+"&authorityName="+encodeURIComponent(encodeURIComponent(authorityName)));
			},
			//修改权限 
			updateAuthority:function(authorityId){
				authorityFormModalStatus("show"); 
				authorityFormModelTitle("修改权限");
				authorityFormIframe(webRoot+"/page/admin/authority/authorityForm.jsp?authorityId="+authorityId);
			},
			//删除权限
			deleteAuthority:function(authorityId){
				$("body").mask("处理中..");
				lhgdialog.confirm('确定要删除此条数据吗？', function(){
					SysAuthorityAction.delAuthority({authorityId:authorityId},function(data){
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
				var authoritys = [];
				for(var i = 0;i<auths.length;i++){
					authoritys.push({resourceId:auths[i].id});
				}
				SysAuthorityAction.addAuthorityAuth({authorityId:_data.other.objId,resources:authoritys},function(data){
					if(data && data.result){
						authorityFormModalStatus("hide"); 
						lhgdialog.alert("保存成功");
					}else{
						lhgdialog.alert("保存失败");
					}
				});
			}
		};
	
	_admin.Authority = Authority;
	$.admin = _admin;
	
})(jQuery); 
var authority = new $.admin.Authority({});

function getTargetObject(){
	return authority;
}
