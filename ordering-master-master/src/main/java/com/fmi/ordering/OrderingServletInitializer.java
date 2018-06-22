package com.fmi.ordering;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Ordering Web程序启动类
 *
 * @author peter.an
 * @date 2018-06-16 9:43
 */
public class OrderingServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(OrderingApplication.class);
    }

}
