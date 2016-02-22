$(document).ready(function() {

  $('.menu li:has(ul)').click(function(e) {
    e.preventDefault();
    if ($(this).hasClass('activado')) {
      $(this).removeClass('activado');
      $(this).children('ul').slideUp();
    }else {
      $('.menu li ul').slideUp();
      $('.menu li').removeClass('activado');
      $(this).addClass('activado');
      $(this).children('ul').slideDown();
    }
  });


    //menu responsive
    $('.menu_bar').click(function(){
		// $('nav').toggle();

		if(contador == 1){
			$('nav').animate({
				left: '0'
			});
			contador = 0;
      if (contador==0) {
        $('.desaparecer').click(function(){
          $('nav').animate({
    				left: '-100%'
    			});
            });
      }
		} else {
			contador = 1;
			$('nav').animate({
				left: '-100%'
			});
		}
	});
  //fin menu responsive

  // volver arriba

      $(window).scroll(function(){
          if ($(this).scrollTop() > 100) {
              $('.arriba').fadeIn();
          } else {
              $('.arriba').fadeOut();
          }
      });

      $('.arriba').click(function(){
          $("html, body").animate({ scrollTop: 0 }, 600);
          return false;
      });
  // fin volver arriba


})
