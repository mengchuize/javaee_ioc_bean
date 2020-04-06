package example.controller;

import example.daos.StudentD;
import example.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/student")
public class studentcontroller {

    @RequestMapping(value = "/st", method = RequestMethod.POST)
    public void teacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname = request.getParameter("sname");
        String susername = request.getParameter("susername");
        String spassword = request.getParameter("spassword");

        StudentD td=new StudentD();
        Student t=new Student(sname,susername,spassword);
        td.add(t);
        request.getRequestDispatcher( "/statics/submitsuccess.jsp").forward(request,response);
    }

}

