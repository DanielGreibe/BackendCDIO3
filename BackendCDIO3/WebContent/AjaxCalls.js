$(document).ready(function(){

	//OnClickFunction to ReadIngredient(id)
	$('#readButton').click(function()
			{
			var readUserId = $('#readUserId').val();
			loadIngredient(readUserId);
			return false;
			});
	
	
	$('#deleteButton').click(function()
			{
		
			var deleteUserId = $('#deleteUserId').val();
			alert(deleteUserId);
			deleteIngredient(deleteUserId);
			return false;
			});
	
	$('#readAllButton').click(function()
			{
			readUsers();
			return false;
			});
	
	$('#createIngredientButton').click(function()
			{
			createIngredient();
			return false;
			});
	
})
function createIngredient() {
	event.preventDefault();

	//Serialize userform
	var form = $('#userDTOForm');
	var formSerialized = form.serializeJSON();
	var formStringified = JSON.stringify(formSerialized);
	
	//Ajax Call
		$.ajax({
			data: formStringified,
			contentType : 'application/json',
			dataType: 'application/json',
			url : 'rest/userDTO/create',	
			type : 'POST',
		success : function(data){
			alert("Brugeren blev oprettet");
			} 
		});

    //Hint: Remember to reload ingredientlist
}

function readUsers() {
	//Step 1. Load list of ingredients from service
	$.ajax({
	    url: 'rest/userDTO/',
	    type: 'GET',
	    success: function(data) {
	    	var stringData = JSON.stringify(data);
	    	console.log(stringData);
			console.log(data);
			console.log(typeof data);
			console.log(typeof stringData);
			var html;
		
			$.each( data , function( key , value ) {
				alert
			html += generateHTML(value);
			});
			
			var tableHtml = $('#userTable').html();
			alert(tableHtml);
			$('#placeholder').html(tableHtml + html);
	    }
	});
	
	//TODO load list of ingredients from service and append rows to user table
	//Hints: $.each(data, function(i, element){ } iterates over a JSON-collection (data). 
	// $('').append('html'), appends html to an html element.
	
}

function loadIngredient(readUserId) {
	$.ajax({
		url: 'rest/userDTO/' + readUserId,
		type: 'GET',
		success: function (data) {
			var dataString = JSON.stringify(data);
			var ingredient = JSON.parse(dataString);
			$('#placeholder').html(generateIngredientHTML(ingredient));
	        						
	    },
	    error: function (jqXHR, exception, data) {
	    	console.log(jqXHR);
	    	console.log(exception);

	    },
	});
}

function deleteIngredient(deleteUserId) {
	event.preventDefault();
	$.ajax({
	    url: 'rest/userDTO/' + deleteUserId,
	    type: 'DELETE',
	    success: function() {
	        alert("The user with id " + deleteUserId + " ceased to exist");
	    }
	});
	
	//Hint: Remember to reload ingredientlist
}

function generateIngredientHTML(userDTO) {
	return 	'<tr><td>' + "ID" + '</td>' + '<td>' + userDTO.userId + '</td> </tr>' +
			'<tr><td>' + "Username" + '</td>' + '<td>' + userDTO.userName + '</td> </tr>' +
			'<tr><td>' + "Initials" + '</td>' + '<td>' + userDTO.ini + '</td> </tr>' +
			'<tr><td>' + "CPR Number" + '</td>' + '<td>' + userDTO.cpr + '</td> </tr>' +
			'<tr><td>' + "Password" + '</td>' + '<td>' + userDTO.password + '</td> </tr>' 

}

function generateHTML(json){
	var html = '<tr>'
		$.each(json, function(i, elt) {
			html+= '<td>' + elt + '</td>';
		});
	return html += '</tr>';
}