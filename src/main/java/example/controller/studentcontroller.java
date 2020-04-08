package example.controller;

import example.beans.Submit;
import example.daos.StudentD;
import example.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

        //读取配置文件实例化一个IOC容器
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取对象
        Student t=(Student)context.getBean("student");
        t.setSname(sname);
        t.setSusername(susername);
        t.setSpassword(spassword);
//        Student t=new Student(sname,susername,spassword);
        td.add(t);
        request.getRequestDispatcher( "/statics/submitsuccess.jsp").forward(request,response);
    }

}

