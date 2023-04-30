package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Member;

public interface MemberMapper {

	@Insert("insert into member" + " (member_id, pass, tel, email, exp, level) " + " values (#{member_id},#{pass},#{tel},"
			+ " #{email}, 0, 1)")
		int insert(Member mem);

		@Select("select * from member where member_id=#{value}")
		Member selectOne(String member_id);

		@Update("update member set tel=#{tel}, email=#{email} where member_id =#{member_id}")
	int update(Member mem);

	@Select({"<script>",
				"select * from member",
					  "<if test='ids != null'> where member_id in "
					+ "<foreach collection='ids' item='member_id' "
					+ " separator=',' open='(' close=')' > #{member_id}"
					+ "</foreach></if>",
			"</script>"		
	})
	List<Member> list(Map<String, Object > map);

	@Delete("delete from member where member_id=#{value}")
	int delete(String member_id);

	@Select("select member_id from member where email=#{email} and tel =#{tel}")
	String idSearch(@Param("email")String email, @Param("tel")String tel);

	@Select("select pass from member where member_id=#{member_id} and email=#{email} and tel=#{tel}")
	String pwSearch(Map<String, Object> map);

	@Update("update member set pass=#{pass} where member_id=#{member_id}")
	int updatePass(@Param("member_id") String member_id, @Param("pass") String pass);
	
	
}
