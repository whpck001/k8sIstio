package com.gear.istio.product.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user",url = "gearistio-user")
public interface ProductFeignInterface {

    @GetMapping("user/info")
    public String info();
}
