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
		
		<input type="text" placeholder="학번" v-model="stuNo">
		<button @click="fnSearch()">검색</button>		
		<hr>
		<table v-for="item in index">
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
				<th></th>
			</tr>	
			
		</table>
		
		
		
	</div>
</body>
</html>
<script>
		//View(ok.dox) - > Controller(searcHQwer) -> Service(qwer) -> Mapper(XMLd의 id가 qwer) -> XML (쿼리 호출 후 Mapper 한테 리턴)
    const app = Vue.createApp({
        data() {
            return {
				stu : {},
				stuNo : "",
				isVisible: false
            };
        },
        methods: {
            fnGetList(){
				var self = this;
				var nparmap = {};
				$.ajax({
					url:"ok.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { //리턴 받은 파라미터 데이터에 담겨있다.
						console.log(data);
						//self.stu = data.stu;
					}
				});	
            },
			fnSearch(){ //메소드
				this.isVisible = !this.isVisible;
				var self = this;
				//console.log(self.stuNo); // 설정한 객체값을 가져오기 위해서는 this에 저장한 self.stuNo로 접근한다.			
				var nparmap = {stuNo : self.stuNo};
				$.ajax({
					url:"search.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { //리턴 받은 파라미터 데이터에 담겨있다.
						console.log(data);
						alert("db조회 성공하였습니다");
						self.stu = data.stu;
						
					}
				});	
				
			}
        },
        mounted() { // 페이지가 열렸을 경우 해당 코드부분을 실행
            //var self = this;
			// self.fnSearch(); 
        }
    });
    app.mount('#app');
</script>