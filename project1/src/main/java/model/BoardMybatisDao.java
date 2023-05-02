package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.mapper.BoardMapper;
import org.apache.ibatis.session.SqlSession;

public class BoardMybatisDao {
      private Class<BoardMapper> cls = BoardMapper.class;
      private Map<String,Object> map = new HashMap<>();
      
      public int maxnum() {
    	  SqlSession session = MybatisConnection.getConnection();
    	  try {
    		  return session.getMapper(cls).maxnum();
    	  } catch(Exception e) {
    		  e.printStackTrace();
    	  } finally {
    		  MybatisConnection.close(session);
    	  }
    	  return 0;
      }
}