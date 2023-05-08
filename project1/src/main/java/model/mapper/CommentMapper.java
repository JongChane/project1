package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.Comment;

public interface CommentMapper {
	@Select("select ifnull(max(comment_num),0) from comment where board_num=#{board_num}")
	int maxcomment_num(int board_num);
	
	@Insert("insert into comment (comment_num,content,regdate,recommendcnt,member_id, board_num)"
			+ " values (#{comment_num},#{content},now(),#{recommendcnt},#{member_id},#{board_num})")
	int cominsert(Comment comm);
	
	@Select("select * from comment where board_num = #{board_num}")
	List<Comment> selectclist(Map<String, Object> map);

	@Delete("delete from comment where board_num = #{value}")
	void deleteAll(int board_num);

	@Delete("delete from comment where comment_num = #{comment_num} and board_num = #{board_num}")
	int delete(int comment_num ,int board_num);
}
