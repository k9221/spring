<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Quill CDN -->
	<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
	<script src="https://cdn.quilljs.com/1.3.6/quill.min.js"></script>
	<meta charset="UTF-8">
	<jsp:include page="/layout/menu.jsp"></jsp:include>
	<title>첫번째 페이지</title>
</head>
<style>
	table {
		margin : 20px;s
	}
	table, tr, th, td {
		border : 1px solid black;
		padding : 5px 5px;
		border-collapse: collapse;
	}
	
	tr{
		width : 300px;
		 
	}
	div{
	}
</style>
<body>
	<div id="app">
		
		<table>
			<tr>
				<th>학번 
					<td>
						<input id="stuNo" placeholder="학번" v-model="stuNo">
					<td>
				</th>
			</tr>
			<tr>
				<th>이름 
					<td>
						<input id="name" placeholder="이름" v-model="name">
					<td>
				</th>
			</tr>
			<tr>
				<th>아이디 
					<td>
						<input id="id" placeholder="아이디" v-model="id">
					<td>
				</th>
			</tr>
			<tr>
				<th>주민번호 
					<td>
						<input id="jumin" placeholder="주민번호" v-model="jumin">
					<td>
				</th>
			</tr>
		</table>
		<button id="btn" @click="fnSave">저장</button>	
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				list : [],
				stuNo : "",
				name : "",
				id : "",
				jumin : ""
				
            };
        },
        methods: {
			fnGetList(){
				
			},
			fnSave(){
				var self = this;
				var nparam = {
					stuNo : self.stuNo, 
					name : self.name,
					id : self.id,
					jumin : self.jumin

				};
				$.ajax({
					url:"school-add.dox",
					dataType:"json",	
					type : "POST", 
					data : nparam,
					success : function(data) {
						console.log(data)
						self.list = data.list 
						alert(data.message);
						if(data.result == "success"){
							location.href = "school-stu.do"
						}
					}
				});
			}
			
        },
		mounted: function () {
			var self = this;
	    }
    });
    app.mount('#app');
</script>