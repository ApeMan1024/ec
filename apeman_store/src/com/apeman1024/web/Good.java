package com.apeman1024.web;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.apeman1024.Ichange.IMineChange;

import com.apeman1024.change.MineChange;
import com.apeman1024.entity.Indent;



@WebServlet("/good")
public class Good extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Good() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		String pa = request.getParameter("flag");
		response.setContentType("text/html;charset=utf-8");
		if(pa.equals("1")) {
			IMineChange mine=new MineChange();
			List<Indent> list =mine.getIndent(request.getParameter("username"));
			response.getWriter().print(new JSONArray(list).toString());
		}
		else if(pa.equals("2")) {
			IMineChange mine=new MineChange();
			boolean bool=mine.delIndent(request.getParameter("username"),request.getParameter("number"));
			response.getWriter().print(bool);
		}
		else if(pa.equals("3")) {
			IMineChange mine=new MineChange();
			boolean bool=mine.del(request.getParameter("username"));
			response.getWriter().print(bool);
		}
	}

}