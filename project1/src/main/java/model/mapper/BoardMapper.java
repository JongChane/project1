package model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface BoardMapper {
	@Select("select ifnull(max(board_num),0) from board")
	int maxnum();
	
	@Insert("insert into board() values ()")
	boolean insert();
}
