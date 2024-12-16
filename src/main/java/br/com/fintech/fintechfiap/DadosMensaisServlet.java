package br.com.fintech.fintechfiap;

import dao.ReceitaDAO;
import dao.DespesaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/DadosMensaisServlet")
public class DadosMensaisServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReceitaDAO receitaDAO = new ReceitaDAO();
        DespesaDAO despesaDAO = new DespesaDAO();

        Map<String, Double> receitasMensais = receitaDAO.getReceitasMensais();
        Map<String, Double> despesasMensais = despesaDAO.getDespesasMensais();

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("labels", receitasMensais.keySet());
        jsonResponse.put("receitas", new JSONArray(receitasMensais.values()));
        jsonResponse.put("despesas", new JSONArray(despesasMensais.values()));

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
    }
}
