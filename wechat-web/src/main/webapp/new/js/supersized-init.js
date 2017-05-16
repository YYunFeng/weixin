jQuery(function($){

    $.supersized({

        slide_interval     : 4000,
        transition         : 1,
        transition_speed   : 1000,
        performance        : 1,

        // 澶у皬鍜屼綅缃�
        min_width          : 0,
        min_height         : 0,
        vertical_center    : 1,
        horizontal_center  : 1,
        fit_always         : 0,
        fit_portrait       : 1,
        fit_landscape      : 0,

        // 缁勪欢
        slide_links        : 'blank',
        slides             : [
            {image : '../new/img/1.jpg'},
            {image : '../new/img/2.jpg'},
            {image : '../new/img/3.jpg'}
        ]

    });

});
