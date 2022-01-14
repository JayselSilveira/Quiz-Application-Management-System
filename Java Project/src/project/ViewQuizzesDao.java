package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ViewQuizzesDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_project?useSSL=true";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String SELECT_QUERY = "SELECT DISTINCT quiz_name, teacher, teacher_email FROM quiz";
    private static final String SELECT_INSTITUTE_QUERY = "SELECT designation, institute FROM teachers WHERE email_id = ?";

    Group root;
    Stage stage;

    public boolean display(String emailId, String user) throws SQLException {

        int x = 0, y = 70, count = 0;
        String quizName, teacher, teacherEmailId, designation = "", institute = "";

        stage = new Stage();

        Label l1 = new Label("VIEW QUIZZES");
        l1.setTranslateX(800);
        l1.setTranslateY(50);
        l1.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-underline: true; -fx-text-fill: AQUA");

        Button btn = new Button("BACK");
        btn.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn.setTranslateX(1600);
        btn.setTranslateY(50);
        btn.setPrefSize(220, 70);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        }
        );

        root = new Group(l1, btn);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);
        stage.setTitle("View Quizzes");
        stage.setScene(scene);

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                quizName = resultSet.getString("quiz_name");
                teacher = resultSet.getString("teacher");
                teacherEmailId = resultSet.getString("teacher_email");

                try (Connection connection1 = DriverManager
                        .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(SELECT_INSTITUTE_QUERY)) {
                    preparedStatement1.setString(1, teacherEmailId);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    while (resultSet1.next()) {
                        designation = resultSet1.getString("designation");
                        institute = resultSet1.getString("institute");
                    }
                }

                //System.out.println("\tQuiz Name: " + quizName + "\n\nQuiz By:\nTeacher's name: " + teacher);
                String val = "    Quiz Name: " + quizName + "\n\n\nQuiz By: " + designation + " " + teacher + "\n\nInstitute: " + institute;
                String val1 = quizName;
                String val2 = teacher;
                String val3 = teacherEmailId;
                if (count == 0) {
                    x = 20;
                } else {
                    x = x + 380;
                }
                draw_rect(x, y, val, val1, val2, val3, emailId, user);
                count++;
                if (count == 5) {
                    y = y + 300;
                    count = 0;
                }
            }
            scene.setRoot(root);
            stage.show();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }

    public void draw_rect(int a, int b, String value, String value1, String value2, String value3, String emailId, String user) {
        //rectangle
        Rectangle r = new Rectangle();
        r.setX(a);
        r.setY(b + 100);
        r.setWidth(350);
        r.setHeight(250);
        r.setArcWidth(30);
        r.setArcHeight(30);
        r.setStyle("-fx-fill: AQUA ; -fx-stroke: white; -fx-stroke-width: 5");
        root.getChildren().add(r);

        //text
        Label l = new Label(value);
        l.setTranslateX(a + 40);
        l.setTranslateY(b + 130);
        l.setStyle("-fx-font-size: 18; -fx-font-weight: bold");
        root.getChildren().addAll(l);

        r.setOnMouseClicked(new EventHandler<MouseEvent>() {

            String w = l.getText();

            @Override
            public void handle(MouseEvent event) {
                //System.out.println("Clicked" + value1);
                //System.out.println("Hii " + value2);
                StudentStartQuiz ssq = new StudentStartQuiz();
                try {
                    stage.close();
                    ssq.start(value1, value2, value3, emailId, user);
                } catch (Exception ex) {
                    Logger.getLogger(ViewQuizzesDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
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
