function showContent(link){
	var promise = $.ajax({url: link});
	promise.success(function(data){
		$("#mainContent").html(data);
		//alert("Data is "+data);
	});
	
		
	};

	
function logout(){
	var promise = $.ajax({url: "logout"});
	promise.success(function(data){
		alert("Logout Data is "+data);
		if(data==="success"){
			location.href="index.jsp";
			//$("#logoutModal").show();
			/*$('#logoutModal').modal({
		        show: 'true'
		    });*/ 
			/*setTimeout(function(){
				$("#logoutModal").hide();
				location.href="index.jsp";
			},2000);
*/		}
		else{
			location.href="index.jsp";
		}
		
		//alert("Data is "+data);
	});
	promise.error(function(err){
		alert("Error ",err);
	})
}	