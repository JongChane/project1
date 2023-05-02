package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.mapper.BoardMapper;

public class BoardMybatisDao {
      private Class<BoardMapper> cls = BoardMapper.class;
      private Map<String,Object> map = new HashMap<>();

			public int boardCount(String boardid, String column, String find) {
				SqlSession session = MybatisConnection.getConnection();
				try {
					map.clear();
					map.put("boardid", boardid);
					map.put("column", column);
					if (column != null) {
						String[] cols = column.split(",");
						switch (cols.length) {
						case 3:
							map.put("col3", cols[2].trim());
						case 2:
							map.put("col2", cols[1].trim());
						case 1:
							map.put("col1", cols[0].trim());
						}
						map.put("find", find);
					}
					return session.getMapper(cls).boardCount(map);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					MybatisConnection.close(session);
				}
				return 0;
			}

			public List<Board> list(String boardid, int pageNum, int limit, String column, String find) {
				SqlSession session = MybatisConnection.getConnection();
				try {
					map.clear();
					map.put("boardid", boardid);
					map.put("start", (pageNum - 1) * limit);
					map.put("limit", limit);
					map.put("column", column);
					if (column != null) {
						String[] cols = column.split(",");
						switch (cols.length) {
						case 3:
							map.put("col3", cols[2].trim());
						case 2:
							map.put("col2", cols[1].trim());
						case 1:
							map.put("col1", cols[0].trim());
						}
						map.put("find", find);
					}
					return session.getMapper(cls).selectlist(map);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					MybatisConnection.close(session);
				}
				return null;
			}

			public int popularboardCount(String boardid, String column, String find) {
				SqlSession session = MybatisConnection.getConnection();
				try {
					map.clear();
					map.put("boardid", boardid);
					map.put("column", column);
					if (column != null) {
						String[] cols = column.split(",");
						switch (cols.length) {
						case 3:
							map.put("col3", cols[2].trim());
						case 2:
							map.put("col2", cols[1].trim());
						case 1:
							map.put("col1", cols[0].trim());
						}
						map.put("find", find);
					}
					return session.getMapper(cls).popularboardCount(map);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					MybatisConnection.close(session);
				}
				return 0;
			}

			public List<Board> PopularList(String boardid, int pageNum, int limit, String column, String find) {
				SqlSession session = MybatisConnection.getConnection();
				try {
					map.clear();
					map.put("boardid", boardid);
					map.put("start", (pageNum - 1) * limit);
					map.put("limit", limit);
					map.put("column", column);
					if (column != null) {
						String[] cols = column.split(",");
						switch (cols.length) {
						case 3:
							map.put("col3", cols[2].trim());
						case 2:
							map.put("col2", cols[1].trim());
						case 1:
							map.put("col1", cols[0].trim());
						}
						map.put("find", find);
					}
					return session.getMapper(cls).selectPopularList(map);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					MybatisConnection.close(session);
				}
				return null;
			}
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

					public boolean insert(Board board) {
						SqlSession session = MybatisConnection.getConnection();
						try {
							return session.getMapper(cls).insert(board) > 0;
						} catch (Exception e) {
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

					public int maxcomment_num(int board_num) {
						SqlSession session = MybatisConnection.getConnection();
						try {
							return session.getMapper(cls).maxcomment_num(board_num);
						} catch (Exception e) {
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
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							MybatisConnection.close(session);
						}
						return false;
					}
   }