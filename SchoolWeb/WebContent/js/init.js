(function($){
  $(function(){

    $('.sidenav').sidenav(); 
    $('.dropdown-trigger').dropdown();
    
    //Init Slider

        $('.slider').slider({
        	fullWidth: true,
        	indicators: false,
        	height: 500
        });
  }); // end of document ready
})(jQuery); // end of jQuery name space
