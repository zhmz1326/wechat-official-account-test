package com.huluman.woat.tools;

import com.github.sd4324530.fastweixin.api.MenuAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.Menu;
import com.github.sd4324530.fastweixin.api.entity.MenuButton;
import com.github.sd4324530.fastweixin.api.enums.MenuType;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.huluman.woat.handler.DefaultConfigChangeHandler;
import com.huluman.woat.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhengmingzhi on 2016/4/12.
 */
public class MenuCreateTool {
    private static final Logger LOG = LoggerFactory.getLogger(MenuCreateTool.class);

    private ApiConfig config;

    public void init() {
        config = new ApiConfig(Constants.APP_ID, Constants.APP_SECRET);
        DefaultConfigChangeHandler configChangeHandle = new DefaultConfigChangeHandler();
        config.addHandle(configChangeHandle);
    }

    /**
     * 创建菜单
     *
     * @param config API配置
     */
    private void createMenu(ApiConfig config) {
        MenuAPI menuAPI = new MenuAPI(config);

        //先删除之前的菜单
        menuAPI.deleteMenu();
        Menu request = new Menu();
        //准备一级主菜单
        MenuButton main1 = new MenuButton();
        main1.setType(MenuType.CLICK);
        main1.setKey("main1");
        main1.setName("测试");
        //准备子菜单
        MenuButton sub1 = new MenuButton();
        sub1.setKey("sub1");
        sub1.setName("授权");
        sub1.setType(MenuType.VIEW);
        sub1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxafb7b8f9457b5d50&redirect_uri=http://121.40.140.41/erhuluanzi/app/testGet&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
        MenuButton sub2 = new MenuButton();
        sub2.setKey("sub2");
        sub2.setName("点击");
        sub2.setType(MenuType.CLICK);


        List<MenuButton> list = new ArrayList<MenuButton>();
        list.add(sub1);
        list.add(sub2);
        //将子菜单放入主菜单里
        main1.setSubButton(list);

        List<MenuButton> mainList = new ArrayList<MenuButton>();
        mainList.add(main1);
        //将主菜单加入请求对象
        request.setButton(mainList);
        LOG.debug(request.toJsonString());
        //创建菜单
        ResultType resultType = menuAPI.createMenu(request);
        LOG.debug(resultType.toString());
    }
}
