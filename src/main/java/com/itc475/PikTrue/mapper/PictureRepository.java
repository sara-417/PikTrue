package com.itc475.PikTrue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import com.itc475.PikTrue.domain.Picture;

@Mapper
public interface PictureRepository {
	@Select("SELECT * FROM picture")
	@Results(id="UserDataResult", value= {
			@Result(column="picture_name", property="pictureName", id=true),
			@Result(column="tag_one", property="tagOne"),
			@Result(column="tag_two", property="tagTwo"),
			@Result(column="tag_three", property="tagThree"),
			@Result(column="user_name", property="userName")
	})
	public List<Picture> findAll();
	
	@Select({"<script>",
        "SELECT picture_name, tag_one, tag_two, tag_three, user_name FROM picture",
        "WHERE",
        "<if test='searchTerm != null'>",
        "   tag_one LIKE '%' || #{searchTerm} || '%' OR",
        "   tag_two LIKE '%' || #{searchTerm} || '%' OR",
        "   tag_three LIKE '%' || #{searchTerm} || '%' OR",
        "   user_name LIKE '%' || #{searchTerm} || '%'",
        "</if>",
        "</script>"})
@ResultMap("UserDataResult")
public List<Picture> searchBar(@Param("searchTerm") String searchTerm);

}
