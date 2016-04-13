package com.huluman.woat.tools;

import com.github.sd4324530.fastweixin.api.MediaAPI;
import com.github.sd4324530.fastweixin.api.MessageAPI;
import com.github.sd4324530.fastweixin.api.entity.Article;
import com.github.sd4324530.fastweixin.api.enums.MediaType;
import com.github.sd4324530.fastweixin.api.response.GetSendMessageResponse;
import com.github.sd4324530.fastweixin.api.response.UploadMediaResponse;
import com.github.sd4324530.fastweixin.message.MpNewsMsg;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Zhengmingzhi on 2016/4/12.
 */
public class MessageSendTool extends WoatTool{

    public void sendAllMessage(){
        MediaAPI mediaAPI = new MediaAPI(config);
        UploadMediaResponse response = mediaAPI.uploadMedia(MediaType.IMAGE, new File("D:\\2041.jpg"));
        String media_id = response.getMediaId();
        Article article = new Article(media_id, "测试用户", "群发测试", "http://www.baidu.com", "群发测试", "群发测试", Article.ShowConverPic.NO);
        UploadMediaResponse uploadMediaResponse = mediaAPI.uploadNews(Arrays.asList(article));
        MpNewsMsg mpNewsMsg = new MpNewsMsg();
        mpNewsMsg.setMediaId(uploadMediaResponse.getMediaId());
        MessageAPI messageAPI = new MessageAPI(config);
        GetSendMessageResponse messageResponse = messageAPI.sendMessageToUser(mpNewsMsg, true, "0", null);
        LOG.info("Send Message Id is " + messageResponse.getMsgId());
    }

    public static void main(String[] args) {
        MessageSendTool tool = new MessageSendTool();
        tool.init();
        tool.sendAllMessage();
    }
}
