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

public class StudentResultDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_project?useSSL=true";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String INSERT_QUERY = "INSERT INTO results (student_email, quiz_name, teacher, teacher_email, obtained_marks, total_marks) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM results WHERE student_email = ?";
    private static final String COUNT_QUERY = "SELECT * FROM results WHERE student_email = ? AND quiz_name = ? AND teacher = ? AND teacher_email = ?";
    private static final String GET_NAME_QUERY = "SELECT * FROM students WHERE email_id = ?";

    public void insertRecord(String studentEmail, String quizName, String teacher, String teacherEmailId, int obtainedMarks, int totalMarks) throws SQLException {
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, studentEmail);
            preparedStatement.setString(2, quizName);
            preparedStatement.setString(3, teacher);
            preparedStatement.setString(4, teacherEmailId);
            preparedStatement.setInt(5, obtainedMarks);
            preparedStatement.setInt(6, totalMarks);
            //System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    Stage stage = new Stage();
    String quizName, teacher, total, teacherEmailId, score, value, val1, val2;
    int count = 0, currHighest, nextHighest, highest, a, b, j = 1, temp1 = 0, temp2 = 0;
    Label l;
    Group root;

    public boolean display(String emailId) throws SQLException {

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, emailId);
            //System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            try (Connection connection1 = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                    PreparedStatement preparedStatement1 = connection1.prepareStatement(GET_NAME_QUERY)) {
                preparedStatement1.setString(1, emailId);
                //System.out.println(preparedStatement1);
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                while (resultSet1.next()) {
                    l = new Label(resultSet1.getString("full_name") + "'s Results");
                }
            }

            l.setTranslateX(750);
            l.setTranslateY(35);
            l.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-underline: true; -fx-text-fill: AQUA");

            root = new Group(l);

            int x = 100;
            value = "SERIAL NUMBER";
            for (int i = 1; i <= 7; i++) {
                Rectangle r = new Rectangle();
                r.setX(x);
                r.setY(130);
                r.setStyle("-fx-fill: WHITE; -fx-stroke: AQUA; -fx-stroke-width: 5;");
                r.setWidth(240);
                r.setHeight(45);
                root.getChildren().add(r);

                Label lt = new Label(value);
                lt.setTranslateX(x + 50);
                lt.setTranslateY(140);
                lt.setStyle("-fx-font-size:18; -fx-font-weight: bold;");
                root.getChildren().add(lt);
                if (i == 1) {
                    value = "QUIZ NAME";
                }
                if (i == 2) {
                    value = "TEACHER";
                }
                if (i == 3) {
                    value = "SCORE";
                }
                if (i == 4) {
                    value = "TOTAL ATTEMPTS";
                }
                if (i == 5) {
                    value = "HIGHEST SCORE";
                }
                if (i == 6) {
                    value = "MAXIMUM SCORE";
                }
                x = x + 250;
            }

            while (resultSet.next()) {
                quizName = resultSet.getString("quiz_name");
                teacher = resultSet.getString("teacher");
                teacherEmailId = resultSet.getString("teacher_email");
                score = resultSet.getString("obtained_marks");
                total = String.valueOf(resultSet.getInt("total_marks"));

                try (Connection connection1 = DriverManager
                        .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(COUNT_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE)) {
                    preparedStatement1.setString(1, emailId);
                    preparedStatement1.setString(2, quizName);
                    preparedStatement1.setString(3, teacher);
                    preparedStatement1.setString(4, teacherEmailId);
                    //System.out.println(preparedStatement1);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    count = 0;

                    while (resultSet1.next()) {
                        count++;
                        //val1 = resultSet1.getString("quiz_name");

                        currHighest = resultSet1.getInt("obtained_marks");
                        if (count == 1) {
                            highest = currHighest;
                        }
                        //System.out.println("currHighest = " + currHighest);
                        if (resultSet1.next()) {
                            nextHighest = resultSet1.getInt("obtained_marks");
                            //val2 = resultSet1.getString("quiz_name");
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

                a = 100;
                if (j == 1) {
                    b = 190;
                }
                for (j = 1; j <= 7; j++) {
                    if (j == 1) {

                        //System.out.println(val1);
                        //System.out.println(val2);
                        //if (val1 == null ? val2 == null : val1.equals(val2)) {
                        temp1++;
                        value = String.valueOf(temp1);
                        //    System.out.println(value);
                        //} else {
                        //    val2 = val1;
                        //    temp2++;
                        //    value = String.valueOf(temp2);
                        //    System.out.println(value);
                        //}
                    }
                    if (j == 2) {
                        value = quizName;
                    }
                    if (j == 3) {
                        value = teacher;
                    }
                    if (j == 4) {
                        value = String.valueOf(score);
                    }
                    if (j == 5) {
                        value = String.valueOf(count);
                    }
                    if (j == 6) {
                        value = String.valueOf(highest);
                    }
                    if (j == 7) {
                        value = total;
                    }

                    Rectangle r = new Rectangle();
                    r.setX(a);
                    r.setY(b);
                    r.setStyle("-fx-fill: WHITE; -fx-stroke: AQUA; -fx-stroke-width: 2;");
                    r.setWidth(240);
                    r.setHeight(45);
                    root.getChildren().add(r);

                    Label lt = new Label(value);
                    lt.setTranslateX(a + 50);
                    lt.setTranslateY(b + 10);
                    lt.setStyle("-fx-font-size:18; -fx-font-weight: bold;");
                    root.getChildren().add(lt);

                    a = a + 250;
                    if (j == 7) {
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
