/**
 * 
 */
var judgeArray = [[0,31,28,31,30,31,30,31,31,30,31,30,31],[[0,31,29,31,30,31,30,31,31,30,31,30,31]]];
//xxxx-xx-xx
function check(){
	var t = document.getElementById("time").value;
	var t="2014-02-30"
	var index = t.indexOf("-");
	var year = t.substr(0,index);
	var leave = t.substring(index + 1);
	var month = leave.substr(0,2);
	var day = t.substr(t.length - 2,2);
	
	var nYear = parseInt(year);
	var nMonth = parseInt(month);
	var nDay = parseInt(day);
	var isLeap = 0;
	if(((nYear%4==0 && nYear%100!==0) || (nYear%400==0))){
		isLeap = 1;
	}
	console.log(judgeArray[isLeap][nMonth]);
	console.log(judgeArray[isLeap][nMonth]>=nDay);
	return judgeArray[isLeap][nMonth]>=nDay;
}