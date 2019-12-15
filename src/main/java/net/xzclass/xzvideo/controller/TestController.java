package net.xzclass.xzvideo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.xzclass.xzvideo.config.WeChatConfig;
import net.xzclass.xzvideo.daoobj.VideoDaoObjBase;
import net.xzclass.xzvideo.mapper.VideoMapper;

@RestController
public class TestController {

	@Autowired
	private WeChatConfig wechatConfig;
	
	@Autowired
	private VideoMapper videoMapper;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {
		System.out.println(wechatConfig.getAppid());
		System.out.println(wechatConfig.getAppsecret());
		return "hello,xzclass.net";
	}
	
	@RequestMapping(value="/videos", method=RequestMethod.GET)
	public List<VideoDaoObjBase> findAllVideo() {
		return videoMapper.findAll();
	}
}
