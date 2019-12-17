package net.xzclass.xzvideo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.xzclass.xzvideo.config.WeChatConfig;
import net.xzclass.xzvideo.daoobj.VideoDaoObjBase;
import net.xzclass.xzvideo.mapper.VideoMapper;
import net.xzclass.xzvideo.model.JsonData;

@RestController
public class TestController {

	@Autowired
	private WeChatConfig wechatConfig;
	
	@Autowired
	private VideoMapper videoMapper;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public JsonData test() {
		return JsonData.buildSuccess(wechatConfig.getAppid());
	}
	
	@RequestMapping(value="/videos", method=RequestMethod.GET)
	public JsonData findAllVideo() {
		List<VideoDaoObjBase> videos = videoMapper.findAll();
		return JsonData.buildSuccess(videos);
	}
}
