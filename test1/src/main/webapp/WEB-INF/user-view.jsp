<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/menu.jsp"></jsp:include>
	<title>첫번째 페이지</title>
</head>
<style>
	table {
		margin : 20px;
	}
	table, tr, th, td {
		border : 1px solid black;
		padding : 5px 5px;
		border-collapse: collapse;
	}
</style>
<body>
	<div id="app">
			<div>아이디:{{info.userId}}</div>
			<div>비밀번호:{{info.pwd}}</div>
			<div>이름:{{info.userName}}</div>
			<div>이메일:{{info.phone}}</div>
			<div>휴대폰번호:{{info.eMail}}</div>
			<div>성별:{{info.gender}}</div>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				userId : '${userId}',
				info : {}
            };
        },
        methods: {
			fnGetList(){
				var self = this;
				var nparmap = {userId : self.userId};
				$.ajax({
					url:"user-view.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						self.info = data.info;
					}
				});
			},

        },
        mounted() {
			var self = this;
			self.fnGetList();
        }
    });
    app.mount('#app');
</script>