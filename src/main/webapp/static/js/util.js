// 获得年月日
function getMyDate(str) {
	var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
			.getMonth()
			+ 1, oDay = oDate.getDate(), oTime = oYear + '-' + getzf(oMonth)
			+ '-' + getzf(oDay);// 最后拼接时间
			
	return getzf(oTime);
};
// 获得时分秒
function getMyhours(str) {
	var oDate = new Date(str), oHour = oDate.getHours(), oMin = oDate
			.getMinutes(), oSen = oDate.getSeconds(), oTime = getzf(oHour)
			+ ':' + getzf(oMin) + ':' + getzf(oSen);// 最后拼接时间
	return oTime;
}

// 补0操作
function getzf(num) {
	if (parseInt(num) < 10) {
		num = '0' + num;
	}
	return num;
}

//时间字符串转时间
function stringToDate(strings){
	return	new Date(Date.parse(str1.replace(/-/g, "/"))).format('yyyy-MM-dd');
}