import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main (String []args) {
		
		final String URL = "https://www.imdb.com/search/title/?series=tt0417299&view=simple&sort=user_rating,desc";
		
		try {
			
			final Document page = Jsoup.connect(URL).get();
			Elements table = page.select("div.lister-list");
			
			for (Element item : table.select("div.lister-item")) {
				
				String name = item.select("div.lister-item img").attr("alt");
				System.out.println(name);
			}
			
		} catch(Exception error) {
			
			error.printStackTrace();
		}
	}
}
