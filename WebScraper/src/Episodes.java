import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Episodes {
	
	static String episodeName;
	static String episodeRating;
	
	public static void main (String []args) throws IOException {
		
		final String URL = "https://www.imdb.com/search/title/?series=tt0417299&sort=user_rating,desc&view=simple";	
		final Document page = Jsoup.connect(URL).get();
		final Elements table = page.select("div.lister-list");
		
		// Traverse all items in lister-item class 
		for (Element item : table.select("div.lister-item")) {
				
			episodeName = item.select("div.lister-item-image img").attr("alt");
			episodeRating = item.select("div.col-imdb-rating").text().trim();
			System.out.println(episodeName + ": " + episodeRating);
			
		}
	}	
}
