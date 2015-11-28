var myWindow;
function openWin(winName) {
    //if (winName == "LogIn") {
    //    myWindow = window.open("/nwmining/LogIn.html", "", "width=400, height=200");
    //}
    switch (winName) {
        case "LogIn":
            myWindow = window.open("/nwmining/LogIn.html", "", "width=400, height=200");
            break;
        case "SignUp":
            myWindow = window.open("/nwmining/SignUp.html", "", "width=400, height=200");
    }
    myWindow.focus();
}
function blurWin() {
    myWindow.blur();
}
function focusWin() {
    myWindow.focus();
}
function closeWin(winName) {
    myWindow.close();
}
//
function getHttpCloudHash(win) {
    //alert(typeof(win));
    if (window.XMLHttpRequest)
      {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
      }
    else
      {// code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
    //xmlhttp.open(method,url,async)///////
    //xmlhttp.open("GET","/nwmining/asp/getHttp.asp",false);    //test-OK!!
    xmlhttp.open("GET","/nwmining/php/getHttp.php",false);   //php- fail
    //xmlhttp.open("GET","/nwmining/python/getHttp.py",false);  //python--testing....consider server side
    //xmlhttp.open("GET","/nwmining/dotNet/getHttp.cshtml",false);  //.net webpage razor...
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.readyState == 200) {
            //document.getElementById("demo1").innerHTML = xmlhttp.responseText;
            alert("in if: "+ xmlhttp.responseText);
        }
    }
    //alert(XMLHttpRequest.readyState + " last mon:" + xmlhttp.responseText);
    var str = xmlhttp.responseText;
    var findString = "Total Hash Rate:";
    var getStringLen = 0;
    var idx = str.indexOf(findString);
    var fstr = str.substr(idx + findString.length, getStringLen+9);
    //alert("substr" + fstr);
    //win.document.getElementById("demo1").innerHTML = fstr;
    return fstr;
    /*
    var x=xmlDoc.getElementsByTagName("a");
    for (i=0;i<x.length;i++)
      { 
      document.write(x[i].childNodes[0].nodeValue);
      //document.write(x[i].getElementsByTagName("ARTIST")[0].childNodes[0].nodeValue);
      }
      alert(x);
      */
      //return x;
}