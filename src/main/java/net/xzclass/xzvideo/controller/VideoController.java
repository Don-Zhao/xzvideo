package net.xzclass.xzvideo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.xzclass.xzvideo.daoobj.VideoDaoObjBase;
import net.xzclass.xzvideo.service.VideoService;

@RestController
@RequestMapping("/video")
public class VideoController {

	@Autowired
	private VideoService videoService;
	
	/**
	 * 	分页接口
	 * @param page 当前第几页，默认为第一页
	 * @param size 每页显示多少条，默认显示10条
	 * @return
	 */
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public Object pageVideo(@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="size", defaultValue="10") int size) {
		PageHelper.startPage(page, size);
		List<VideoDaoObjBase> videos = videoService.findAll();
		
		PageInfo<VideoDaoObjBase> pageInfo = new PageInfo<>(videos);
		return pageInfo;
	}
	
	/**
	 * 	根据ID查找视频
	 * @param id 视频id
	 * @return 查找到的视频
	 */
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public Object findById(@RequestParam(value="id", required=true) int id) {
		return videoService.findById(id);
	}
	
}
