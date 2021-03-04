$(function(){
	$("#addUserBtn").click(function(){
		var userRole = $("#userRole").text();
		if(userRole == "Guest") window.location.replace("/login");
	});

	$(".table a#EditBtn").click(function(event){
		var userRole = $("#userRole").text();
		if(userRole == "Guest") window.location.replace("/login");
		
		event.preventDefault();

		var href = $(this).attr("href"); 
		
		$.get(href, function(student){
			$("#idEdit").val(student.id);
			$("#nameEdit").val(student.name);
			$("#departmentEdit").val(student.department);
			$("#updatedByEdit").val(student.updatedBy);
		});
		
		$("#editModal").modal();
	});
	
	
	$(".table a#deleteBtn").click(function(event){
		var userRole = $("#userRole").text();
		if(userRole == "Guest") window.location.replace("/login");
	
		event.preventDefault();
		
		var href = $(this).attr("href");
		
		$("#deleteModal a#modalDeleteBtn").attr("href", href);
		console.log(href);
		$("#deleteModal").modal();
	});
});