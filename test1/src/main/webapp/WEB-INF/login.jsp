<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/menu.jsp"></jsp:include>
	<title>로그인 페이지</title>
</head>
<style>

</style>
<body>
	<div id="app" >
	<div>	
		아이디 : <input type="text" placeholder="아이디를 입력하세요" v-model="userId">
	</div>
	<div>
		비밀번호 : <input type="password" placeholder="비밀번호를 입력하세요" v-model="pwd">
	</div>	
		<button @click="fnLogin">로그인</button>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				userId: "",
				pwd: ""
				
            };
        },
        methods: {
			fnLogin(){
				var self = this;
				var nparmap = {
					userId : self.userId,
					pwd : self.pwd		
				};
				$.ajax({
					url:"login.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						if(data.result == "success"){
							location.href = "board-list.do"
							$pageChange("board-list.do", {})
						} else {
							alert(data.message)
						}
					}
				});
			}

		},
        mounted() {
        },
    });
    app.mount('#app');
</script>