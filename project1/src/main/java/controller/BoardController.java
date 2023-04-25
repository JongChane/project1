package controller;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.BoardMybatisDao;

@WebServlet(urlPatterns = {"/board/*"},
         initParams = {@WebInitParam(name="view",value="/view/")})
public class BoardController extends MskimRequestMapping {
   private BoardMybatisDao dao = new BoardMybatisDao();
   
   @RequestMapping("writeForm")
   public String writeForm(HttpServletRequest request,HttpServletResponse response) {
      return "";
   }
   
   
}