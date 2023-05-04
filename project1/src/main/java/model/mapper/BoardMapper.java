package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Board;
import model.Comment;

public interface BoardMapper {
	String sqlcol = "<if test='column != null'>" 		
	+"<if test='col1 != null'> and (${col1} like '%${find}%'</if>"
	+"<if test='col2 == null'> ) </if>"
	+"<if test='col2 != null'> or ${col2} like '%${find}%'</if>"
	+"<if test='col2 != null and col3==null'> ) </if>"
	+"<if test='col3 != null'> or ${col3} like '%${find}%')</if></if>";
	
	@Select({ "<script>",
			"select count(*) from board where boardid=#{boardid} "+sqlcol,
			"</script>"})
	int boardCount(Map<String, Object> map);

	@Select({"<script>" ,"SELECT *,"
			+ " (SELECT COUNT(*) FROM comment c WHERE c.board_num = b.board_num) commcnt"
			+ " FROM board b where boardid=#{boardid}  " + sqlcol
			+ " order by board_num desc limit #{start},#{limit}",
			"</script>"})
	List<Board> selectlist(Map<String, Object> map);

	@Select({ "<script>",
			"select count(*) from board where boardid=#{boardid} and recommendcnt >= 10 " + sqlcol,
		"</script>"})
	int popularboardCount(Map<String, Object> map);
	
	@Select({"<script>" ,"SELECT *,"
			+ " (SELECT COUNT(*) FROM comment c WHERE c.board_num = b.board_num) commcnt"
			+ " FROM board b where boardid=#{boardid} and recommendcnt >= 10 " + sqlcol
			+ " ORDER BY recommendcnt DESC limit #{start},#{limit}",
			"</script>"})
	List<Board> selectPopularList(Map<String, Object> map);

	@Select("select ifnull(max(board_num),0) from board")
	int maxnum();
	
	@Insert("INSERT INTO board (board_num, title, content, readcnt, recommendcnt, regdate, boardid, file1, category_num, member_id)"
			+ " VALUES (#{board_num}, #{title}, #{content}, 0, 0, now(), #{boardid}, #{file1}, #{category_num}, #{member_id})")
	int insert(Board board);

	@Select("select ifnull(max(comment_num),0) from comment where board_num=#{board_num}")
	int maxcomment_num(int board_num);

	@Insert("insert into comment (comment_num,content,regdate,recommendcnt,member_id, board_num)"
			+ " values (#{comment_num},#{content},#{regdate},#{recommendcnt},#{member_id},#{board_num})")
	int cominsert(Comment comm);

	@Select("select * from comment where board_num = #{board_num}")
	List<Comment> selectclist(Map<String, Object> map);
	
	@Select({ "<script>",
		"select count(*) from board where recommendcnt >= 10 "+sqlcol,
		"</script>"})
	int bobboardCount(Map<String, Object> map);
	
	@Select({"<script>" ,"SELECT *,"
			+ " (SELECT COUNT(*) FROM comment c WHERE c.board_num = b.board_num) commcnt"
			+ " FROM board b where recommendcnt >= 10 " + sqlcol
			+ " ORDER BY recommendcnt DESC limit #{start},#{limit}",
			"</script>"})
	List<Board> selectbobList(Map<String, Object> map);
	@Select("select * from board where board_num= #{value}")
	Board selectOne(int num);
	
	@Update("update board set readcnt = readcnt + 1 where board_num=#{value}")
	void readcntAdd(int num);
	
	


}
