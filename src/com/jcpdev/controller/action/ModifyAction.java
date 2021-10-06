package com.jcpdev.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.FreeboardDao;
import com.jcpdev.dto.Freeboard;

public class ModifyAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int pageNo = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		String subject = request.getParameter("subject");
//		String password = request.getParameter("password");
		String content = request.getParameter("content");
//		String ip = request.getRemoteAddr();
		
		Freeboard dto = new Freeboard();
//		dto.setIp(ip);
//		dto.setPassword(password);
		dto.setIdx(idx);
		dto.setSubject(subject);
		dto.setContent(content);
		String alert = request.getParameter("alert");
		if (alert!=null) request.setAttribute("alert", "y");  
		
		FreeboardDao dao = FreeboardDao.getInstance();
		dao.update(dto);
//		response.sendRedirect("updateAction.jsp?update=&idx="+idx);
//		response.sendRedirect("detailAction.jsp?update=&idx=" + idx + "&page="+pageNo);
	
		ActionForward forward = new ActionForward();
		forward.isRedirect = true;
		forward.url = "detail.do?update=&idx=" + idx + "&page="+pageNo;
		return forward;
	}
	
	
}
