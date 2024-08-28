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
	<div id="app" v-for="item in user">
			<div>아이디:{{user.userId}}</div>
			<div>비밀번호:{{user.pwd}}</div>
			<div>이름:{{user.userName}}</div>
			<div>이메일:{{user.eMil}}</div>
			<div>휴대폰번호:{{user.phone}}</div>
			<div>성별:{{user.gender}}</div>
			<div><button @click="fnRemove(userId)">삭제</button><div>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				userId : '${userId}',
				user : {}
			
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
						self.user = data.user;
					}
				});
			},
			fnRemove(userId) {
				var self = this;
				var nparmap = {userId : userId};
				if(!confirm("삭제하겠습니까?")){
					return;
				};
				$.ajax({
					url:"user-remove.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						$.pageChange("user-list.do", {});
					}
				});
			}

        },
        mounted() {
			var self = this;
			self.fnGetList();
        }
    });
    app.mount('#app');
</script>