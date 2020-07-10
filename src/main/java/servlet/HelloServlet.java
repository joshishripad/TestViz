package servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
        resp.setHeader("Content-Type", getServletContext().getMimeType(imgFile.getName()));
        resp.setHeader("Content-Length", String.valueOf(imgFile.length()));
        resp.setHeader("Content-Disposition", "inline; filename=\"" + imgFile.getName() + "\"");
        Files.copy(imgFile.toPath(), out);
        out.flush();
        out.close();
    }

}
