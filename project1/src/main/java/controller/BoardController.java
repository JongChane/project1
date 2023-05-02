package controller;

<<<<<<< HEAD
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
=======
import java.util.Locale.Category;
>>>>>>> branch 'kohyunbin' of https://github.com/JongChane/project1.git

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.Board;
import model.BoardMybatisDao;

@WebServlet(urlPatterns = {"/board/*"},
         initParams = {@WebInitParam(name="view",value="/view/")})
public class BoardController extends MskimRequestMapping {
   private BoardMybatisDao dao = new BoardMybatisDao();
   
<<<<<<< HEAD
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
			int boardcount = dao.boardCount(boardid, column, find); // 게시판 종류별 전체 게시물등록 건수 리턴
			// list : 현재 페이지에 보여질 게시물 목록.
			List<Board> list = dao.list(boardid, pageNum, limit, column, find);
			int maxpage = (int) ((double) boardcount / limit + 0.95);
			int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
			int endpage = startpage + 9;
			if (endpage > maxpage)
				endpage = maxpage;
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
			int boardcount = dao.popularboardCount(boardid, column, find); // 게시판 종류별 전체 게시물등록 건수 리턴
			// list : 현재 페이지에 보여질 게시물 목록.
			List<Board> popularList = dao.PopularList(boardid, pageNum, limit, column, find);
			int maxpage = (int) ((double) boardcount / limit + 0.95);
			int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
			int endpage = startpage + 9;
			if (endpage > maxpage)
				endpage = maxpage;
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
=======
   @RequestMapping("writeForm")
   public String writeForm(HttpServletRequest request,HttpServletResponse response) {
//	   String boardid = (String)request.getAttribute(request.getParameter("boardid"));
//	   String login = (String)request.getSession().getAttribute(request.getParameter("login"));
      return "board/writeForm";
>>>>>>> branch 'kohyunbin' of https://github.com/JongChane/project1.git
   }
<<<<<<< HEAD

=======
   
   @RequestMapping("write")
   public String write(HttpServletRequest request, HttpServletResponse response) {
	   String boardid = (String)request.getSession().getAttribute("boardid");
	   String login = (String)request.getSession().getAttribute("login");
	   if(login == null) {
		   request.setAttribute("msg", "로그인부터 하셔야합니다.");
		   request.setAttribute("url", "member/loginForm");
		   return "alert";
	   }
	   
	   int num = dao.maxnum();
	   Board board = new Board();
	   board.setBoard_num(++num);
	   board.setTitle(request.getParameter("title"));
	   board.setContent(request.getParameter("content"));
	   board.setBoardid(Integer.parseInt(boardid));
	   board.setCategory_num(Integer.parseInt(request.getParameter("category_num")));
	   board.setMember_id(login);
	   
//	   if(dao.insert(board)) {
//		   return "redirect:list?boardid="+boardid;
//	   }
	   
	   request.setAttribute("msg", "게시글 등록 실패");
	   request.setAttribute("url", "writeForm");
	   return "alert";
   }
   
>>>>>>> branch 'kohyunbin' of https://github.com/JongChane/project1.git
}