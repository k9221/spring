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
	<div id="app" v-for="item in list">
			<div>제목:{{item.title}}</div>
			<div>내용:{{item.contents}}</div>
			<div>작성자:{{item.userId}}</div>
			<div>조회수:{{item.hit}}</div>
			<div>작성일:{{item.cdateTime}}</div>
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