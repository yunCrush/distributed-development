package com.yun.seataorder;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    //Feign
    @Autowired
    private ProductFeignClient productFeignClient;

//    @Autowired 交给容器管理
//    private RestTemplate restTemplate;

    @GlobalTransactional
    public Boolean create(Integer count) {
        //调用product 扣库存
//        String url = "http://localhost:8086/deduct?productId=5001&count=" + count;
//        Boolean result = restTemplate.getForObject(url, Boolean.class);

        Boolean result = productFeignClient.deduct(5001L, count);
        if (result != null && result) {
            //可能抛出异常
            if (5 == count) {
                throw new RuntimeException("order发生异常了");
            }

            log.info("数据库开始创建订单");
            return true;
        }

        return false;
    }
}
