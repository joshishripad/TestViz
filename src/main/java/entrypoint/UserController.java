package entrypoint;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action != null && "ConnectDB".equals(action)) {
            InputStream in = null;
            try {
                PrintWriter pw = response.getWriter();
                pw.println("Get Request success from Servlet.");
                return;
            } catch (Exception ee) {

            }
            response.getWriter().println("");
            return;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && ("TestConn".equals(action) || "SaveConn".equals(action))) {
            String status = "";
            String url = request.getParameter("db_url");
            try {
                String path = getServletContext().getRealPath("/resources/dbConnection.properties");
                FileOutputStream outputStream = new FileOutputStream(path);
                status = "SUCCESS";
                System.out.println("dbConnection Properties file Saved......");
            } catch (Exception e) {
                status = e.toString();
            }
        }
        response.getWriter().print("Post Request Success");
        return;
    }
}

