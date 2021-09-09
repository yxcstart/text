$(function(){
	$("#publishBtn").click(publish);
});

function publish() {
	$("#publishModal").modal("hide");

	// 获取参数
	var studentName=$("#studentName").val();
	var studentId=$("#studentId").val();
	var chinese=$("#chinese").val();
	var math=$("#math").val();
	var english=$("#english").val();
	// 发送异步请求
	$.post(
		CONTEXT_PATH+"/add",
		{"studentName":studentName,"studentId":studentId,"chinese":chinese,"math":math,
			"english":english},
		function (data) {
			data=$.parseJSON(data);
			// 在提示框中显示返回的消息
			$("#hintBody").text(data.msg);
			// 显示提示框
			$("#hintModal").modal("show");
			// 2秒后，自动隐藏提示框
			setTimeout(function(){
				$("#hintModal").modal("hide");
				// 刷新页面
				if (data.code==0){
					window.location.reload();
				}
			}, 2000);
		}
	);
}