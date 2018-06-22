package com.fmi.ordering.common.constant.dictmap;

import com.fmi.ordering.common.constant.dictmap.base.AbstractDictMap;

/**
 * 日志的字典
 *
 * @author peter.an
 * @date 2018-06-15 15:01
 */
public class LogDict extends AbstractDictMap {

    @Override
    public void init() {
        put("tips","备注");
    }

    @Override
    protected void initBeWrapped() {

    }
}
