package com.light.service.impl;

import com.light.pojo.Order;
import com.light.pojo.Product;
import com.light.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 订单服务
 */
@Service
public class ByAnnotationServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 根据主键查询订单
     * @param id
     * @return
     */
    @Override
    public Order selectOrderById(Integer id) {
        return new Order(id, "order-001", "中国", 31994D, selectProductListByAnnotationClient());
    }

    private List<Product> selectProductListByAnnotationClient() {

        //ResponseEntity:封装了返回数据
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://server-provider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {}
        );

        return response.getBody();
    }
}
