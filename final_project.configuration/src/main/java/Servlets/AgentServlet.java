package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import core.Agent;
import core.AgentDao;
import core.AgentDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/agents") // Make sure this matches the URL pattern you are using in your browser
public class AgentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AgentDao agentDao;

    @Override
    public void init() {
        // Ensure your database URL is correct. The 'final_project' should be the name of your database.
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/final_projectconfig", "root", "PoPo2222@.com");

        // Instantiate your database connection and DAO here.
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        agentDao = new AgentDaoImpl(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Agent> agents = agentDao.getAllAgents();
            System.out.println("Number of agents: " + agents.size());
            agents.forEach(agent -> {
                System.out.println("Agent ID: " + agent.getAgentId());
                System.out.println("Agent Name: " + agent.getAgentName());
                System.out.println("Contact Information: " + agent.getContactInformation());
                System.out.println("Email: " + agent.getEmail());
            });

            request.setAttribute("agents", agents);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Agent.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Properly handle the SQL exception
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error accessing the database");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/error.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Properly handle any other exceptions
            e.printStackTrace();
            request.setAttribute("errorMessage", "Unexpected error occurred");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}