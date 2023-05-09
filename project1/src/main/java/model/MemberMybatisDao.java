package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.mapper.MemberMapper;

public class MemberMybatisDao {
	private Class<MemberMapper> cls = MemberMapper.class;
	private Map<String,Object> map = new HashMap<>();
	public boolean insert(Member mem) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			int cnt = session.getMapper(cls).insert(mem);
			if(cnt > 0) return true;
			else return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return false;
	}

	public Member selectOne(String member_id) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).selectOne(member_id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return null;
	}
	public boolean update(Member mem) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			int cnt = session.getMapper(cls).update(mem);
			return cnt > 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return false;
	}
	public List<Member> list(){
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).list(null);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public boolean delete(String member_id) {
		 SqlSession session = MybatisConnection.getConnection();
		 try {
				int cnt = session.getMapper(cls).delete(member_id);
			 return cnt > 0;
		 } catch (Exception e){
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return false;
	}
	public String idSearch(String email, String tel) {
		 SqlSession session = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).idSearch(email,tel);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
 	}

	public String pwSearch(String member_id, String email, String tel) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.clear();
			map.put("member_id", member_id);
			map.put("email",email);
			map.put("tel", tel);
			return session.getMapper(cls).pwSearch(map);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public boolean updatePass(String member_id, String pass) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			int cnt = session.getMapper(cls).updatePass(member_id, pass);
			return cnt>0;
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return false;
	}

	public List<Board> boardselect(String member_id) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).boardlist(member_id);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public void exupdate(String member_id, int exp) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			session.getMapper(cls).exupdate(member_id, exp);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
	}
	public List<Board> listdelete(String member_id) {
		SqlSession session = MybatisConnection.getConnection();
		 try {
			session.getMapper(cls).listdelete(member_id);
		 } catch (Exception e){
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
	}
	 
}
