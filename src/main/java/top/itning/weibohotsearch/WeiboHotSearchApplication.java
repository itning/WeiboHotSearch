package top.itning.weibohotsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeiboHotSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiboHotSearchApplication.class, args);
    }
}
