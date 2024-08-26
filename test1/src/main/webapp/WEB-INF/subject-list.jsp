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
</style>
<body>
	<div id="app">
		
		<button type="button" @click="fnSearch()">검색</button>
		<table>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학과</th>
				<th>학년</th>
				<th>교실</th>
				<th>성별</th>
				<th>키</th>
				<th>몸무게</th>
			</tr>
			<tr>
				<th>{{stuList.stuNo}}</th>
			</tr>		
		</table>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
                name : "홍길동", // , 잘 찍어주기 (만약 안찍어줄 경우에는 아예 작동을 안하니 신경쓸 것!! 그리고 만드시 복습하자 ^^)!  
				subList : [],
				stuList : []
	
            };
        },
        methods: {
            fnGetList(){
				var self = this;
				var nparmap = {};
			
				$.ajax({
					url:"subject-list.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						self.subList = data.subList;
						self.stuList = data.stuList;
					}
				});
            },
			fnSearch(){
				var self = this;
				var nparmap = {};
				$.ajax({
					url:"subject-list.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						self.subList = data.subList;
						self.stuList = data.stuList;
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