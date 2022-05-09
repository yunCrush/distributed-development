package com.yun.distributedjob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Process {

    //慎用，推荐MQ
    @Async
    public void doProcess1() throws InterruptedException {
        log.info("doProcess1...start");
        Thread.sleep(5000);
        log.info("doProcess1...stop");
    }
}
