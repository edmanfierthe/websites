(function($){
    "use strict";
    var NAY ={};
    NAY.MenuTogglerClose = function(){
        $(".toggler-menu").on('click', function(){
            $('.header-left').stop().toggleClass('menu-open');
        });
        $('.header-left a').on('click', function(){
            var toggle = $('.toggler-menu');
        });
    }
    $(document).on("ready", function(){
        NAY.MenuTogglerClose()
    });
})(jQuery)

// my hobbies//

$(function() {
    var $grid = $('#tp-grid'),
        $name = $('#name'),
        $close = $('#close'),
        $loader = $('').insertBefore($grid),
        stapel = $grid.stapel({
            randomAngle : true,
            delay : 50,
            gutter : 70,
            pileAngles : 5,
            onLoad : function(){
                $loader.remove();
            },
            onBeforeOpen : function( pileName ){
                $name.html( pileName );
            },
            onAfterOpen : function ( pileName){
                $close.show();
            }
        });
    
    $close.on( 'click', function() {
        $close.hide();
        $name.empty();
        stapel.closePile();
    } );
     
    
    var smoothScroll = new scrollToSmooth('a', {
        easing: 'easeInOutBack',
        duration: 1490,
        durationRelative: true,
        onScrollStart: (data) => {console.log(data);},
        onScrollUpdate: (data) => {console.log(data);},
        onScrollEnd: (data) => {console.log(data);},
        
       
    });
    smoothScroll.init();
    
    
    
    //-------blog prettyPhoto---------//
    

  if($("a[data-rel^='prettyPhoto']").length > 0){
      $("a[data-rel^='prettyPhoto']").prettyPhoto({
          social_tools: false
      });
  }
    
    
});
