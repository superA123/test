package com.fmi.ordering.common.constant.dictmap;

import com.fmi.ordering.common.constant.dictmap.base.AbstractDictMap;

/**
 * 通知的映射
 *
 * @author peter.an
 * @date 2018-06-15 15:01
 */
public class NoticeMap extends AbstractDictMap {

    @Override
    public void init() {
        put("title", "标题");
        put("content", "内容");
    }

    @Override
    protected void initBeWrapped() {
    }
}
