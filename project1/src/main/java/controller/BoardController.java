package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.Board;
import model.BoardMybatisDao;
import model.Comment;

@WebServlet(urlPatterns = {"/board/*"},
         initParams = {@WebInitParam(name="view",value="/view/")})
public class BoardController extends MskimRequestMapping {
   private BoardMybatisDao dao = new BoardMybatisDao();
   
		@RequestMapping("list")
		public String list(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			if (request.getParameter("boardid") != null) {
				// session에 게시판 종류 정보 등록
				request.getSession().setAttribute("boardid", request.getParameter("boardid"));
				request.getSession().setAttribute("pageNum", "1"); // 현재페이지 번호
			}
			String boardid = (String) request.getSession().getAttribute("boardid");
			if (boardid == null)
				boardid = "2";
			int pageNum = 1;
			try {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			} catch (NumberFormatException e) {
			}
			String column = request.getParameter("column");
			String find = request.getParameter("find");
			/*
			 * column,find 파라미터 중 한개만 존재하는 경우 두개의 파라미터값은 없는 상태로 설정
			 */
			if (column == null || column.trim().equals("")) {
				column = null;
				find = null;
			}
			if (find == null || find.trim().equals("")) {
				column = null;
				find = null;
			}
			int limit = 10; // 한페이지에 보여질 게시물 건수
			// boardcount : 게시물종류별 게시물 등록건수
			int boardcount = dao.boardCount(boardid, column, find); // 게시판 종류별 전체 게시물등록 건수 리턴
			// list : 현재 페이지에 보여질 게시물 목록.
			List<Board> list = dao.list(boardid, pageNum, limit, column, find);
			for (Board board : list) {
			    String content = board.getContent();
			    Pattern imgPattern = Pattern.compile("<img[^>]+src=\"([^\">]+)\"");
			    Matcher imgMatcher = imgPattern.matcher(content);

			    if (imgMatcher.find()) {
			        String thumbnailUrl = imgMatcher.group(1);
			        board.setThumbnail(thumbnailUrl);
			    }
			}
			int maxpage = (int) ((double) boardcount / limit + 0.95);
			int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
			int endpage = startpage + 9;
			if (endpage > maxpage)
				endpage = maxpage;
			// boardName : 게시판 이름 화면에 출력
			
			String boardName = null;
			switch (boardid) {
			case "1":
				return "redirect:bobList?boardid=" + boardid;
			case "2":
				boardName = "유머게시판";
				break;
			case "3":
				boardName = "해축게시판";
				break;
			case "4":
				boardName = "음식게시판";
				break;
			}
			int boardnum = boardcount - (pageNum - 1) * limit;
			request.setAttribute("boardName", boardName);
			request.setAttribute("boardcount", boardcount);
			request.setAttribute("boardid", boardid);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("boardnum", boardnum);
			request.setAttribute("list", list);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("today", new Date());
			return "board/list";
		}

		@RequestMapping("popularList")
		public String popularList(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			if (request.getParameter("boardid") != null) {
				// session에 게시판 종류 정보 등록
				request.getSession().setAttribute("boardid", request.getParameter("boardid"));
				request.getSession().setAttribute("pageNum", "1"); // 현재페이지 번호
			}
			String boardid = (String) request.getSession().getAttribute("boardid");
			if (boardid == null)
				boardid = "2";
			int pageNum = 1;
			try {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			} catch (NumberFormatException e) {
			}
			String column = request.getParameter("column");
			String find = request.getParameter("find");
			/*
			 * column,find 파라미터 중 한개만 존재하는 경우 두개의 파라미터값은 없는 상태로 설정
			 */
			if (column == null || column.trim().equals("")) {
				column = null;
				find = null;
			}
			if (find == null || find.trim().equals("")) {
				column = null;
				find = null;
			}
			int limit = 10; // 한페이지에 보여질 게시물 건수
			// boardcount : 게시물종류별 게시물 등록건수
			int boardcount = dao.popularboardCount(boardid, column, find); // 게시판 종류별 전체 게시물등록 건수 리턴
			// list : 현재 페이지에 보여질 게시물 목록.
			List<Board> popularList = dao.PopularList(boardid, pageNum, limit, column, find);
			for (Board board : popularList) {
			    String content = board.getContent();
			    Pattern imgPattern = Pattern.compile("<img[^>]+src=\"([^\">]+)\"");
			    Matcher imgMatcher = imgPattern.matcher(content);

			    if (imgMatcher.find()) {
			        String thumbnailUrl = imgMatcher.group(1);
			        board.setThumbnail(thumbnailUrl);
			    }
			}
			int maxpage = (int) ((double) boardcount / limit + 0.95);
			int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
			int endpage = startpage + 9;
			if (endpage > maxpage)
				endpage = maxpage;
			// boardName : 게시판 이름 화면에 출력
			String boardName = null;
			switch (boardid) {
			case "1":
				return "redirect:bobList?boardid=" + boardid;
			case "2":
				boardName = "유머게시판";
				break;
			case "3":
				boardName = "해축게시판";
				break;
			case "4":
				boardName = "음식게시판";
				break;
			}
			int boardnum = boardcount - (pageNum - 1) * limit;
			request.setAttribute("boardName", boardName);
			request.setAttribute("boardcount", boardcount);
			request.setAttribute("boardid", boardid);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("boardnum", boardnum);
			request.setAttribute("popularList", popularList);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("today", new Date());
			return "board/popularList";
		}

		@RequestMapping("bobList")
		public String bobList(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			if (request.getParameter("boardid") != null) {
				// session에 게시판 종류 정보 등록
				request.getSession().setAttribute("boardid", request.getParameter("boardid"));
				request.getSession().setAttribute("pageNum", "1"); // 현재페이지 번호
			}
			String boardid = (String) request.getSession().getAttribute("boardid");
			if (boardid == null)
				boardid = "1";
			int pageNum = 1;
			try {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			} catch (NumberFormatException e) {
			}
			String column = request.getParameter("column");
			String find = request.getParameter("find");
			/*
			 * column,find 파라미터 중 한개만 존재하는 경우 두개의 파라미터값은 없는 상태로 설정
			 */
			if (column == null || column.trim().equals("")) {
				column = null;
				find = null;
			}
			if (find == null || find.trim().equals("")) {
				column = null;
				find = null;
			}
			int limit = 10; // 한페이지에 보여질 게시물 건수
			// boardcount : 게시물종류별 게시물 등록건수
			int boardcount = dao.bobboardCount(boardid, column, find); // 게시판 종류별 전체 게시물등록 건수 리턴
			// list : 현재 페이지에 보여질 게시물 목록.
			List<Board> bobList = dao.bobList(boardid, pageNum, limit, column, find);
			for (Board board : bobList) {
			    String content = board.getContent();
			    Pattern imgPattern = Pattern.compile("<img[^>]+src=\"([^\">]+)\"");
			    Matcher imgMatcher = imgPattern.matcher(content);

			    if (imgMatcher.find()) {
			        String thumbnailUrl = imgMatcher.group(1);
			        board.setThumbnail(thumbnailUrl);
			    }
			}
			int maxpage = (int) ((double) boardcount / limit + 0.95);
			int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
			int endpage = startpage + 9;
			if (endpage > maxpage)
				endpage = maxpage;
			// boardName : 게시판 이름 화면에 출력
			String boardName = "베스트게시판";
			int boardnum = boardcount - (pageNum - 1) * limit;
			request.setAttribute("boardName", boardName);
			request.setAttribute("boardcount", boardcount);
			request.setAttribute("boardid", boardid);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("boardnum", boardnum);
			request.setAttribute("bobList", bobList);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("today", new Date());
			return "board/bobList";
		}
		

   @RequestMapping("writeForm")
   public String writeForm(HttpServletRequest request,HttpServletResponse response) {
			String boardid = (String) request.getSession().getAttribute("boardid");
			if (boardid == null)
				boardid = "1";
			String login = (String) request.getSession().getAttribute("login");
      return "board/writeForm";

   }
   
   @RequestMapping("write")
   public String write(HttpServletRequest request, HttpServletResponse response) {
			String login = (String) request.getSession().getAttribute("login");
			String path = request.getServletContext().getRealPath("/") + "/upload/board/";

			File f = new File(path);
			if (!f.exists())
				f.mkdirs();
			int size = 10 * 1024 * 1024;
			MultipartRequest multi = null;
			try {
				multi = new MultipartRequest(request, path, size, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 파라미터 Board 객체에 저장
			Board board = new Board();
			board.setTitle(multi.getParameter("title"));
			board.setContent(multi.getParameter("content"));
			String boardid = (String) request.getSession().getAttribute("boardid");
			if (boardid == null)
				boardid = "1";
			board.setBoardid(boardid);
			board.setFile1(multi.getFilesystemName("file1"));
			board.setMember_id(login);
			int num = dao.maxnum();
			board.setBoard_num(++num);
			board.setCategory_num(Integer.parseInt(multi.getParameter("category_num")));
			String msg = "게시글 등록 실패";
			String url = "writeForm";
			if (dao.insert(board)) {
				return "redirect:list?boardid=" + boardid;
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);

			return "alert";
   }
   
		@RequestMapping("imgupload")
		public String imgupload(HttpServletRequest request, HttpServletResponse response) {
			String path = request.getServletContext().getRealPath("/") + "/upload/imgfile/";
			File f = new File(path);
			if (!f.exists())
				f.mkdirs();
			int size = 10 * 1024 * 1024;
			MultipartRequest multi = null;
			try {
				multi = new MultipartRequest(request, path, size, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			// ckeditor에서 file의 이름이 upload 임
			String fileName = multi.getFilesystemName("upload");
			request.setAttribute("fileName", fileName);
			return "ckeditor";
		}

		@RequestMapping("comment")
		public String comment(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			// board_num : 게시글 번호
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			String url = "info?board_num=" + board_num + "&readcnt=f";
			// 파라미터값 Comment 객체에 저장
			Comment comm = new Comment();
			comm.setBoard_num(board_num);
			String login = (String) request.getSession().getAttribute("login");
			comm.setMember_id(login);
			comm.setContent(request.getParameter("content"));
			int comment_num = dao.maxcomment_num(board_num); // num에 해당하는 최대 seq 컬럼의 값
			comm.setComment_num(++comment_num);
			if (dao.cominsert(comm)) { // comment 테이블에 insert
				return "redirect:" + url;
			}
			request.setAttribute("msg", "답글 등록시 오류 발생");
			request.setAttribute("url", url);
			return "alert";
		}
		@RequestMapping("info")
		public String info(HttpServletRequest request, HttpServletResponse response) {
			String login = (String)request.getSession().getAttribute("login");
			String boardid = (String)request.getSession().getAttribute("boardid");
			String readcnt = request.getParameter("readcnt");
			int num = Integer.parseInt(request.getParameter("board_num"));
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			Board b = dao.selectOne(num);
			if(readcnt == null || !readcnt.equals("f"))
				dao.readcntAdd(num);
			
			//category_num : 게시판 분류 화면에 출력
			String category_name = null;
			switch(b.getCategory_num()){
				case 1 : category_name = "유머";break;
				case 2 : category_name = "썰";break;
				case 3 : category_name = "공포";break;
				case 4 : category_name = "감동";break;
				case 5 : category_name = "뉴스";break;
				case 6 : category_name = "루머";break;	
				case 7 : category_name = "움짤";break;
				case 8 : category_name = "분석";break;
				case 9 : category_name = "레시피";break;	
				case 10 : category_name = "맛집";break;	
				case 11 : category_name = "자랑";break;	
			}
			
			// boardName : 게시판 이름 화면에 출력
			String boardName = "베스트게시판";
			switch (boardid) {
			case "2":
				boardName = "유머게시판";
				break;
			case "3":
				boardName = "해축게시판";
				break;
			case "4":
				boardName = "음식게시판";
				break;
			}
			//댓글 목록 화면에 전달
//			List<Comment> commlist = cdao.list(num);
			request.setAttribute("b",b);
			request.setAttribute("boardid",boardid);
			request.setAttribute("boardName",boardName);
			request.setAttribute("category_name", category_name);
//			request.setAttribute("commlist",commlist);
			return "board/info";
		}

}