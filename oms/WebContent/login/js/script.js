$(function(){
	
	// Checking for CSS 3D transformation support
	$.support.css3d = supportsCSS3D();
	//alert("hi1");
	var formContainer = $('#formContainer');
	//alert("hi4");
	// Listening for clicks on the ribbon links
	$('.flipLink').click(function(e){
		//alert("hi2");	
		// Flipping the forms
		formContainer.toggleClass('flipped');
		//alert("hi3");
		// If there is no CSS3 3D support, simply
		// hide the login form (exposing the recover one)
		if(!$.support.css3d){
			//alert("hi5");
			$('#login').toggle();
			//alert("hi6");
		}
		e.preventDefault();
	});
	
	///formContainer.find('form').submit(function(e){
		// Preventing form submissions. If you implement
		// a backend, you might want to remove this code
	//	e.preventDefault();
		//alert("hi7");
	///});
	
	
	// A helper function that checks for the 
	// support of the 3D CSS3 transformations.
	function supportsCSS3D() {
		var props = [
			'perspectiveProperty', 'WebkitPerspective', 'MozPerspective'
		], testDom = document.createElement('a');
		//alert("hi8");
		for(var i=0; i<props.length; i++){
			if(props[i] in testDom.style){
				return true;
			}
		}
		
		return false;
	}
});
