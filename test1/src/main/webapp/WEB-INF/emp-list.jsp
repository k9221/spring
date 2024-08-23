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
		<div v-if="vs">{{list}}</div>
	</div>
</body>
</html>
<script>
    const app = Vue.createApp({
        data() {
            return {
                name : "홍길동", // , 잘 찍어주기 (만약 안찍어줄 경우에는 아예 작동을 안하니 신경쓸 것!! 그리고 만드시 복습하자 ^^)!  
				list : {},
				vs : true
            };
        },
        methods: {
            fnGetList(){
				var self = this;
				var nparmap = {};
			
				$.ajax({
					url:"empList.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						self.list = data.list;
					}
				});
            },
			fnSearch(){
				this.vs = !this.vs;  
				var self = this;
				var nparmap = {};
				$.ajax({
					url:"empList.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						self.list = data.list;
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