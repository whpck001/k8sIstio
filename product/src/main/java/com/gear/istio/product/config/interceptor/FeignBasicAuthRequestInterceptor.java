
package com.gear.istio.product.config.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {


    public FeignBasicAuthRequestInterceptor() {
    }

    /**
     * 实现具体的拦截器逻辑
     */
    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println(headerNames);

        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String values = request.getHeader(name);
            template.header(name, values);
        }
        System.out.println(1);
//        if (null != serverHttpRequest) {
//            HttpHeaders headers = serverHttpRequest.getHeaders();
//            Set<String> keySets = headers.keySet();
//            for (String keySet : keySets) {
//                template.header(keySet, headers.get(keySet));
//            }
//        }
    }
}