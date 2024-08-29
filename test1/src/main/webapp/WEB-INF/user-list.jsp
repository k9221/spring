<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/menu.jsp"></jsp:include>
	<title>user-list 페이지</title>
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
		<button @click="fnBoardList">게시글 목록</button>
		<div>
			<select style="margin-right : 5px;" v-model="searchOption">
				<option value="all">::전체::</option>
				<option value="id">아이디</option>
				<option value="email">이메일</option>
			</select>
			<input placerholder="검색" v-model="keyword">
			<button @click="fnUserList">검색</button>
		<div>
			<table>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>번호</th>
					<th>성별</th>
					<th>삭제</th>
				</tr>
				<tr v-for="item in list">
					<td><a href="#" @click="fnUser(item.userId)">{{item.userId}}</a></td>
					<td>{{item.pwd}}</td>
					<td>{{item.userName}}</td>
					<td>{{item.eMail}}</td>
					<td>{{item.phone}}</td>
					<td>{{item.gender}}</td>
					<td><button @click="fnRemove(item.userId)">삭제</button></td>
				</tr>
			</table>	
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
				list: [],
				boardList: [],
				keyword: "",
				searchOption: "all"
		
            };
        },
        methods: {
            fnUserList(){
				var self = this;
				var nparmap = {
					keyword: self.keyword,
					searchOption : self.searchOption
				};
				$.ajax({
					url:"user-list.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) {
						console.log("data: " +data);
						self.list = data.list;
					}
				});
            },
			fnRemove(userId){
				var self = this;
				var nparmap = {userId: userId};
				if(!confirm("삭제하시겠습니까?")){
					return;
				}; 
				$.ajax({
					url:"user-remove.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) {
						console.log(data);
						self.fnUserList();
					}
				});
			},
			fnUser(userId){
				$.pageChange("user-view.do", {userId : userId});
			}
        },
        mounted() {
            var self = this;
			self.fnUserList();
			
        }
    });
    app.mount('#app');
</script>
​