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
			<div>제목:{{list.title}}</div>
			<div>내용:{{list.contents}}</div>
			<div>작성자:{{list.userId}}</div>
			<div>조회수:{{list.hit}}</div>
			<div>작성일:{{list.cdateTime}}</div>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				boardNo : '${boardNo}',
				list : {boardNo}
			
            };
        },
        methods: {
			fnGetList(){
				var self = this;
				var nparmap = {boardNo : self.boardNo};
				$.ajax({
					url:"board-view.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						self.list = data.list;
					}
				});
			},

        },
        mounted() {
			var sele = this;
			self.fnGetList();
        }
    });
    app.mount('#app');
</script>