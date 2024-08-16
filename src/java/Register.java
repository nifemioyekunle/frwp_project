import JavaCode.DatabaseConnection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Connection;
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
import java.sql.ResultSet;

@WebServlet("/Register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("reg_username");
        String email = request.getParameter("reg_email");
        String password = request.getParameter("reg_password");
        String userType = request.getParameter("userType");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Hash the password before storing it
            String hashedPassword = hashPassword(password);

            // Get connection using the DatabaseConnection class
            conn = DatabaseConnection.getInstance().getConnection();

            // Insert user into the database
            pstmt = conn.prepareStatement("INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, hashedPassword);
            pstmt.setString(4, userType);

            int rowsInserted = pstmt.executeUpdate();

            // Check if the user was successfully inserted
            if (rowsInserted > 0) {
                // Redirect to the login page (index.html)
                response.sendRedirect("index.html");
            } else {
                out.println("Failed to register user.");
            }
        } catch (SQLException e) {
            out.println("Database error: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            out.println("Password hashing error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
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
