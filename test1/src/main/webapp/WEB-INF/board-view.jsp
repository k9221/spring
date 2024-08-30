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
		<div>제목:{{info.title}}</div>
		<div>내용:{{info.contents}}</div>
		<div>작성자:{{info.userId}}</div>
		<div>조회수:{{info.hit}}</div>
		<div>작성일:{{info.cdateTime}}</div>
		<div>이메일:{{info.eMail}}</div>
		<div v-if="sessionId == info.sessionId || sessionStatus == 'A'">
			<button @click="fnRemove">삭제</button>
		</div>		
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				boardNo : '${boardNo}',
				info : {},
				sessionId : '${sessionId}',
				sessionStatus : '${sessionStatus}'
			
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