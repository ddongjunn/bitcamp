<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Calendar cal = Calendar.getInstance();
int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) + 1;
int tday = cal.get(Calendar.DATE);
%>

<form action="pollmakeAf.do" method="post">

<table class="list_table" style="width: 85%">
<col width="200px"><col width="500px">

<tr>
	<th>아이디</th>
	<td style="text-align: left;">
		${login.id}<input type="hidden" name="id" value="${login.id}">
	</td>
</tr>

<tr>
	<th>투표기한</th>
	<td style="text-align: left;">
		<select name="syear">
			<%
			
			for(int i = tyear;i < tyear + 6; i++){			
				%>
				<!-- 현재연도(올해) 연도와 같을때는 selected -->
				<option <%=(tyear + "").equals(i + "")?"selected='selected'":""%> value="<%=i %>" ><%=i %></option>				
				<%
			}
			%>		
		</select>년
		
		<select name="smonth">
			<%
			for(int i = 1;i <= 12; i++){			
				%>
				<option <%=(tmonth + "").equals(i + "")?"selected='selected'":""%> value="<%=i %>" ><%=i %></option>
				<%
			}
			%>		
		</select>월
		
		<select name="sday">
			<%
			for(int i = 1;i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){			
				%>
				<option <%=(tday + "").equals(i + "")?"selected='selected'":""%> value="<%=i %>" ><%=i %></option>
				<%
			}
			%>		
		</select>일
		~
		<select name="eyear">
			<%
			for(int i = tyear;i < tyear + 6; i++){			
				%>
				<option <%=(tyear + "").equals(i + "")?"selected='selected'":""%> value="<%=i %>" ><%=i %></option>				
				<%
			}
			%>		
		</select>년
		
		<select name="emonth">
			<%
			for(int i = 1;i <= 12; i++){			
				%>
				<option <%=(tmonth + "").equals(i + "")?"selected='selected'":""%> value="<%=i %>" ><%=i %></option>
				<%
			}
			%>		
		</select>월
		
		<select name="eday">
			<%
			for(int i = 1;i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){			
				%>
				<option <%=(tday + "").equals(i + "")?"selected='selected'":""%> value="<%=i %>" ><%=i %></option>
				<%
			}
			%>		
		</select>일	
	</td>
</tr>

<tr>
	<th>투표 내용</th>
	<td style="text-align: left;">
		<textarea rows="10" cols="50" name="question"></textarea>
	</td>
</tr>

<tr>
	<th>투표 문항수</th>
	<td style="text-align: left;">
		<select name="itemcount" onchange="pollchange(this)">
			<%
			for(int i = 2;i <= 10; i++){
				%>	
				<!-- default 문항수 4 -->
				<option <%=(4 + "").equals(i + "")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
				<%
			}			
			%>
		</select>
	</td>	
</tr>

<tr>
	<th>투표 상세 문항</th>
	<td style="text-align: left;">
	<!-- 투표 문항수에 따라서 제어를 해줘야 한다. js에서 -->
		<%
		for(int i = 1;i <= 10; i++){
			%>
			<div id="poll<%=i %>">
				<%=(i + "") %>번:<input type="text" name="poll<%=i %>" size="60">
			</div>
			<%
		}
		%>
	</td>
</tr>

<tr>
	<td colspan="2">
		<span class="blue button">
			<input type="submit" value="투표만들기">
		</span>
	</td>
</tr>

</table>

</form>

<script>
$(document).ready(function() {
	
	// 보기 항목을 초기화
	for(i = 5;i <= 10; i++){
		$("#poll" + i).hide(); //현재 id에 해당하는 값이 숨겨짐
	}
	
});

function pollchange( sel ) {
	
	console.log(sel);
	
	let val = sel.options[sel.selectedIndex].value; //현재 선택되어진 index의 value
	//alert(val);

	// 초기화
	//초기화를 해주는이유? 갯수가 많아졌다가 작아지면 줄어들지 않기 때문에
	for(i = 1;i <= 10; i++){
		$("#poll" + i).val("");
		$("#poll" + i).hide();
	}		

	// 설정한 값만큼 보여준다
	for(i = 1;i <= val; i++){
		$("#poll" + i).show();
	}
}


</script>








