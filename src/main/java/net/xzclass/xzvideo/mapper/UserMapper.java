package net.xzclass.xzvideo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import net.xzclass.xzvideo.daoobj.UserDaoObjBase;

@Mapper
public interface UserMapper {
	
	@Insert("INSERT INTO user(openid, name, head_img, phone, sign, sex, city, create_time) VALUES(#{openid}, #{name}, #{headImg}, #{phone}, #{sign}, #{sex}, #{city}, #{createTime})")
	@Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
	public int saveUser(UserDaoObjBase user);
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	public UserDaoObjBase findById(int id);
	
	@Select("SELECT * FROM user WHERE openid = #{openid}")
	public UserDaoObjBase findByOpenid(String openid);
}
