
/*
当整个页面加载完毕之后，会产生load事件，对应的事件处理函数会执行。
页面加载完成，则dom树肯定已经创建，则可以对dom树做操作，比如访问相应地dom节点，对该节点绑定相应
的事件处理函数。
 */
window.onload = function(){

    var obj = document.getElementById('d1');
    //绑定单击事件处理函数
    obj.onclick = function(){
        //this表示绑定了该函数的obj对象
        this.innerHTML = 'hello java';
    };

};


