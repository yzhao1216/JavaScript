//等价于 window.onload = function(){};
//页面加载完以后，执行{}中代码
$(function () {
    //等价于
    // var obj = document.getElementById('d1')
    // obj.onclick=function(){ .... 等价于如下代码}
    $('#d1').click(function(){
        //this表示：绑定了该函数的 dom 对象，要变成jQuery--》
        $(this).html('hello kitty');
    });

});

