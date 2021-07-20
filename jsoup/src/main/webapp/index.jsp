<%@page import="movie.MovieChart"%>
<%@page import="dto.MovieVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	List<MovieVo> list = MovieChart.getCGVdata();
    	for(MovieVo v : list){
    		System.out.println(v.toString());
    		
    	}
    		//list -> json
    		String jsonData = "[";
    		
    		for(MovieVo mv : list){
    			jsonData += "{ name:'" + mv.getTitle() + "', y:" + mv.getPercent() + "}, ";
    		}
    		
    		jsonData = jsonData.substring(0, jsonData.lastIndexOf(","));  // 마지막 , 전까지 가져오기
    		jsonData += "]";
   
    		System.out.println(jsonData);
    		
    		request.setAttribute("jsonData", jsonData);

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">

.highcharts-figure, .highcharts-data-table table {
  min-width: 320px; 
  max-width: 800px;
  margin: 1em auto;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #EBEBEB;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}
.highcharts-data-table caption {
  padding: 1em 0;
  font-size: 1.2em;
  color: #555;
}
.highcharts-data-table th {
	font-weight: 600;
  padding: 0.5em;
}
.highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
  padding: 0.5em;
}
.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
  background: #f8f8f8;
}
.highcharts-data-table tr:hover {
  background: #f1f7ff;
}


input[type="number"] {
	min-width: 50px;
}
</style>

<title>Insert title here</title>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

</head>
<body>

<!-- 
	Crawling : web, xml, json을 통해서 데이터를 수집할 수 있는 기능
				Web page의 tag를 통해서 데이터를 취합
				
	데이터 수집	-> Java(jsoup), python(beautifulsoup)
	데이터의 정형화 (일반 -> 배열)
	분석	-> 머신러닝
	결과의 시각화 -> app, web
	
 -->
 
 <figure class="highcharts-figure">
  <div id="container"></div>
</figure>

<script type="text/javascript">
Highcharts.chart('container', {
	  chart: {
	    plotBackgroundColor: null,
	    plotBorderWidth: null,
	    plotShadow: false,
	    type: 'pie'
	  },
	  title: {
	    text: '2021/07/20 CGV 영화 예매율'
	  },
	  tooltip: {
	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	  },
	  accessibility: {
	    point: {
	      valueSuffix: '%'
	    }
	  },
	  plotOptions: {
	    pie: {
	      allowPointSelect: true,
	      cursor: 'pointer',
	      dataLabels: {
	        enabled: true,
	        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	      }
	    }
	  },
	  series: [{
	    name: 'Movie',
	    colorByPoint: true,
	    data: <%=request.getAttribute("jsonData") %> //시각화
	  }]
	});
</script>
</body>
</html>