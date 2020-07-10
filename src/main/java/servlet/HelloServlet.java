package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/image"}
)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(req,response);
      /*  ServletContext sc = getServletContext();
        String action=req.getParameter("action");
        String imgPath="/images/sampleCar.png";
        if (action!=null && !action.isEmpty()){
            imgPath="/images/BlueCar.PNG";
        }

        try (InputStream is = sc.getResourceAsStream(imgPath)) {

            // it is the responsibility of the container to close output stream
            OutputStream os = response.getOutputStream();

            if (is == null) {

                response.setContentType("text/plain");
                os.write("Failed to send image".getBytes());
            } else {

                byte[] buffer = new byte[1024];
                int bytesRead;

                response.setContentType("image/png");

                while ((bytesRead = is.read(buffer)) != -1) {

                    os.write(buffer, 0, bytesRead);
                }
            }
        }*/
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
       ServletInputStream inputStream= req.getInputStream();

        BufferedReader bufferedReader=null;
        StringBuilder stringBuilder=new StringBuilder();

        Map<String, String[]> parameterMap=req.getParameterMap();
        parameterMap.forEach((key,val)->{
            stringBuilder.append(key).append(":").append(val).append("\n");
        });
        stringBuilder.append("\nRequest Body:\n");
        if (inputStream != null) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line=null;
            while ((line = bufferedReader.readLine()) !=null) {
                stringBuilder.append(line).append("\n");

            }
        } else {
            stringBuilder.append("");
        }

        response.getWriter().print(stringBuilder.toString());
    }

}


