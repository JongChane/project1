package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import gdu.mskim.MSLogin;
import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.Member;
import model.MemberMybatisDao;

@WebServlet(urlPatterns= {"/member/*"},
   initParams= {@WebInitParam(name="view",value="/view/")})
public class MemberController extends MskimRequestMapping{
	private MemberMybatisDao dao = new MemberMybatisDao();
//===================================================	
	public String loginCheck(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String login=(String)request.getSession().getAttribute("login");
		if(login==null) {
			request.setAttribute("msg", "로그인 하세요");
			request.setAttribute("url", "loginForm");
			return "alert";
		}
		return null;
	}
	public String loginIdCheck(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String id = request.getParameter("id");
		String login=(String)request.getSession().getAttribute("login");
		if(login==null) {
			request.setAttribute("msg", "로그인 하세요");
			request.setAttribute("url", "loginForm");
			return "alert";
		} else if (!login.equals("admin") && !id.equals(login)) {
			request.setAttribute("msg", "본인만 거래 가능합니다.");
			request.setAttribute("url", "main");
			return "alert";			
		}
		return null;
	}
	public String loginAdminCheck(HttpServletRequest request,
			HttpServletResponse response) {
		String login=(String)request.getSession().getAttribute("login");
		if(login==null) {
			request.setAttribute("msg", "로그인 하세요");
			request.setAttribute("url", "loginForm");
			return "alert";
		} else if (!login.equals("admin")) {
			request.setAttribute("msg", "관리자만 거래 가능합니다.");
			request.setAttribute("url", "main");
			return "alert";			
		}
		return null;
	}
	@RequestMapping("loginForm")
	public String loginForm(HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("uri", request.getRequestURI());
		return "member/loginForm"; 
	}
	@RequestMapping("login")
	public String login(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		Member mem = dao.selectOne(id);
		String msg = null;
		String url = null;
		if(mem == null) {
			msg = "아이디를 확인하세요";
			url = "loginForm";
		} else if (!pass.equals(mem.getPass())) { 
			msg = "비밀번호가 틀립니다.";
			url = "loginForm";
		} else {  
			request.getSession().setAttribute("login", id);
			msg="반갑습니다." + mem.getName() +"님";
			url = "main";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "alert"; 
	}
	@RequestMapping("main")
	public String main(HttpServletRequest request,
			HttpServletResponse response) {
		String login=(String)request.getSession().getAttribute("login");
		if(login == null) {  
			request.setAttribute("msg", "로그인하세요");
			request.setAttribute("url", "loginForm");
			return "alert"; 
		}
		return "member/main"; 
	}
	
	@RequestMapping("logout")
	public String logout
	   (HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "redirect:loginForm"; 
	}
	
	@RequestMapping("info")
	@MSLogin("loginIdCheck")
	public String info
	   (HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Member mem = dao.selectOne(id);
		request.setAttribute("mem", mem);
		return "member/info"; 
	}
	
	@RequestMapping("join")
	public String join(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Member mem = new Member();
		mem.setName(request.getParameter("name"));
		mem.setId(request.getParameter("id"));
		mem.setPass(request.getParameter("pass"));
		mem.setTel(request.getParameter("tel"));
		mem.setEmail(request.getParameter("email"));
		if(dao.insert(mem)) {
			request.setAttribute
			         ("msg", mem.getName()+"님 회원 가입 되었습니다.");
			request.setAttribute("url", "loginForm");
		} else {
			request.setAttribute
	         ("msg", mem.getName()+"님 회원가입시 오류가 발생되었습니다.");
 	        request.setAttribute("url", "joinForm");
		}
		return "alert";
	}	
	
	@RequestMapping("updateForm")
	@MSLogin("loginIdCheck")
	public String updateForm(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		Member mem = dao.selectOne(id);
		request.setAttribute("mem", mem);
		return "member/updateForm";
	}
	@RequestMapping("update")
	@MSLogin("loginIdCheck")
	public String update (HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Member mem = new Member();
		mem.setId(request.getParameter("id"));
		mem.setPass(request.getParameter("pass"));
		mem.setName(request.getParameter("name"));
		mem.setTel(request.getParameter("tel"));
		mem.setEmail(request.getParameter("email"));
		String login = 
				(String)request.getSession().getAttribute("login");
		Member dbMem = dao.selectOne(login);
		String msg = "비밀번호가 틀렸습니다.";
		String url = "updateForm?id="+mem.getId();
		if(mem.getPass().equals(dbMem.getPass())) {
			if(dao.update(mem)) {
				msg = "회원 정보 수정 완료";
				url = "info?id="+mem.getId();
			} else {
				msg = "회원 정보 수정 실패";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "alert";
	}

	@RequestMapping("deleteForm")
	@MSLogin("loginIdCheck")
	public String deleteForm(HttpServletRequest request,
			HttpServletResponse response) {
		return "member/deleteForm";
	}

	@RequestMapping("delete")
	@MSLogin("loginIdCheck")
	public String delete(HttpServletRequest request,
			HttpServletResponse response) {
	  String id = request.getParameter("id");
	  String pass = request.getParameter("pass");
	  String login =(String)request.getSession().getAttribute("login");
	  String msg = null;
	  String url = null;
	  if (id.equals("admin")) {  //
		  request.setAttribute("msg", "관리자는 탈퇴 못합니다.");
		  request.setAttribute("url", "list");
		  return "alert";
	  }
	  Member dbMem = dao.selectOne(login); 
	  if(!pass.equals(dbMem.getPass())) {
	  	  request.setAttribute("msg", "비밀번호 오류"); 
	  	  request.setAttribute("url", "deleteForm?id="+id);
	  	  return  "alert";
	  }
	  if(dao.delete(id)) {  
		msg=id +"고객님 탈퇴성공";
	   	if(login.equals("admin"))   url = "list";
	   	else { 
	   	  request.getSession().invalidate(); 
	   	  url = "loginForm";
	   	}
     } else { 
		msg=id +"고객님 탈퇴시 오류 발생. 탈퇴 실패";
	   	if(login.equals("admin"))   url = "list";
	   	else                        url = "info?id="+id;
	 }
	 request.setAttribute("msg", msg);
	 request.setAttribute("url", url);
     return "alert";
   }
   @RequestMapping("list")
   @MSLogin("loginAdminCheck")
   public String list(HttpServletRequest request,
		   HttpServletResponse response) {
	   List<Member> list = dao.list();
	   request.setAttribute("list", list);
	   return "member/list";
   }
   
   @RequestMapping("id")
   public String id(HttpServletRequest request,
			   HttpServletResponse response) {
	   String email = request.getParameter("email");
	   String tel = request.getParameter("tel");
	   String id = dao.idSearch(email,tel); 
	   if(id != null) { //id 찾은 경우   
		   String showId = id.substring(0,id.length()-2);
		   request.setAttribute("id", showId);
		   return "member/id";
	   } else {
		   request.setAttribute("msg", "아이디를 찾을 수 없습니다.");
		   request.setAttribute("url", "idForm");
		   return "alert";
	   }
   }
  
   @RequestMapping("pw")
   public String pw(HttpServletRequest request,
			   HttpServletResponse response) {
	   String id = request.getParameter("id");
	   String email = request.getParameter("email");
	   String tel = request.getParameter("tel");
	   String pass = dao.pwSearch(id,email,tel);
	   if(pass != null) {
		   request.setAttribute("pass", pass.substring(2,pass.length()));
	       return "member/pw";
	   } else {
		   request.setAttribute("msg", "비밀번호를 찾을 수 없습니다.");
		   request.setAttribute("url", "pwForm");
		   return "alert";
	   }
   }
   @RequestMapping("passwordForm")
   @MSLogin("loginCheck")
   public String passwordForm(HttpServletRequest request,
		   HttpServletResponse response) {
	   return "member/passwordForm";
   }

  
   @RequestMapping("password")
   public String password(HttpServletRequest request,
		   HttpServletResponse response) {
	   String pass = request.getParameter("pass");
	   String chgpass = request.getParameter("chgpass");
	   String login = (String)request.getSession().getAttribute("login");
	   String msg = null;
	   String url = null;
	   boolean opener = true;
	   if(login == null) { //로그아웃 상태
		   msg = "로그인하세요";
		   url = "loginForm";
		   opener = true;
	   } else { //로그인 상태
		   Member dbmem = dao.selectOne(login);
		   if(pass.equals(dbmem.getPass())) { 
			   if(dao.updatePass(login,chgpass)) { 
	               msg = "비밀번호가 변경되었습니다 \\n  다시로그인 하세요";
	  	           request.getSession().invalidate();
	  	           url = "loginForm";
				   opener = true;
			   } else {  //비밀번호 수정시 오류발생
				   msg = "비밀번호가 변경시 오류발생";
				   url = "updateForm?id=" + login;
				   opener = true;
			   }
		   } else {  //비밀번호 오류
			 opener = false;
		     msg = "비밀번호 오류입니다.";
		     url = "passwordForm";
		   }
	   }
	   request.setAttribute("msg", msg);
	   request.setAttribute("url", url);
	   request.setAttribute("opener", opener);
	   return "member/password";
   }

 public final class MyAuthenticator extends Authenticator {
     private String id;
     private String pw;
     public MyAuthenticator(String id, String pw) {
         this.id = id;
         this.pw = pw;
     }
     protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication(id, pw);
     }
 }
}