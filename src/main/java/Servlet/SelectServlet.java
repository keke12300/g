package Servlet;

import Service.BookService;
import Service.impl.BookServiceImpl;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;


/**
 * Created by LENOVO on 2019-01-15.
 */
@WebServlet(name = "SelectServlet",urlPatterns = "/pp")
public class SelectServlet extends HttpServlet {
    BookService bookService=new BookServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type=request.getParameter("type");
        System.out.println(type);
          if (type==null) {
              sel(request, response);
          }else {
              switch (type){
                  case "sel":
                      sel(request,response);
                      break;
                  case "add":
                      add(request,response);
                      break;
                  case "del":
                      del(request,response);
                      break;
              }
          }
    }
    protected void sel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> list=bookService.selectAll();
                request.getSession().setAttribute("list",list);
                response.sendRedirect("select.jsp");
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
            Book book=new Book();
            book.setType(Integer.valueOf(request.getParameter("ss")));
            book.setName(request.getParameter("xinzheng"));
            book.setTime(Date.valueOf(request.getParameter("riqi")));
            book.setAuthor(request.getParameter("zuoze"));
            int x=bookService.add(book);
            if(x==1){
              sel(request,response);
              out.flush();
              out.close();
            }else {
                response.sendRedirect("add.jsp");
            }

    }

    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info=request.getParameter("id");
        System.out.println(info);
        if(info!=null){
            int id=Integer.valueOf(info);
            int r=bookService.delete(id);
            boolean isok=false;
            if(r!=0){
                isok=true;
            }
            PrintWriter out= response.getWriter();
            out.print(isok);
            out.flush();
            out.close();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
