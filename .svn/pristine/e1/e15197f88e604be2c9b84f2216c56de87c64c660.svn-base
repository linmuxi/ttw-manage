var loadFileSotre = function(businessHidden, container){

	FileStoreAction.queryFileStoreListByBusinessId(
		{
			businessId:businessIdVal
		},
		function(data){
			if(data){
				var pathname = window.location.pathname;
				var projectName= pathname.substring(0,pathname.substr(1).indexOf('/')+1);
			
				var fileArr = data.rows;
				
				var html = "";
				for(var i=0; i<fileArr.length; i++){
					var file = fileArr[i];
					html += '<div id="' + file.id + '" class="file-item thumbnail">' +
			                    '<img src="'+pathname+file.filePath+'">' +
			                    '<div class="info">' + file.fileName + '</div>' +
			                '</div>';
				}
				
	        	$('#'+container).html(html);
			}else{
				lhgdialog.alert("创建失败");
			}
		}
	);
};
