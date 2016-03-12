package lee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;

/**
 * Created by liuyang on 2016/3/12.
 */
@WebServlet(name = "upload",urlPatterns = {"/upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        res.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out=res.getWriter();
        String form=null;

        String filename=req.getParameter("name");
       Part part=req.getPart("file");//必须HttpServletRequest才能getpart
        out.print("上传文件类型为："+part.getContentType()+"<br/>");
        out.print("上传文件大小为："+part.getSize()+"<br/>");

        Collection<String> headerNames=part.getHeaderNames();
        for (String headerName:headerNames)
        {
            out.print(headerName + "----->" + part.getHeader(headerName) + "<br/>");
           System.out.println(part.getHeader(headerName));
            if (part.getHeader(headerName).toString().contains("filename"))
            {
                form=part.getHeader(headerName);
                form=form.substring(form.lastIndexOf("=")+2,form.length()-1);
                //System.out.println(form);
               // form=form.split(".")[1];
            }

        }

        part.write(getServletContext().getRealPath("/uploadFiles")+"\\"+filename+form);
    }
}
