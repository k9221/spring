<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/menu.jsp"></jsp:include>
	<title>회원가입 페이지</title>
</head>
<style>

</style>
<body>
	<div id="app" >
		아이디 : <input placeholder="아이디" v-model="userId">
		<button @click="fnIdCheck">중복체크</button>
	</div>
	<div>
		비밀번호 : <input type="text" placeholder="제목" v-model="pwd">
	</div>
	<br>
	<div>
		이메일 : <input type="text" placeholder="제목" v-model="pwd">
	</div>
	<div>
		휴대폰번호 : <input type="text" placeholder="제목" v-model="pwd">
	</div>
	<div >
		성별 : 
	</div>		
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				userId : ""
            };
        },
        methods: {
			fnIdCheck(){
				var self = this;
				var nparmap = {userId : self.userId}	
				$.ajax({
					url:"userIdCheck.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						if(data.info == undefined){
							alert("사용 가능한 아이디입니다!");
						} else {
							alert("이미 사용중인 아이디입니다!");
						}
					}
				});
			},
		},ㄴ
        mounted() {
        },
    });
    app.mount('#app');
</script>