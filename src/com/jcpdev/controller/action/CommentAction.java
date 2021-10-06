package com.jcpdev.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.CommentDao;
import com.jcpdev.dto.Comment;

public class CommentAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int mref;
		request.setCharacterEncoding("UTF-8");		
		CommentDao dao = CommentDao.getInstance();
		int pageNo = Integer.parseInt(request.getParameter("page"));
		if(request.getParameter("del") != null){		//삭제
			int cmtidx = Integer.parseInt(request.getParameter("cmtidx"));
			int idx = Integer.parseInt(request.getParameter("idx"));
			dao.delete(cmtidx);
			mref=idx;
		}else{		//댓글 추가
		mref = Integer.parseInt(request.getParameter("mref"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();	
		
		Comment dto = new Comment(0,mref,name,password,content,null,ip);
		dao.insert(dto);
		}
		
		dao.updateCountAll(mref);
		ActionForward forward = new ActionForward();
		forward.isRedirect = true;
		forward.url = "detail.do?page=" + pageNo + "&idx=" + mref;
		return forward;
	}
	
	
}
