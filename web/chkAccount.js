/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function chkAccount(){
    //建立XMLHttpReqsuest物件
    createXMLHttpRequest();
    var myId = document.getElementById("emailText").value;
    var url = "/funtogether/register/ValiAccount.jsp?myId=" +myId;
    
    //將輸入的帳號傳送到後端作驗證
    xmlHttp.onreadystatechagne = callback;
    xmlHttp.open("POST",url,true);
    xmlHttp.send(null);
}
//資料回傳後，處理後續動作
function callback(){
    if ((xmlHttp.readyState == 4) && (xmlHttp.status == 200)){
        //接收後端程式傳回的網頁，解析成DOM格式
        var xmldoc = xmlHttp.responseXML;
        //取出Tag 為<meaage>該元素的值
        var mes = xmldoc.getElementsByTagName("message")[0].firstChild.data;
        var val = xmldoc.getElementsByTagName("passed")[0].firstChild.data;
        
        setMessage(mes,val);
    }
    
}
