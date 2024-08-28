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
		<div>
			아이디 : <input type="text" placeholder="아이디" v-model="userId">
			<button @click="fnIdCheck">중복체크</button>
		</div>
		<div>
			비밀번호 : <input type="text" placeholder="비밀번호" v-model="pwd"> 
		</div>
		<div>
			이름 : <input type="text" placeholder="이름" v-model="userName">
		</div>
		<div>
			이메일 : <input type="text" placeholder="이메일" v-model="eMail">
		</div>
		<div>
			휴대폰번호 : <input type="text" placeholder="휴대폰번호" v-model="phone">
		</div>
		<div>
			성별 : <input type="text" placeholder="성별" v-model="gender">
		</div>
		
		<button @click="fnSave">저장</button>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				list : [],
				info : {},
				userId : "",
				pwd : "",
				userName : "",
				eMail : "",
				phone : "",
				gender : ""
            };
        },
        methods: {
            // fnSave 생성 후 board-add.dox 호출해서 저장
			fnSave(){
				var self = this;
				var nparam = {userId : self.userId, pwd : self.pwd, userName : self.userName, eMail : self.eMail, phone : self.phone, gender : self.gender};
				$.ajax({
					url:"user-add.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data){
						alert(data.message);
						if(data.result == "success"){
							location.href = "user-list.do"
						}
					}
				});
			},
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
							alert("사용 가능한 아이디입니다.!");
						} else {
							alert("사용중인 아이디입니다!");
						}
					}
				});
			}	
        },
        mounted() {
            var self = this;
        }
    });
    app.mount('#app');
</script>