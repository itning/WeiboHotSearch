package top.itning.weibohotsearch;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    private static int start = 0;


    public void test() throws IOException, InterruptedException {
        Set<String> set = new HashSet<>(2000);
        doIt(set);
        System.out.println(set);
    }

    private void doIt(Set<String> set) throws IOException, InterruptedException {
        String v = "";
        int i = 0;
        for (; start < 3000; start += 20) {
            System.out.println(start + "--" + v);
            Connection.Response response = Jsoup.connect("https://movie.douban.com/subject/27110296/comments?start=" + start + "&limit=20&sort=new_score&status=P")
                    .method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36")
                    .header("Host", "movie.douban.com")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("Accept-Language", "zh-CN,zh;q=0.9")
                    .header("Referer", "https://movie.douban.com/subject/27110296/comments?start=" + (start - 20) + "&limit=20&sort=new_score&status=P")
                    .cookie("bid", v)
                    .execute();
            String cookie = response.cookie("bid");
            if (cookie != null) {
                v = cookie;
            }
            if (i >= 8 && i % 8 == 0) {
                v = "";
            }
            response.parse()
                    .body()
                    .getElementsByClass("comment-item")
                    .forEach(element -> {
                        String text = element.getElementsByClass("short").text();
                        set.addAll(HanLP.segment(text).stream()
                                .filter(s -> s.nature == Nature.a)
                                .map(s -> s.word.split("/")[0])
                                .collect(Collectors.toSet()));
                    });
            Thread.sleep(100);
            i++;
        }
    }

    public void testa() throws IOException {
        Connection.Response response = Jsoup.connect("https://movie.douban.com/subject/27110296/comments?start=" + start + "&limit=20&sort=new_score&status=P")
                .method(Connection.Method.GET)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36")
                .header("Host", "movie.douban.com")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .header("Accept-Language", "zh-CN,zh;q=0.9")
                .header("Referer", "https://movie.douban.com/subject/27110296/comments?start=" + (start - 20) + "&limit=20&sort=new_score&status=P")
                .cookie("bid", "3aiC7HMotww")
                .execute();
        System.out.println(response.cookie("bid"));
    }
}