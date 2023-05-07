<%@page import="model.BoardMybatisDao"%>
<%@page import="model.BoardRecommend"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.UnsupportedEncodingException" %>


<%

    request.setCharacterEncoding("UTF-8");

    String login = (String) request.getSession().getAttribute("login");
    String msg = "";
    String url = "";
    int num = 0;
    if (login == null) {
        msg = "비회원은 추천할 수 없습니다.";
        url = "../member/loginForm";
    } else {
        num = Integer.parseInt(request.getParameter("board_num"));
        BoardRecommend br = new BoardRecommend();
        url = "info?board_num=" + num + "&readcnt=f";
        br.setBoard_num(num);
        br.setMember_id(login);

        BoardMybatisDao dao = new BoardMybatisDao(); // DAO 객체 생성 (경로는 실제 DAO 클래스 경로로 변경해야 함)
        int check = dao.checkRecommend(br);

        if (check == 0) {
            dao.recommend(br);
            dao.updaterecommend(num);
            msg = "추천이 완료되었습니다!";
        } else {
            dao.unrecommend(br);
            dao.downrecommend(num);
            msg = "추천이 취소되었습니다.";
        }
    }

    response.getWriter().write(msg);
%>