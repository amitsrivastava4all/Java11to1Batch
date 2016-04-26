function showContent(link){
	var promise = $.ajax({url: link});
	promise.success(function(data){
		$("#mainContent").html(data);
		//alert("Data is "+data);
	})
	
		
	};
