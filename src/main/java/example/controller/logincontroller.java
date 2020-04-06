package example.controller;

import example.daos.StudentD;
import example.daos.TeacherD;
import example.model.Student;
import example.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class logincontroller {

    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public void teacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("tusername");
        String password = request.getParameter("tpassword");

        System.out.println("tusername"+username);
        System.out.println("tpassword"+password);

        TeacherD td=new TeacherD();
        Teacher t=td.search(username);
        System.out.println(username+"$search$"+t.getTpassword());
        System.out.println(username+"$get$"+password);
        System.out.println("t.getTpassword().equals(password):"+t.getTpassword().equals(password));
        if(t.getTpassword().equals(password)){
            System.out.println("yes");
            request.setAttribute( "tusername ",username);
//            return "/teacher.jsp?tname="+username;
            request.getRequestDispatcher( "/statics/teacher.jsp?tname="+username).forward(request,response);
        }else{
            System.out.println("no");
//            return "/failed.jsp";
            request.getRequestDispatcher( "/statics/failed.jsp").forward(request,response);
        }
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public void student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("susername");
        String password = request.getParameter("spassword");
        StudentD td=new StudentD();
        Student t=td.search(username);
        if(t.getSpassword().equals(password)){
            System.out.println("yes");
            request.setAttribute( "susername ",username);
            request.getRequestDispatcher( "/statics/student.jsp").forward(request,response);
        }else{
            System.out.println("no");
            request.getRequestDispatcher( "/statics/failed.jsp").forward(request,response);
        }
    }
}

