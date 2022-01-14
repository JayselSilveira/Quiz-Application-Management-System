package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateQuizDao {
    
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_project?useSSL=true";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String SELECT_TEACHER_QUERY = "SELECT * FROM teachers WHERE email_id = ?";
    private static final String SELECT_QUIZNAME_QUERY = "SELECT * FROM quiz WHERE teacher = ? AND teacher_email =?";
    private static final String INSERT_QUIZ_QUERY = "INSERT INTO quiz (quiz_name, total_questions, question_number, teacher, teacher_email, description, diff_level, question, option1, option2, option3, option4, answer) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    public String getTeacherName(String emailId) throws SQLException {
        String teacher = "";
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEACHER_QUERY)) {
            preparedStatement.setString(1, emailId);
            //System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (emailId.equals(resultSet.getString("email_id"))) {
                    teacher = resultSet.getString("full_name");
                    System.out.println(teacher);
                }
            }
        }
        return teacher;
    }
    
    public boolean verify(String quizName, String teacher, String emailId) throws SQLException {
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUIZNAME_QUERY)) {
            preparedStatement.setString(1, teacher);
            preparedStatement.setString(2, emailId);
            //System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (quizName.equals(resultSet.getString("quiz_name")) && teacher.equals(resultSet.getString("teacher")) && (emailId == null ? resultSet.getString("teacher_email") == null : emailId.equals(resultSet.getString("teacher_email")))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void insertQuiz(String quizName, int totalQuestions, int questionNumber, String teacher, String teacherEmailId, String description, String difficulty, String question, String option1, String option2, String option3, String option4, String answer) throws SQLException {
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUIZ_QUERY)) {
            preparedStatement.setString(1, quizName);
            preparedStatement.setInt(2, totalQuestions);
            preparedStatement.setInt(3, questionNumber);
            preparedStatement.setString(4, teacher);
            preparedStatement.setString(5, teacherEmailId);
            preparedStatement.setString(6, description);
            preparedStatement.setString(7, difficulty);
            preparedStatement.setString(8, question);
            preparedStatement.setString(9, option1);
            preparedStatement.setString(10, option2);
            preparedStatement.setString(11, option3);
            preparedStatement.setString(12, option4);
            preparedStatement.setString(13, answer);
            //System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
