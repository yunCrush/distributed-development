package com.yun.distributedlimiter;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class LimiterService {

    @SentinelResource("LimiterService.process")
    public String process() {
        return "process";
    }
}
