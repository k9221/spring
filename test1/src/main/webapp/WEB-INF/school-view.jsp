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
		<div>학번:{{info.stuNo}}</div>
		<div>이름:{{info.name}}</div>
		<div>학부:{{info.dName}}</div>
		<div>학과:{{info.lesson}}</div>
		<div>담당교수:{{info.pName}}</div>		
			
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				stuNo : '${stuNo}',
				info : {}
			
            };
        },
        methods: {
			fnGetList(){
				var self = this;
				var nparmap = {stuNo : self.stuNo};
				$.ajax({
					url:"school-view.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						self.info = data.info;
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