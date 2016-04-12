package com.huluman.woat.controller;

import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinControllerSupport;
import com.huluman.woat.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weixin")
public class WoatController extends WeixinControllerSupport {
    private static final Logger log = LoggerFactory.getLogger(WoatController.class);


    //设置TOKEN，用于绑定微信服务器
    @Override
    protected String getToken() {
        return Constants.TOKEN;
    }

    //使用安全模式时设置：APPID
    //不再强制重写，有加密需要时自行重写该方法
    @Override
    protected String getAppId() {
        return Constants.APP_ID;
    }

    //使用安全模式时设置：密钥
    //不再强制重写，有加密需要时自行重写该方法
    @Override
    protected String getAESKey() {
        return Constants.AES_KEY;
    }

    //重写父类方法，处理对应的微信消息
    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent();
        // TODO Implement it
        // 消息类型
        // https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140543&token=&lang=zh_CN
        log.debug("Message from user:{}", content);
        String response;
        if("1".equals(content)) {
            response = "Yuhang Life";
        } else if("2".equals(content)) {
            response = "Yuhang Groumet";
        } else if("3".equals(content)) {
            response = "Yuhang Entertainment";
        } else {
            response = "Menu:\n1.Life\n2.Groumet\n3.Entertaiment\nTel:13011111111";
        }
        return new TextMsg(response);
    }
}
