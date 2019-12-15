package net.xzclass.xzvideo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.xzclass.xzvideo.daoobj.VideoDaoObjBase;
import net.xzclass.xzvideo.mapper.VideoMapper;
import net.xzclass.xzvideo.service.VideoService;

/**
 * 	视频业务类Service类
 * @author zhao.jiahong
 *
 */
@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoMapper videoMapper;
	
	@Override
	public List<VideoDaoObjBase> findAll() {
		return videoMapper.findAll();
	}

	@Override
	public VideoDaoObjBase findById(Integer id) {
		return videoMapper.findById(id);
	}

	@Override
	public int update(VideoDaoObjBase video) {
		return videoMapper.update(video);
	}

	@Override
	public int delete(Integer id) {
		return videoMapper.delete(id);
	}

	@Override
	public int save(VideoDaoObjBase video) {
		return videoMapper.save(video);
	}
}
