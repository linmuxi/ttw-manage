$(function(){
	$('#memberList').dataTable({
		"processing": true,
		"serverSide": true,
		"pagingType":"simple_numbers",  
		"search":{
			"regex":true		
		},
        "ajax": {
            "url": webRoot+"/page/business/manage/finance/member/queryMemberList",
            "type": "POST"
        },
        "language": datatable_language,
        "columns": [
                    { "data": "name" },
                    { "data": "account" },
                    { "data": "birth" },
                    { "data": "gender" },
                    { "data": "mobile" },
                    { "data": "email" },
                    { "data": "area" },
                    { "data": "address" },
                    { "data": "createDate" }
                ],
		"columnDefs":[
			        	{
			        		"render":function(data,type,row){
					            return new Date(data).pattern("yyyy/MM/dd");
				        	},
				        	"targets":[2,8]
			        	},
			        	{
			        		"render":function(data,type,row){
			        			return (data==1?"男":"女");
				        	},
				        	"targets":3
			        	}
		        ]
	});
});
