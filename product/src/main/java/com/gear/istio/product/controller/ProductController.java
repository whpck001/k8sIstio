package com.gear.istio.product.controller;

import com.gear.istio.product.feign.ProductFeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductFeignInterface productFeignInterface;

    @GetMapping("info")
    public String info(){
      return productFeignInterface.info();
    }
}
