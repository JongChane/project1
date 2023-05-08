package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.mapper.CommentMapper;

public class CommentMybatisDao {
	private Class<CommentMapper> cls = CommentMapper.class;
	private Map<String,Object> map = new HashMap<>();
	public int maxcomment_num(int board_num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).maxcomment_num(board_num);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	public boolean cominsert(Comment comm) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).cominsert(comm) > 0;
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return false;
	}

	public List<Comment> selectclist(int board_num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.put("board_num", board_num);
			return session.getMapper(cls).selectclist(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public void deleteAll(int board_num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			session.getMapper(cls).deleteAll(board_num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
	}

	public boolean delete(int board_num,int comment_num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			int cnt = session.getMapper(cls).delete(board_num,comment_num);
			if(cnt > 0) return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return false;
	}


}
