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

   }
