import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ExemploServlet", urlPatterns = "/calc")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String peso = req.getParameter("peso");
        String altura = req.getParameter("altura");

        Double imc = Double.parseDouble(peso) / (Double.parseDouble(altura) * Double.parseDouble(altura));
        req.setAttribute("imc", String.format("%.2f %%", imc));
        resp.setHeader("imc", String.format("%.2f", imc));
        req.getRequestDispatcher("/index1.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index1.jsp").forward(req, resp);
    }
}
