package movie;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dto.MovieVo;

public class MovieChart {
	public static List<MovieVo> getCGVdata() throws Exception{
		
		Document doc = (Document) Jsoup.connect("http://www.cgv.co.kr/movies/").get();

		Elements titles = doc.select("div.box-contents strong.title");

		Elements percents = doc.select("div.box-contents div.score strong.percent span");
		
		List<MovieVo> list = new ArrayList<MovieVo>();
		for(int i = 0; i < 7; i++) {
			Element title = titles.get(i);
			Element percent = percents.get(i);
			
			String t = title.text();
			String p = percent.text();			
			
			double pv = Double.parseDouble(p.replace("%", ""));
			
			MovieVo vo = new MovieVo(t, pv);
			
			list.add(vo);
		}
		
		return list;	
	}
}
