package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TeacherResultDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_project?useSSL=true";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String SELECT_QUERY = "SELECT * FROM results WHERE teacher = ? AND teacher_email = ?";
    private static final String COUNT_QUERY = "SELECT * FROM results WHERE student_email = ? AND quiz_name = ? AND teacher = ? AND teacher_email = ?";
    private static final String GET_TEACHER_NAME_QUERY = "SELECT * FROM teachers WHERE email_id = ?";
    private static final String GET_STUDENT_NAME_QUERY = "SELECT * FROM students WHERE email_id = ?";

    Stage stage = new Stage();
    String quizName, teacher, total, score, value, val1, val2, student, institute, studentEmail;
    int count = 0, currHighest, nextHighest, highest, a, b, j = 1, temp1 = 0;
    Label l;
    Group root;

    public boolean display(String emailId) throws SQLException {

        try (Connection connection1 = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement1 = connection1.prepareStatement(GET_TEACHER_NAME_QUERY)) {
            preparedStatement1.setString(1, emailId);
            //System.out.println(preparedStatement1);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                teacher = resultSet1.getString("full_name");
            }
        }

        l = new Label("Results of quizzes by " + teacher);
        l.setTranslateX(750);
        l.setTranslateY(35);
        l.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-underline: true; -fx-text-fill: AQUA");

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, teacher);
            preparedStatement.setString(2, emailId);
            //System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            root = new Group(l);

            int x = 10;
            value = "SERIAL NUMBER";
            for (int i = 1; i <= 8; i++) {
                Rectangle r = new Rectangle();
                r.setX(x);
                r.setY(130);
                r.setStyle("-fx-fill: WHITE; -fx-stroke: AQUA; -fx-stroke-width: 5;");
                r.setWidth(230);
                r.setHeight(45);
                root.getChildren().add(r);

                Label lt = new Label(value);
                lt.setTranslateX(x + 40);
                lt.setTranslateY(140);
                lt.setStyle("-fx-font-size:18; -fx-font-weight: bold;");
                root.getChildren().add(lt);
                if (i == 1) {
                    value = "QUIZ NAME";
                }
                if (i == 2) {
                    value = "STUDENT";
                }
                if (i == 3) {
                    value = "INSTITUTE";
                }
                if (i == 4) {
                    value = "SCORE";
                }
                if (i == 5) {
                    value = "TOTAL ATTEMPTS";
                }
                if (i == 6) {
                    value = "HIGHEST SCORE";
                }
                if (i == 7) {
                    value = "MAXIMUM SCORE";
                }
                x = x + 240;
            }

            while (resultSet.next()) {
                quizName = resultSet.getString("quiz_name");
                studentEmail = resultSet.getString("student_email");
                score = resultSet.getString("obtained_marks");

                try (Connection connection1 = DriverManager
                        .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(GET_STUDENT_NAME_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE)) {
                    preparedStatement1.setString(1, studentEmail);
                    //System.out.println(preparedStatement1);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();

                    while (resultSet1.next()) {
                        student = resultSet1.getString("full_name");
                        institute = resultSet1.getString("institute");
                    }
                }

                try (Connection connection1 = DriverManager
                        .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(COUNT_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE)) {
                    preparedStatement1.setString(1, studentEmail);
                    preparedStatement1.setString(2, quizName);
                    preparedStatement1.setString(3, teacher);
                    preparedStatement1.setString(4, emailId);
                    //System.out.println(preparedStatement1);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    count = 0;

                    while (resultSet1.next()) {
                        count++;
                        total = String.valueOf(resultSet1.getInt("total_marks"));

                        currHighest = resultSet1.getInt("obtained_marks");
                        if (count == 1) {
                            highest = currHighest;
                        }
                        //System.out.println("currHighest = " + currHighest);
                        if (resultSet1.next()) {
                            nextHighest = resultSet1.getInt("obtained_marks");
                        } else {
                            nextHighest = 0;
                        }
                        //System.out.println("nextHighest = " + nextHighest);
                        if (highest < nextHighest) {
                            highest = nextHighest;
                        }

                        //System.out.println("count = " + count);
                        //System.out.println("highest = " + highest);
                        resultSet1.previous();
                    }
                }

                a = 10;
                if (j == 1) {
                    b = 190;
                }
                for (j = 1; j <= 8; j++) {
                    if (j == 1) {
                        temp1++;
                        value = String.valueOf(temp1);
                    }
                    if (j == 2) {
                        value = quizName;
                    }
                    if (j == 3) {
                        value = student;
                    }
                    if (j == 4) {
                        value = institute;
                    }
                    if (j == 5) {
                        value = String.valueOf(score);
                    }
                    if (j == 6) {
                        value = String.valueOf(count);
                    }
                    if (j == 7) {
                        value = String.valueOf(highest);
                    }
                    if (j == 8) {
                        value = total;
                    }

                    Rectangle r = new Rectangle();
                    r.setX(a);
                    r.setY(b);
                    r.setStyle("-fx-fill: WHITE; -fx-stroke: AQUA; -fx-stroke-width: 2;");
                    r.setWidth(230);
                    r.setHeight(45);
                    root.getChildren().add(r);

                    Label lt = new Label(value);
                    lt.setTranslateX(a + 40);
                    lt.setTranslateY(b + 10);
                    lt.setStyle("-fx-font-size:18; -fx-font-weight: bold;");
                    root.getChildren().add(lt);

                    a = a + 240;
                    if (j == 8) {
                        b = b + 50;
                    }
                }
            }

            Button btn = new Button("BACK");
            btn.setTranslateX(1650);
            btn.setTranslateY(30);
            btn.setPrefSize(220, 70);
            btn.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage.close();
                }
            }
            );
            root.getChildren().add(btn);

            Scene scene = new Scene(root, 3050, 1100, Color.BLACK);
            stage.setTitle("View Results");
            scene.setRoot(root);
            stage.setScene(scene);
            stage.show();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return false;
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
