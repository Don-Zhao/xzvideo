package net.xzclass.xzvideo.service;

import java.util.List;

import net.xzclass.xzvideo.daoobj.VideoDaoObjBase;

/**
 * 视频业务类接口
 * @author zhao.jiahong
 *
 */
public interface VideoService {
	
	public List<VideoDaoObjBase> findAll();
	
	public VideoDaoObjBase findById(Integer id);
	
	public int update(VideoDaoObjBase video);
	
	public int delete(Integer id);
	
	public int save(VideoDaoObjBase video);
}
