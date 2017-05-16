//选项卡 1.切换条id 2.切换条标签类型 3.切换事件,4.事件后标签
var tabSlide = function(target, tag, etype, tagsClass) {
	var list = $(target + ">" + tag);
	list.eq(0).append("<i></i>");
	for (var i = 0; i < list.length; i++) {
		list[i][etype] = function() {
			for (var i = 0; i < list.length; i++) {
				if (list[i] == this) {
					list.eq(i).addClass(tagsClass);
					$(target + "_" + i).show();
					list.eq(0).find("i").eq(0).css({"webkitTransform":"translate3d("+ i*100+"%, 0, 0)"});
				} else {
					list.eq(i).removeClass(tagsClass);
					$(target + "_" + i).hide();
				}
			}
			test();
		}
	}
	
}