package com.huluman.woat.tools;

import com.github.sd4324530.fastweixin.api.MenuAPI;
import com.github.sd4324530.fastweixin.api.entity.Menu;
import com.github.sd4324530.fastweixin.api.entity.MenuButton;
import com.github.sd4324530.fastweixin.api.enums.MenuType;
import com.github.sd4324530.fastweixin.api.enums.ResultType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhengmingzhi on 2016/4/12.
 */
public class MenuCreateTool extends WoatTool {

    /**
     * 创建菜单
     */
    private void createMenu() {
        MenuAPI menuAPI = new MenuAPI(config);

        //先删除之前的菜单
        menuAPI.deleteMenu();
        Menu menu = new Menu();
        //准备一级主菜单
        MenuButton menu1 = new MenuButton();
        menu1.setType(MenuType.CLICK);
        menu1.setKey("menu1");
        menu1.setName("生活");
        //准备子菜单
        MenuButton sub1 = new MenuButton();
        sub1.setKey("2");
        sub1.setName("Baidu");
        sub1.setType(MenuType.VIEW);
        sub1.setUrl("http://www.baidu.com");
        //sub1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxafb7b8f9457b5d50&redirect_uri=http://121.40.140.41/erhuluanzi/app/testGet&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
        MenuButton sub2 = new MenuButton();
        sub2.setKey("3");
        sub2.setName("Entertaiment");
        sub2.setType(MenuType.CLICK);


        List<MenuButton> list = new ArrayList<MenuButton>();
        list.add(sub1);
        list.add(sub2);
        //将子菜单放入主菜单里
        menu1.setSubButton(list);

        List<MenuButton> mainList = new ArrayList<MenuButton>();
        mainList.add(menu1);
        //将主菜单加入请求对象
        menu.setButton(mainList);
        LOG.debug(menu.toJsonString());
        //创建菜单
        ResultType resultType = menuAPI.createMenu(menu);
        LOG.debug(resultType.toString());
    }

    public static void main(String[] args) {
        MenuCreateTool tool = new MenuCreateTool();
        tool.init();
        tool.createMenu();
    }
}
