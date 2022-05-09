package com.yun.distributedlimiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 漏斗限流保护的下流的服务，保证稳定的流量输出
 * 令牌捅限流保护的是服务自身，保证自身服务不被冲垮
 */
@RestController
@Slf4j
public class LimiterController {

    @Autowired
    private LimiterService limiterService;

    private RateLimiter rateLimiter = RateLimiter.create(10);

    @GetMapping("/guava")
    public void guava() {
        //创建可放2令牌的桶且每秒放2令牌，0.5秒放1令牌
//        RateLimiter rateLimiter = RateLimiter.create(2);
//
//        //平滑输出，允许突发流量
//        log.info("{}", rateLimiter.acquire(3));
//        log.info("{}", rateLimiter.acquire());
//        log.info("{}", rateLimiter.acquire());
//        log.info("{}", rateLimiter.acquire());

        boolean tryAcquire = rateLimiter.tryAcquire();
        if (tryAcquire) {
            //扣库存，下单....
            log.info("恭喜你，抢到了！");
        }else {
            log.info("不好意思，你手慢了，没抢到");
        }
    }

    @GetMapping("/sentinel")
    public String sentinel() {
        limiterService.process();
        return "sentinel";
    }
}
