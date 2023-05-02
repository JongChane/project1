package controller;

import java.util.Locale.Category;

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
   
   @RequestMapping("writeForm")
   public String writeForm(HttpServletRequest request,HttpServletResponse response) {
//	   String boardid = (String)request.getAttribute(request.getParameter("boardid"));
//	   String login = (String)request.getSession().getAttribute(request.getParameter("login"));
      return "board/writeForm";
   }
   
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
   
}