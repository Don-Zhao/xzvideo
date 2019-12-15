package net.xzclass.xzvideo.provider;

import org.apache.ibatis.jdbc.SQL;

import net.xzclass.xzvideo.daoobj.VideoDaoObjBase;

/**
 * video构建动态SQL语句
 * 
 * @author zhao.jiahong
 *
 */
public class VideoProvider {
	/**
	 * 	更新video动态语句
	 * @param video
	 * @return
	 */
	public String updateVideo(final VideoDaoObjBase video) {
		return new SQL() {{
			UPDATE("video");
			
			if (video.getTitle() != null) {
				SET("title=#{title}");
			}
			
			if (video.getSummary() != null) {
				SET("summary=#{summary}");
			}
			
			if (video.getCoverImg() != null) {
				SET("cover_img=#{coverImg}");
			}
			
			if (video.getViewNum() != null) {
				SET("view_num=#{viewNum}");
			}
			
			if (video.getPrice() != null) {
				SET("price=#{price}");
			}
			
			if (video.getOnline() != null) {
				SET("online=#{online}");
			}
			
			if (video.getPoint() != null) {
				SET("point=#{point}");
			}
			
			WHERE("id=#{id}");
		}}.toString();
	}
}
