package request;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import org.apache.commons.lang3.CharSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class HtmlTest {

    @Test
    public void htmlPathTest() throws IOException {
        Document document = Jsoup.connect("https://www.zip-codes.com/state/ct.asp").get();
        Elements elements = document.select("table#tblZIP > tbody > tr > td > a[title]");
        Set<String> set = elements.stream()
                .map(element -> element.text().replaceAll("[A-Za-z\\s]", ""))
                .collect(Collectors.toSet());
        System.out.println("Zipcode size: "+ set.size());
        set.forEach(System.out::println);

    }
}
