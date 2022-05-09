package com.yun.distributedid;

import com.sankuai.inf.leaf.plugin.annotation.EnableLeafServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLeafServer
public class DistributedIdApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedIdApplication.class, args);
    }
}
