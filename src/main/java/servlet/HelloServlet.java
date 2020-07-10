package servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/hello"}
)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        BufferedImage joinedImg=null;
        File imgFile= new File (getServletContext().getRealPath("/resources/sampleCar.png"));
        ImageIO.write(joinedImg, "png", imgFile);
        ByteArrayOutputStream imgBytes = new ByteArrayOutputStream();
        ImageIO.write(joinedImg, "png", imgBytes);
        out.write(imgBytes.toByteArray());
        out.flush();
        out.close();
    }

}
