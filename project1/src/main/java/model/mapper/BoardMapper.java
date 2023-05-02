package model.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.Board;

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
			+ " limit #{start},#{limit}",
			"</script>"})
	List<Board> selectlist(Map<String, Object> map);

	@Select({ "<script>",
		"select count(*) from board where boardid=#{boardid} and recommendcnt >= 10 "+sqlcol,
		"</script>"})
int popularboardCount(Map<String, Object> map);
	
	@Select({"<script>" ,"SELECT *,"
			+ " (SELECT COUNT(*) FROM comment c WHERE c.board_num = b.board_num) commcnt"
			+ " FROM board b where boardid=#{boardid} and recommendcnt >= 10 ORDER BY recommendcnt DESC " + sqlcol
			+ " limit #{start},#{limit}",
			"</script>"})
	List<Board> selectPopularList(Map<String, Object> map);

	@Select("select ifnull(max(board_num),0) from board")
	int maxnum();
	
	@Insert("insert into board() values ()")
	boolean insert();

}
