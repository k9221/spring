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
	table, tr, th, td{
		border : 1px solid black;
		padding : 10px 5px;  
		border-collapse: collapse;
		
	}
	
</style>
<body>
	<div id="app">
		<div>
			제목 : <input v-model="title" type="text" placeholder="제목">
		</div>
		<br>	
		<div>
			내용 : <textarea v-model="contents"cols="30" rows="5"></textarea>
		</div>		
		<button @click="fnSave()">저장</button>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				list : [],
				title : "",
				contents : ""
				
            };
        },
        methods: {
			fnSave(){
				var self = this;
				var nparm = {title : self.title, contents : self.contents};
				$.ajax({
					url:"board-add.dox",
					dataType:"json",	
					type : "POST", 
					data : nparm,
					success : function(data) { 
						alert(data.message);
						if(data.result == "success")
						else(data.result == "fail")
					}
				});	
			}
			
        },
        mounted() { 
            var self = this;
			// self.fnGetList(); // 인서트일때는 이 부분이 필요 없다. 화면을 키면 fnGetList();부분이 바로 실행됨
        }
    });
    app.mount('#app');
</script>