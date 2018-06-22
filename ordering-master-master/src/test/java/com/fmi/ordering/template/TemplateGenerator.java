package com.fmi.ordering.template;

import com.fmi.ordering.core.template.config.ContextConfig;
import com.fmi.ordering.core.template.engine.SimpleTemplateEngine;
import com.fmi.ordering.core.template.engine.base.OrderingTemplateEngine;

import java.io.IOException;

/**
 * 测试Ordering模板引擎
 *
 * @author peter.an
 * @date 2017-05-09 20:27
 */
public class TemplateGenerator {

    public static void main(String[] args) throws IOException {
        ContextConfig contextConfig = new ContextConfig();
        contextConfig.setBizChName("啊哈");
        contextConfig.setBizEnName("haha");
        contextConfig.setModuleName("tk");
        contextConfig.setProjectPath("D:\\tmp\\ordering");

        //contextConfig.setAddPageSwitch(false);
        //contextConfig.setEditPageSwitch(false);

        OrderingTemplateEngine orderingTemplateEngine = new SimpleTemplateEngine();
        orderingTemplateEngine.setContextConfig(contextConfig);
        orderingTemplateEngine.start();
    }

}
