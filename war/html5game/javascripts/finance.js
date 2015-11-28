var data = {
  code: "005930",
  rev: 1487786,
  earn: 197841,
};
function getRevenue(code,str) {
  //1억 = 100000000
  //1000억 = 1000 * 1억
  //1조= 1000억 * 10; == 1억 * 10000개;
  //매출액 가져오기
  //데이타 from Financial report saved DB or OPEN Api
  var rev=0; var earn=0;

  if (code==data.code) {
    rev = data.rev * 1.06; //6%성장한 목표값
    earn = data.earn * 1.06; //
  }
  var chk;
  if (str=="rev") {
    chk = rev;
  } else if (str="ern") {
    chk=earn;
  }
  //올해 날짜수 + 현재시간
  var rM = chk / 12;  //월간 매출액
  var rD = chk / 12 / 30;  //일간 매출액
  var rH = chk /12/30/24;  //시간당 매출액
  var rMin = chk /12/30/24/60; //분당 매출액
  var rS = rMin / 60; //초당 매출액
  //오늘 - 초일 = ?일
  var d = new Date(); var d1 = new Date(2015,1-1,1);
  var days = Math.round((d - d1)/86400000);
  var t = d.getHours();
  chk = (rD * days) + (rH * t);

  return chk;
}

function drawFinance() {
  var cur = document.getElementById("revenue").innerHTML;
  var cal = new Number(cur);
  var rS = data.rev /12/30/24/60/ 60; //초당 매출액
  var eS = data.earn /12/30/24/60/ 60; //초당 순이익
  cal= cal + rS * 3;
  document.getElementById("revenue").innerHTML = cal.toPrecision(13);

  var cur1 = document.getElementById("earning").innerHTML;
  var cal1 = new Number(cur1);
  cal1 = cal1 + eS * 3;
  document.getElementById("earning").innerHTML = cal1.toPrecision(13);
}