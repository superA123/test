//共通js
/*
 * 分页查询共通
 * Clark
 * 2014-11-3
 */
function page(n,s){
	if(n) $("#pageNo").val(n);
	if(s) $("#pageSize").val(s);
	$("#searchForm").submit();
	return false;
}

/*
 * 日期控件设定默认值为当前日期
 * Clark
 * 2014-11-3
 */
function setToday(nameList,isSearch){
	var isSet = true;
	//判断日期控件全部为空
	$(nameList).each(function() {
		if ($(this).val() != null && $(this).val() != ''){
			isSet = false;
		}
	});
	// 点击查询时间控件不默认值
	if(isSearch === 'true' ) {
		isSet = false;
	}
	if (isSet) {
		$(nameList).each(function() {
			var today = new Date();
			var y = today.getFullYear();
			var m = today.getMonth() + 1;
			var d = today.getDate();
			
			m = m < 10 ? '0'+m : m;
			d = d < 10 ? '0'+d : d;
		
			var now = y+'-'+m+'-'+d;
			$(this).val(now);
		});
	}
}