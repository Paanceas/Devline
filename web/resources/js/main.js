$(document).ready(function () {

    $('.menu li:has(ul)').click(function (e) {
        e.preventDefault();
        if ($(this).hasClass('activado')) {
            $(this).removeClass('activado');
            $(this).children('ul').slideUp();
        } else {
            $('.menu li ul').slideUp();
            $('.menu li').removeClass('activado');
            $(this).addClass('activado');
            $(this).children('ul').slideDown();
        }
    });


    //menu responsive
    $('.menu_bar').click(function () {
        // $('nav').toggle();

        if (contador == 1) {
            $('nav').animate({
                left: '0'
            });
            contador = 0;
            if (contador == 0) {
                $('.desaparecer').click(function () {
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

    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.arriba').fadeIn();
        } else {
            $('.arriba').fadeOut();
        }
    });

    $('.arriba').click(function () {
        $("html, body").animate({scrollTop: 0}, 600);
        return false;
    });
    // fin volver arriba
})
function hover() {
    if (screen.width >= 900) {
        $(".id").addClass("acomodarTablas");
        $(".ti").addClass("acomodarTablas");
    } else {
        $(".id").removeClass("acomodarTablas");
        $(".ti").removeClass("acomodarTablas");
    }

    $("button").css("background", "#fff");
    $("button").css("text-shadow", "none !important");
    $("button").addClass("orange");
}
function boton() {
    $(".orange").addClass("btn btn-lg");
    $(".silver").addClass("btn btn-lg");
    
    $(".orange").removeClass("ui-button");
    $(".silver").removeClass("ui-button");
}
function formCont() {
    $("input").addClass("form-control");
    $(".remover_dev").removeClass("form-control");
}
