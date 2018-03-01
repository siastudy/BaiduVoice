package com.baidu.reco;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    private String message;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        ServletConfig config = this.getServletConfig();
//        String charset =  config.getInitParameter("charset");
//        response.setContentType("text/html;charset="+charset);
//        response.getWriter().println("<html><h2>sevlet gened page</h2></html>");
        System.out.println("===========hello=========");
        request.getRequestDispatcher("/index.jsp");
    }
}