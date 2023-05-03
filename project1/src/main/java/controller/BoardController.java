package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Locale.Category;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.Board;
import model.BoardMybatisDao;

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
		}
   @RequestMapping("writeForm")
   public String writeForm(HttpServletRequest request,HttpServletResponse response) {
	   String boardid = (String)request.getAttribute(request.getParameter("boardid"));
	   if(boardid==null) boardid="1";
	   String login = (String)request.getSession().getAttribute(request.getParameter("login"));
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
	public String imgupload(HttpServletRequest request,
			HttpServletResponse response) {
	    String path=request.getServletContext().getRealPath("/")
			    +"/upload/imgfile/";
	    File f = new File(path);
		if(!f.exists()) f.mkdirs();
		int size=10*1024*1024;
		MultipartRequest multi = null;
		try {
			   multi = new MultipartRequest(request,path,size,"UTF-8");
		} catch(IOException e) {
			   e.printStackTrace();
		}
		//ckeditor에서 file의 이름이  upload 임
		String fileName = multi.getFilesystemName("upload");
		request.setAttribute("fileName", fileName);
		return "ckeditor";
	}
   
   @RequestMapping("info")
   public String info(HttpServletRequest request, HttpServletResponse response) {
	   
	   return "board/info";
   }
}