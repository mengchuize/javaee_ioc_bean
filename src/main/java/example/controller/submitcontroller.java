package example.controller;

import example.daos.StudentD;
import example.daos.SubmitD;
import example.model.Student;
import example.model.Submit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/submit")
public class submitcontroller {

    @RequestMapping(value = "/sb", method = RequestMethod.POST)
    public void teacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String hname = request.getSession().getAttribute("hname").toString();
        String sname = request.getSession().getAttribute("sname").toString();
        SubmitD td=new SubmitD();
        Submit t=new Submit(hname,sname,text);
        td.add(t);
        request.getRequestDispatcher( "/statics/submitsuccess.jsp").forward(request,response);
    }

}