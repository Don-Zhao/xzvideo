package net.xzclass.xzvideo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import net.xzclass.xzvideo.daoobj.VideoDaoObjBase;
import net.xzclass.xzvideo.provider.VideoProvider;

/**
 * video Dao
 * @author zhao.jiahong
 *
 */
@Mapper
public interface VideoMapper {
	
	@Select("SELECT * FROM video")
	public List<VideoDaoObjBase> findAll();
	
	@Select("SELECT * FROM video WHERE id=#{id}")
	public VideoDaoObjBase findById(Integer id);
	
	//@Update("UPDATE video SET title=#{title}, summary=#{summary}, cover_img=#{coverImg}, view_num=#{viewNum}, price=#{price}, online=#{online}, point=#{point} WHERE id=#{id}")
	@UpdateProvider(type=VideoProvider.class, method="updateVideo")
	public int update(VideoDaoObjBase video);
	
	@Delete("DELETE FROM video WHERE id=#{id}")
	public int delete(Integer id);
	
	@Insert("INSERT INTO video(title, summary, cover_img, view_num, price, create_time, online, point) values(#{title}, #{summary}, #{coverImg}, #{viewNum}, #{price}, #{createTime}, #{online}, #{point})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	public int save(VideoDaoObjBase video);
}
