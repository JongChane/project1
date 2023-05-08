package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import model.ComRecommend;
import model.Comment;


public interface CommentMapper {
   @Select("select ifnull(max(comment_num),0) from comment")
   int maxcomment_num(int board_num);
   
   @Insert("insert into comment (comment_num,content,regdate,recommendcnt,member_id, board_num)"
         + " values (#{comment_num},#{content},now(),#{recommendcnt},#{member_id},#{board_num})")
   int cominsert(Comment comm);
   
   @Select("select * from comment where board_num = #{board_num}")
   List<Comment> selectclist(Map<String, Object> map);

   @Delete("delete from comment where board_num = #{value}")
   void deleteAll(int board_num);

   @Delete("delete from comment where comment_num = #{comment_num} and board_num = #{board_num}")
   int delete(@Param("board_num")int board_num,@Param("comment_num")int comment_num);
   
   @Select("SELECT COUNT(*) FROM com_recommend WHERE comment_num=#{comment_num} AND member_id=#{member_id}")
   int checkcomRecommend(ComRecommend cr);
   
   @Insert("insert into com_recommend (comment_num,member_id) values(#{comment_num}, #{member_id})")
   void comrecommendcnt(ComRecommend cr);
   
   @Update("update comment set recommendcnt = recommendcnt+1 where comment_num=#{comment_num}")
   int comupdaterecommend(int num);
   
   @Delete("delete from com_recommend where comment_num=#{comment_num} and member_id=#{member_id}")
   void comunrecommend(ComRecommend cr);
   
   @Update("update comment set recommendcnt = recommendcnt-1 where comment_num=#{value}")
   int comdownrecommend(int num);
   
   
   
}