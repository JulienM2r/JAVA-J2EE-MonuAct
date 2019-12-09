document.addEventListener("DOMContentLoaded",function() {

	$.get( "https://api.ipify.org?format=json", function( data ) {
			  console.log(data);
			  $("#ip").val(data.ip) ;
	    });
		
	function showLocationOnMap (location) {
		  var map;
	      
	      map = new google.maps.Map(document.getElementById('map'), {
	          center: {lat: Number(location.latitude), lng: Number(location.longitude)},
	          zoom: 12
	      });
	      
	      var marker = new google.maps.Marker({
	          position: {lat: Number(location.latitude), lng: Number(location.longitude)},
	          map: map,
	          title: "Public IP:"+location.ipAddress+" @ "+location.city
	      });
	      
	}
		
	$.load(function( event ) {
		  event.preventDefault();
		  $.ajax({
			  url: "index",
			  type: "POST",
			  contentType: "application/x-www-form-urlencoded; charset=UTF-8", // send as JSON
			  data: $.param( {ipAddress : $("#ip").val()} ),
			  complete: function(data) {
			      console.log ("Request complete");
			     
			  },
			  success: function(data) {
				  $("#status").html(JSON.stringify(data));
				  
				  if (data.ipAddress !=null) {
					  console.log ("Success:"+data.ipAddress);    
				    	showLocationOnMap(data);
				  		  	
				  }
			  },
			  error: function(err) {
			      console.log(err);
			      $("#status").html("Error:"+JSON.stringify(data));
			  },
		  });
			  
		});
		
	});	



	function connect(){
		var login = document.querySelector('#login').value;
		var mdp = document.querySelector('#mdp').value;
		
		var request = new XMLHttpRequest();
		request.addEventListener('load', function(e) {
			// var ret = JSON.parse(this.responseText);
			// console.log(ret);
		
		}),

		request.open("GET", 'connexion.php?login=' + login + '&mdp=' + mdp);			
		request.send();
	}


	var login_form = document.querySelector('#login_form');
	if (login_form){
		login_form.addEventListener('submit',function(e) {
			connect();
			e.preventDefault();
		});
	}


