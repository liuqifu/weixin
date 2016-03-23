package com.forlin.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2016/3/23.
 */

/**
 * 微信与开发者服务器交互接口
 */
@Controller
@RequestMapping("/wxapi")
public class WxConnectApi {
    /**
     * GET请求：进行URL、Tocken 认证；
     * 1. 将token、timestamp、nonce三个参数进行字典序排序
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     */
    @RequestMapping(value = "/{account}/message",  method = RequestMethod.GET)
    @ResponseBody
    public String doGet(HttpServletRequest request, @PathVariable String account) {
//        //如果是多账号，根据url中的account参数获取对应的MpAccount处理即可
//        MpAccount mpAccount = WxMemoryCacheClient.getSingleMpAccount();//获取缓存中的唯一账号
//        if(mpAccount != null){
//            String token = mpAccount.getToken();//获取token，进行验证；
//            String signature = request.getParameter("signature");// 微信加密签名
//            String timestamp = request.getParameter("timestamp");// 时间戳
//            String nonce = request.getParameter("nonce");// 随机数
//            String echostr = request.getParameter("echostr");// 随机字符串
//
//            // 校验成功返回  echostr，成功成为开发者；否则返回error，接入失败
//            if (SignUtil.validSign(signature, token, timestamp, nonce)) {
//                return echostr;
//            }
//        }
        return "error";
    }
}
