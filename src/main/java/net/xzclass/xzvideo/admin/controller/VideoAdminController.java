package net.xzclass.xzvideo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.xzclass.xzvideo.daoobj.VideoDaoObjBase;
import net.xzclass.xzvideo.service.VideoService;

@RestController
@RequestMapping("/admin/video")
public class VideoAdminController {
	
	@Autowired
	private VideoService videoService;
	
	/**
	 * 	根据ID删除视频
	 * @param id 视频ID
	 * @return
	 */
	@RequestMapping(value="/del", method=RequestMethod.DELETE)
	public Object delById(@RequestParam(value="id", required=true) int id) {
		return videoService.delete(id);
	}
	
	/**
	 *	根据ID更新视频
	 * @param video 视频类
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Object update(@RequestBody VideoDaoObjBase video) {
		return videoService.update(video);
	}
	
	/**
	 * 	保存视频 
	 * @param video 视频类
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Object save(@RequestBody VideoDaoObjBase video) {
		int id = videoService.save(video);
		int rowId = video.getId();
		System.out.println(rowId);
		return id;
	}
}
