package com.apeman1024.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.apeman1024.Ichange.IImgChange;
import com.apeman1024.change.ImgChange;
import com.apeman1024.entity.Car;


@WebServlet("/details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Details() {
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
			String id = request.getParameter("id");
			IImgChange img=new ImgChange();
			Map<String, Object >map=img.getCom(id);
			response.getWriter().print(new JSONObject(map).toString());
		}
		else if(pa.equals("2")){
			String obj=request.getParameter("obj");
			try {
				JSONObject json= new JSONObject(obj);
				Car car=new Car();
				car.setBool(json.getBoolean("bool"));
				car.setId(json.getString("id"));
				car.setName(json.getString("name"));
				car.setNum(json.getInt("num"));
				car.setQian(json.getDouble("qian"));
				car.setSrc(json.getString("src"));
				car.setTitle(json.getString("title"));
				car.setUsername(json.getString("username"));
				car.setXian(json.getDouble("xian"));
				IImgChange img=new ImgChange();
				boolean bool=img.addCar(car);
				response.getWriter().print(bool);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

}