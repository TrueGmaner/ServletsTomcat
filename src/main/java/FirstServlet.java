import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/firstWay")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String first = req.getParameter("param1");
        String second = req.getParameter("param2");
        StringBuffer stringBuffer = new StringBuffer("\n");
        req.getReader()
                .lines()
                .forEach(x->stringBuffer.append(x).append("\n"));
        out.println("<html>");
        out.println("<head><title>Hello Servlet</title></head>");
        out.println("<body>");
        out.printf("<h1>first = %s, second = %s</h1>", first, second);
        out.println("<p>This is a simple servlet example.</p>");
        out.printf("<h2>bodyData2 = %s</h2>", stringBuffer);
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>Hello Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>doPost text</h1>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
