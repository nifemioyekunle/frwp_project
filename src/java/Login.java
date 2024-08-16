import JavaCode.DatabaseConnection;
import JavaCode.InventoryDAO;
import JavaCode.InventoryItem;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Hash and encode the password before comparing it with the database
            String hashedPassword = hashPassword(password);

            // Use your DatabaseConnection class to get a connection
            conn = DatabaseConnection.getInstance().getConnection();

            // Prepare SQL query to check if user exists
            String sql = "SELECT * FROM users WHERE username=? AND password=? AND role=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);  // Compare hashed password
            pstmt.setString(3, userType);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                // User exists, redirect based on user type
                if ("consumer".equals(userType)) {
                    List<InventoryItem> inventoryItems = InventoryDAO.getAllInventoryItems();
                    request.setAttribute("inventoryItems", inventoryItems);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Consumers.jsp");
                    dispatcher.forward(request, response);
                } else if ("retailer".equals(userType)) {
                    request.getSession().setAttribute("userId", rs.getInt("user_id"));
                    response.sendRedirect("Retailers.jsp");
                } else if ("charitableOrganization".equals(userType)) {
                    response.sendRedirect("CharitableOrganizations.jsp");
                } else {
                    out.println("Unknown user type");
                }
            } else {
                // User not found or password incorrect
                out.println("Invalid username, password, or user type. Please try again.");
            }

        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close(); // Ensure the connection is closed here
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to hash the password
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}
