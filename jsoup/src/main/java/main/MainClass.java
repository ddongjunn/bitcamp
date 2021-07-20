package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {
	public static void main(String[] args) throws Exception {
		
		//Jsoup : 각종 사이트(HTML)에서 데이터를 취합할 수 있는 Library
		Document doc = (Document) Jsoup.connect("http://www.cgv.co.kr/movies/").get();
		/*
		<div class="box-contents">
        <a href="/movies/detail-view/?midx=82986">
            <strong class="title">블랙 위도우</strong>
        </a>
        */
		
		Elements titles = doc.select("div.box-contents strong.title");
		
		/*
		 	<div class="score"> <strong class="percent">예매율<span>23.2%</span></strong>
		 */
		Elements percents = doc.select("div.box-contents div.score strong.percent span");

		for(int i = 0; i < 7; i++) {
			Element title = titles.get(i);
			Element percent = percents.get(i);
			System.out.println(title.text() + " " + percent.text());
			
		}
	}
}
