package com.huluman.woat.tools;

import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.huluman.woat.handler.DefaultConfigChangeHandler;
import com.huluman.woat.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Zhengmingzhi on 2016/4/13.
 */
public class WoatTool {
    protected static final Logger LOG = LoggerFactory.getLogger(WoatTool.class);

    protected ApiConfig config;

    protected void init() {
        config = new ApiConfig(Constants.APP_ID, Constants.APP_SECRET);
        DefaultConfigChangeHandler configChangeHandle = new DefaultConfigChangeHandler();
        config.addHandle(configChangeHandle);
    }
}
