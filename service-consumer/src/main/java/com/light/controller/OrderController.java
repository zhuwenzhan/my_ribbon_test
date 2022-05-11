package com.light.controller;


import com.light.pojo.Order;
import com.light.service.OrderService;
import com.light.service.impl.ByAnnotationServiceImpl;
import com.light.service.impl.DiscoveryClientServiceImpl;
import com.light.service.impl.RibbonClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    @Resource(type= RibbonClientServiceImpl.class)
    private OrderService ribbonClientService;

    @Autowired
    @Resource(type= DiscoveryClientServiceImpl.class)
    private OrderService discoveryClientService;

    @Autowired
    @Resource(type= ByAnnotationServiceImpl.class)
    private OrderService annotationClientService;

    @GetMapping("/discoveryClient/{id}")
    public Order selectOrderByDiscoveryClient(@PathVariable("id") Integer id) {
        return discoveryClientService.selectOrderById(id);
    }

    @GetMapping("/ribbonClient/{id}")
    public Order selectOrderByRibbonClient(@PathVariable("id") Integer id) {
        return ribbonClientService.selectOrderById(id);
    }

    @GetMapping("/annotationClient/{id}")
    public Order selectOrderByAnnotationClient(@PathVariable("id") Integer id) {
        return annotationClientService.selectOrderById(id);
    }
}
