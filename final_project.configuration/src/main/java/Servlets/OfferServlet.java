package Servlets;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listings")
public class ListingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implement logic to retrieve listings from the database
        // For demonstration, I'll just return a sample JSON response

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("[{\"listingId\":1,\"cityId\":1,\"categoryId\":1,\"agentId\":1,\"bedrooms\":2,\"bathrooms\":2,\"squareFootage\":1500,\"price\":250000.00}]");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implement logic to create a new listing in the database
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implement logic to update an existing listing in the database
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implement logic to delete an existing listing from the database
    }
}