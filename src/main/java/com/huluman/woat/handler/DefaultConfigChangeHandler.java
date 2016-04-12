package com.huluman.woat.handler;

import com.github.sd4324530.fastweixin.api.config.ConfigChangeNotice;
import com.github.sd4324530.fastweixin.handle.AbstractApiConfigChangeHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Zhengmingzhi on 2016/4/12.
 */
public class DefaultConfigChangeHandler extends AbstractApiConfigChangeHandle {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultConfigChangeHandler.class);

    @Override
    public void configChange(ConfigChangeNotice notice) {
        LOG.debug("收到通知.....");
        LOG.debug(notice.toJsonString());
    }
}
