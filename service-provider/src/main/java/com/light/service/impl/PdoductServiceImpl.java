package com.light.service.impl;

import com.light.pojo.Product;
import com.light.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PdoductServiceImpl implements ProductService {

    @Override
    public List<Product> selectProductList() {
        return Arrays.asList(
                new Product(1, "手机", 2, 1888d),
                new Product(2, "平板", 3, 4000d),
                new Product(3, "电脑", 499, 23333d)
        );
    }
}
