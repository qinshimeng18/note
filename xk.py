// ==UserScript==
// @name         xk
// @namespace    http://your.homepage/
// @version      0.1
// @description  enter something useful
// @author       qsm
// @include      http://xk.urp.seu.edu.cn/jw_css/xk/*
// @require 	 http://cdn.staticfile.org/jquery/2.1.0/jquery.min.js
// @grant        none
// ==/UserScript==
data = ["TY18M00026201430013","TY18M00026201430012","TY18M00026201430013","TY18M00026201430013","TY18M00026201430012","TY18M00026201430012"];
var xk = function(data_a){
    $.ajax({ 
        //async:false,
        type:"post", 
        //contentType:"application/json", 
        //跨专业：url: "/jw_css/xk/runSelectclassSelectionAction.action?select_jxbbh="+data_a+"&select_xkkclx=13&select_jhkcdm=00000&select_mkbh=0000&select_dxdbz=0",
         //经济与管理：url: "/jw_css/xk/runSelectclassSelectionAction.action?select_jxbbh="+data_a+"&select_xkkclx=46&select_jhkcdm=00035&select_mkbh=jjygll&select_dxdbz=0",
         //人文：url: "/jw_css/xk/runSelectclassSelectionAction.action?select_jxbbh="+data_a+"&select_xkkclx=45&select_jhkcdm=00034&select_mkbh=rwskl&select_dxdbz=0",
         //自然科学：url: "/jw_css/xk/runSelectclassSelectionAction.action?select_jxbbh="+data_a+"&select_xkkclx=47&select_jhkcdm=00036&select_mkbh=zl&select_dxdbz=0",
        url: "http://xk.urp.seu.edu.cn/jw_css/xk/runSelectclassSelectionAction.action?select_jxbbh=71013530201520000&select_xkkclx=11&select_jhkcdm=71013530",
        //data:"{}", 
        dataType:"json", 
        success:function(data){ 
            if(data.rso.isSuccess == 'false'){
                console.log('课程：');
                console.log(data_a);
                 console.log('第'+count+'奋力尝试，but：T_T');
                console.log(data.rso.errorStr);
                //console.log(data);
                return false;
            }else{
                console.log('好吧，你赢了！！选到了，快来帮我生孩子吧^-^');
                console.error("success");
                window.showModalDialog("success");
                data.pop();
                return true;
            }
        }
 });
}

var x = 0;
var count=0;
var runid = setInterval(function(){
    x++;
    count++;
    //console.log();
    
    if(xk(data[Math.ceil(Math.random()*(data.length-1))])){
        clearInterval(runid);
    }
    if(x>600){
        location.reload();
        x=0;
    }
},1000);


