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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import static project.Project.infoBox;

public class EditQuizDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_project?useSSL=true";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String UPDATE_QUERY = "UPDATE quiz SET question = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ?, answer = ? WHERE quiz_name = ? AND question_number = ? AND teacher = ?";
    private static final String SELECT_QUERY = "SELECT total_questions, question, option1, option2, option3, option4, answer FROM quiz WHERE quiz_name = ? AND question_number = ? AND teacher = ?";

    String val1, val2, selected, option1, option2, option3, option4, answer;
    int value3 = 2, temp = 0, totalQuestions = 0, questionNumber = 0;
    Boolean flag = false;
    Label l, q, l1, l2, l3, l4;
    Group root;
    Scene scene;

    public void edit(String question, String option1, String option2, String option3, String option4, String answer, String value1, int questionNumber, String value2) throws SQLException {

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, option1);
            preparedStatement.setString(3, option2);
            preparedStatement.setString(4, option3);
            preparedStatement.setString(5, option4);
            preparedStatement.setString(6, answer);
            preparedStatement.setString(7, value1);
            preparedStatement.setInt(8, questionNumber);
            preparedStatement.setString(9, value2);
            int resultSet = preparedStatement.executeUpdate();
            //System.out.println(preparedStatement);
            //preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public boolean display(String value1, String value2, int i, String emailId) throws SQLException {

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, value1);
            preparedStatement.setInt(2, i);
            preparedStatement.setString(3, value2);
            ResultSet resultSet = preparedStatement.executeQuery();
            //System.out.println(preparedStatement);
            Stage stage = new Stage();

            Label l = new Label("QUIZ NAME: " + value1);
            l.setTranslateX(800);
            l.setTranslateY(50);
            l.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-underline: true; -fx-text-fill: AQUA");

            Image img1 = new Image("project/quiz.png");
            ImageView view = new ImageView(img1);
            view.setX(50);
            view.setY(150);
            view.setFitHeight(750);
            view.setFitWidth(500);

            while (resultSet.next()) {
                totalQuestions = resultSet.getInt("total_questions");
                temp = questionNumber + 1;
                Label l1 = new Label("ENTER QUESTION " + temp + " :");
                l1.setTranslateX(800);
                l1.setTranslateY(200);
                l1.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

                TextField quest = new TextField(resultSet.getString("question"));
                quest.setTranslateX(1100);
                quest.setTranslateY(190);
                quest.setPrefSize(600, 30);
                quest.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26;");

                Label l2 = new Label("OPTION 1:");
                l2.setTranslateX(800);
                l2.setTranslateY(350);
                l2.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

                TextField op1 = new TextField(resultSet.getString("option1"));
                op1.setTranslateX(1000);
                op1.setTranslateY(340);
                op1.setPrefSize(200, 20);
                op1.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26");

                Label l3 = new Label("OPTION 2:");
                l3.setTranslateX(1400);
                l3.setTranslateY(350);
                l3.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

                TextField op2 = new TextField(resultSet.getString("option2"));
                op2.setTranslateX(1600);
                op2.setTranslateY(340);
                op2.setPrefSize(200, 20);
                op2.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26");

                Label l4 = new Label("OPTION 3:");
                l4.setTranslateX(800);
                l4.setTranslateY(500);
                l4.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

                TextField op3 = new TextField(resultSet.getString("option3"));
                op3.setTranslateX(1000);
                op3.setTranslateY(490);
                op3.setPrefSize(200, 20);
                op3.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26");

                Label l5 = new Label("OPTION 4:");
                l5.setTranslateX(1400);
                l5.setTranslateY(500);
                l5.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

                TextField op4 = new TextField(resultSet.getString("option4"));
                op4.setTranslateX(1600);
                op4.setTranslateY(490);
                op4.setPrefSize(200, 20);
                op4.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26");

                Label l6 = new Label("ENTER ANSWER :");
                l6.setTranslateX(800);
                l6.setTranslateY(650);
                l6.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

                answer = resultSet.getString("answer");

                RadioButton ans1 = new RadioButton("option1");
                ans1.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: White");
                ans1.setTranslateX(1100);
                ans1.setTranslateY(650);
                option1 = op1.getText();
                if (answer == null ? option1 == null : answer.equals(option1)) {
                    ans1.setSelected(true);
                    selected = op1.getText();
                }

                RadioButton ans2 = new RadioButton("option2");
                ans2.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: White");
                ans2.setTranslateX(1400);
                ans2.setTranslateY(650);
                option2 = op2.getText();
                if (answer == null ? option2 == null : answer.equals(option2)) {
                    ans2.setSelected(true);
                    selected = op2.getText();
                }

                RadioButton ans3 = new RadioButton("option3");
                ans3.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: White");
                ans3.setTranslateX(1100);
                ans3.setTranslateY(750);
                option3 = op3.getText();
                if (answer == null ? option3 == null : answer.equals(option3)) {
                    ans3.setSelected(true);
                    selected = op3.getText();
                }

                RadioButton ans4 = new RadioButton("option4");
                ans4.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: White");
                ans4.setTranslateX(1400);
                ans4.setTranslateY(750);
                option4 = op4.getText();
                if (answer == null ? option4 == null : answer.equals(option4)) {
                    ans4.setSelected(true);
                    selected = op4.getText();
                }

                ToggleGroup tg = new ToggleGroup();
                ans1.setToggleGroup(tg);
                ans2.setToggleGroup(tg);
                ans3.setToggleGroup(tg);
                ans4.setToggleGroup(tg);

                ans1.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        if (ans1.isSelected()) {
                            selected = op1.getText();
                        }
                    }
                });

                ans2.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        if (ans2.isSelected()) {
                            selected = op2.getText();
                        }
                    }
                });

                ans3.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        if (ans3.isSelected()) {
                            selected = op3.getText();
                        }
                    }
                });

                ans4.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        if (ans4.isSelected()) {
                            selected = op4.getText();
                        }
                    }
                });

                Button btn1 = new Button("SAVE");
                btn1.setTranslateX(1200);
                btn1.setTranslateY(850);
                btn1.setPrefSize(180, 50);
                btn1.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
                btn1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        questionNumber++;

                        Window owner = btn1.getScene().getWindow();

                        if (quest.getText().isEmpty()) {
                            Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                                    "Please enter a question");
                            return;
                        }
                        if (op1.getText().isEmpty()) {
                            Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                                    "Please enter the first option");
                            return;
                        }
                        if (op2.getText().isEmpty()) {
                            Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                                    "Please enter the second option");
                            return;
                        }
                        if (op3.getText().isEmpty()) {
                            Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                                    "Please enter the third option");
                            return;
                        }
                        if (op4.getText().isEmpty()) {
                            Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                                    "Please enter the fourth option");
                            return;
                        }

                        if (!ans1.isSelected() && !ans2.isSelected() && !ans3.isSelected() && !ans4.isSelected()) {
                            Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                                    "Please select an answer");
                            return;
                        }

                        String question = quest.getText();
                        String option1 = op1.getText();
                        String option2 = op2.getText();
                        String option3 = op3.getText();
                        String option4 = op4.getText();
                        String answer = selected;
                        System.out.println(selected);

                        try {
                            edit(question, option1, option2, option3, option4, answer, value1, questionNumber, value2);
                        } catch (SQLException ex) {
                            Logger.getLogger(EditQuizDao.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (questionNumber < totalQuestions) {
                            try {
                                infoBox("Record Saved Succesfully!", null, "Passed");
                                stage.close();
                                display(value1, value2, value3, emailId);
                                value3++;
                            } catch (Exception ex) {
                                Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            infoBox("Quiz Updated Succesfully!", null, "Passed");
                            stage.close();
                            ViewQuizzesDao vq = new ViewQuizzesDao();
                            try {
                                vq.display(emailId, "teacher");
                            } catch (SQLException ex) {
                                Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

                });

                root = new Group(l, view, quest, op1, op2, op3, op4, ans1, ans2, ans3, ans4, btn1, l1, l2, l3, l4, l5, l6);
                scene = new Scene(root, 3050, 1100, Color.BLACK);
                stage.setTitle("Edit Quiz");
                stage.setScene(scene);
                scene.setRoot(root);
                stage.show();

                if (resultSet.next()) {
                    return true;
                }
            }
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
