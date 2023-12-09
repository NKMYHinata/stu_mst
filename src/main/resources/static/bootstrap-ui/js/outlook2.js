$(function(){
    LeftMenu();
    LiftMenuChild();
    clickName();
});


//初始化左侧
function LeftMenu() {
    let munList=""
    munList+='<ul class="nav" style="width: 160px;">'
    $(_menus.menus).each(function (i,n) {
        let munList1=""
        munList1+='<li class="nav-item">'+
                    '<a id="link'+n.menuid+'" class="nav-link" data-toggle="collapse" href="#ui-basic'+n.menuid+'" aria-expanded="false" aria-controls="ui-basic'+n.menuid+'">\n' +
            '                   <i class="mdi mdi-circle-outline menu-icon"></i>\n' +
            '                   <span class="'+n.icon+'" aria-hidden="true"></span>\n' +
            '                   <span class="menu-title">'+n.menuname+'</span>\n' +
            '                   <span id="icon'+n.menuid+'" class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>\n' +
            '                   <i class="menu-arrow"></i>\n' +
            '         </a>'
        munList1+='<div class="collapse" id="ui-basic'+n.menuid+'">\n' +
            '                   <ul >'

        $(n.menus).each(function (j,m) {
            munList1+='<li class="nav-item" id="'+m.menuid+'"> <a class="nav-link" href="">'+m.menuname+'</a></li>'
        })

        munList1+='</ul>\n' +
            '               </div>'
        munList1+='</li>'
        munList+=munList1
    })
    munList+='</ul>'
    $(".sidebar-offcanvas").html(munList)
}
function clickName() {
    let lastClickTime1 = 0;
    document.getElementById("link1").addEventListener("click",function (){
        let currentTime = new Date().getTime();
        if(currentTime-lastClickTime1>=500){
            lastClickTime1 = currentTime;
            if(document.getElementById("icon1").classList[1]==="glyphicon-menu-right"){
                document.getElementById("icon1").classList.remove("glyphicon-menu-right")
                document.getElementById("icon1").classList.add("glyphicon-menu-down")
            }else{
                document.getElementById("icon1").classList.remove("glyphicon-menu-down")
                document.getElementById("icon1").classList.add("glyphicon-menu-right")

            }
        }
    })

    let lastClickTime2 = 0;
    document.getElementById("link2").addEventListener("click",function (){
        let currentTime = new Date().getTime();
        if(currentTime-lastClickTime2>=500){
            lastClickTime1 = currentTime;
            if(document.getElementById("icon2").classList[1]==="glyphicon-menu-right"){
                document.getElementById("icon2").classList.remove("glyphicon-menu-right")
                document.getElementById("icon2").classList.add("glyphicon-menu-down")
            }else{
                document.getElementById("icon2").classList.remove("glyphicon-menu-down")
                document.getElementById("icon2").classList.add("glyphicon-menu-right")

            }
        }
    })

    let lastClickTime3 = 0;
    document.getElementById("link3").addEventListener("click",function (){
        let currentTime = new Date().getTime();
        if(currentTime-lastClickTime3>=500){
            lastClickTime1 = currentTime;
            if(document.getElementById("icon3").classList[1]==="glyphicon-menu-right"){
                document.getElementById("icon3").classList.remove("glyphicon-menu-right")
                document.getElementById("icon3").classList.add("glyphicon-menu-down")
            }else{
                document.getElementById("icon3").classList.remove("glyphicon-menu-down")
                document.getElementById("icon3").classList.add("glyphicon-menu-right")

            }
        }
    })

    let lastClickTime4 = 0;
    document.getElementById("link4").addEventListener("click",function (){
        let currentTime = new Date().getTime();
        if(currentTime-lastClickTime4>=500){
            lastClickTime1 = currentTime;
            if(document.getElementById("icon4").classList[1]==="glyphicon-menu-right"){
                document.getElementById("icon4").classList.remove("glyphicon-menu-right")
                document.getElementById("icon4").classList.add("glyphicon-menu-down")
            }else{
                document.getElementById("icon4").classList.remove("glyphicon-menu-down")
                document.getElementById("icon4").classList.add("glyphicon-menu-right")

            }
        }
    })

    let lastClickTime5 = 0;
    document.getElementById("link5").addEventListener("click",function (){
        let currentTime = new Date().getTime();
        if(currentTime-lastClickTime5>=500){
            lastClickTime1 = currentTime;
            if(document.getElementById("icon5").classList[1]==="glyphicon-menu-right"){
                document.getElementById("icon5").classList.remove("glyphicon-menu-right")
                document.getElementById("icon5").classList.add("glyphicon-menu-down")
            }else{
                document.getElementById("icon5").classList.remove("glyphicon-menu-down")
                document.getElementById("icon5").classList.add("glyphicon-menu-right")

            }
        }
    })

    let lastClickTime6 = 0;
    document.getElementById("link6").addEventListener("click",function (){
        let currentTime = new Date().getTime();
        if(currentTime-lastClickTime6>=500){
            lastClickTime1 = currentTime;
            if(document.getElementById("icon6").classList[1]==="glyphicon-menu-right"){
                document.getElementById("icon6").classList.remove("glyphicon-menu-right")
                document.getElementById("icon6").classList.add("glyphicon-menu-down")
            }else{
                document.getElementById("icon6").classList.remove("glyphicon-menu-down")
                document.getElementById("icon6").classList.add("glyphicon-menu-right")

            }
        }
    })

    let lastClickTime7 = 0;
    document.getElementById("link7").addEventListener("click",function (){
        let currentTime = new Date().getTime();
        if(currentTime-lastClickTime7>=500){
            lastClickTime1 = currentTime;
            if(document.getElementById("icon7").classList[1]==="glyphicon-menu-right"){
                document.getElementById("icon7").classList.remove("glyphicon-menu-right")
                document.getElementById("icon7").classList.add("glyphicon-menu-down")
            }else{
                document.getElementById("icon7").classList.remove("glyphicon-menu-down")
                document.getElementById("icon7").classList.add("glyphicon-menu-right")

            }
        }
    })

    let lastClickTime8 = 0;
    document.getElementById("link8").addEventListener("click",function (){
        let currentTime = new Date().getTime();
        if(currentTime-lastClickTime8>=500){
            lastClickTime1 = currentTime;
            if(document.getElementById("icon8").classList[1]==="glyphicon-menu-right"){
                document.getElementById("icon8").classList.remove("glyphicon-menu-right")
                document.getElementById("icon8").classList.add("glyphicon-menu-down")
            }else{
                document.getElementById("icon8").classList.remove("glyphicon-menu-down")
                document.getElementById("icon8").classList.add("glyphicon-menu-right")

            }
        }
    })

    let lastClickTime9 = 0;
    document.getElementById("link9").addEventListener("click",function (){
        let currentTime = new Date().getTime();
        if(currentTime-lastClickTime9>=500){
            lastClickTime1 = currentTime;
            if(document.getElementById("icon9").classList[1]==="glyphicon-menu-right"){
                document.getElementById("icon9").classList.remove("glyphicon-menu-right")
                document.getElementById("icon9").classList.add("glyphicon-menu-down")
            }else{
                document.getElementById("icon9").classList.remove("glyphicon-menu-down")
                document.getElementById("icon9").classList.add("glyphicon-menu-right")

            }
        }
    })
}

//点击事件，调取相应的数据库内容
function LiftMenuChild(){
$(_menus.menus).each(function (i,n) {
        $(n.menus).each(function (j,m){
            document.getElementById(m.menuid).onclick=function () {

            }
        })
    })



    // 使用 JavaScript 动态加载内容






}