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
		검색: <input type="text" placeholder="제목" v-model="keyword">
		<button @click="fnGetList()">검색</button>	
		
		<table>
			<tr>
				<th>게시글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
				<th>삭제</th>
			</tr>
			<tr v-for="item in list">
				<td>{{item.boardNo}}</td>
				<td>{{item.title}}</td>
				<td>{{item.userId}}</td>
				<td>{{item.hit}}</td>
				<td>{{item.cdateTime}}</td>
				<td><button @click="fnDelete(item.boardNo)">삭제</button><td>
			</tr>	
		</table>
		
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
                keyword: "", // , 잘 찍어주기 (만약 안찍어줄 경우에는 아예 작동을 안하니 신경쓸 것!! 그리고 만드시 복습하자 ^^)!  
				list : []
            };
        },
        methods: {
            fnGetList(){
				var self = this;
				var nparmap = {keyword : self.keyword};
				$.ajax({
					url:"board-list.dox",
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
			fnDelete(boardNo){
				var self = this;
				var nparmap = {boardNo : boardNo};
				$.ajax({
					url:"board-remove.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						alert(data.message);
						self.fnGetList();
					}
				});
						
			},
			
        },
        mounted() {
            var self = this;
			self.fnGetList();
        }
    });
    app.mount('#app');
</script>