/**
 * The *.js is about Page
 * 
 * Parameters :
 *	 pageTotal : Quantity of List
 *	 pageNum : Current Page Number
 *	 pageSize : Quantity of Every Page
 *	 totalPages : Quantity of Pages
 */
function com_paginat(pageTotal,pageNum,pageSize,totalPages){
	
	$(".pagination").children("li").remove();
	var active = "";
	if(pageNum==4){
		$(".pagination").append("<li><a>1</a></li>");
	}
	if(pageNum>4){
		$(".pagination").append("<li><a>1</a></li>");
		$(".pagination").append("<li><a>...</a></li>");
	}
	for(var i = 1;i<totalPages+1;i++){
		if(i>(pageNum-3)&&i<(pageNum+3)){
			var visible = "";
			if(i==pageNum-2||i==pageNum+2){visible="class=' hidden-sm hidden-xs'";}
			if(i==pageNum){
				active = "class='active'";
			}
			$(".pagination").append("<li "+active+" "+visible+" onclick='com_pageClick("+i+")'><a>"+i+"</a></li>");
			active = "";
			visible = "";
		}
	}
	if(pageNum==totalPages-3){
		$(".pagination").append("<li><a>"+totalPages+"</a></li>");
	}
	if(pageNum<totalPages-3){
		$(".pagination").append("<li><a>...</a></li>");
		$(".pagination").append("<li><a>"+totalPages+"</a></li>");
	}
}

function com_pageClick(pageNum){
	$("#com_page_pageNum").attr("value",pageNum);
	$("#com_page_pageSize").attr("value",$("#input-limit").val());
	$("#com_page_btn").click();
}