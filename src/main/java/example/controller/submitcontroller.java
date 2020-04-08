package example.controller;

import example.beans.Homework;
import example.daos.HomeworkD;
import example.daos.SubmitD;
import example.beans.Submit;
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
@RequestMapping("/submit")
public class submitcontroller {

    @RequestMapping(value = "/sb", method = RequestMethod.POST)
    public void teacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String hname = request.getSession().getAttribute("hname").toString();
        String sname = request.getSession().getAttribute("sname").toString();
        SubmitD td=new SubmitD();
        //读取配置文件实例化一个IOC容器
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取对象
        Submit t=(Submit)context.getBean("submit");
        t.setHname(hname);
        t.setSname(sname);
        t.setShis(text);
//        Submit t=new Submit(hname,sname,text);
        td.add(t);
        request.getRequestDispatcher( "/statics/submitsuccess.jsp").forward(request,response);
    }

}