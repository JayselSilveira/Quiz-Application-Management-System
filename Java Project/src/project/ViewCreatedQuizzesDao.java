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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewCreatedQuizzesDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_project?useSSL=true";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String SELECT_QUERY = "SELECT total_questions, question, option1, option2, option3, option4, answer FROM quiz WHERE quiz_name = ? AND question_number = ? AND teacher = ?";

    String val1, val2, selected, op1, op2, op3, op4, answer;
    int value3 = 2, currQ = 0, totQ, tQ, tM = 0;
    Boolean flag = false;
    Label l, q, l1, l2, l3, l4;
    Group root;
    Scene scene;

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

            val1 = value1;
            val2 = value2;

            Label l = new Label("QUIZ NAME: " + value1);
            l.setTranslateX(750);
            l.setTranslateY(30);
            l.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-underline: true; -fx-text-fill: AQUA");

            Image img1 = new Image("project/quiz.png");
            ImageView view = new ImageView(img1);
            view.setX(50);
            view.setY(150);
            view.setFitHeight(750);
            view.setFitWidth(500);

            while (resultSet.next()) {
                totQ = resultSet.getInt("total_questions");

                int totM = totQ * 10;
                Label lm = new Label("Total Marks: " + totM);
                lm.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-fill: White");
                lm.setTranslateX(1700);
                lm.setTranslateY(20);
                //Label lt = new Label("Time Left: [HERE]");
                //lt.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-text-fill: White");
                //lt.setTranslateX(1150);
                //lt.setTranslateY(45);

                root = new Group(l, view, lm);
                scene = new Scene(root, 3050, 1100, Color.BLACK);
                stage.setTitle("View Quiz");
                stage.setScene(scene);

                op1 = resultSet.getString("option1");
                op2 = resultSet.getString("option2");
                op3 = resultSet.getString("option3");
                op4 = resultSet.getString("option4");
                answer = resultSet.getString("answer");
                String ques = "Q" + (currQ + 1) + ". " + resultSet.getString("question");
                String option1 = "option 1: " + op1;
                String option2 = "option 2: " + op2;
                String option3 = "option 3: " + op3;
                String option4 = "option 4: " + op4;

                Label q = new Label(ques);
                q.setTranslateX(650);
                q.setTranslateY(200);
                q.setStyle("-fx-font-weight: bold; -fx-font-size: 36; -fx-text-fill: White");
                root.getChildren().add(q);

                l1 = new Label(option1);
                l1.setStyle("-fx-font-weight: bold; -fx-font-size: 34; -fx-text-fill: White");
                l1.setTranslateX(700);
                l1.setTranslateY(350);

                l2 = new Label(option2);
                l2.setStyle("-fx-font-weight: bold; -fx-font-size: 34; -fx-text-fill: White");
                l2.setTranslateX(700);
                l2.setTranslateY(450);

                l3 = new Label(option3);
                l3.setStyle("-fx-font-weight: bold; -fx-font-size: 34; -fx-text-fill: White");
                l3.setTranslateX(700);
                l3.setTranslateY(550);

                l4 = new Label(option4);
                l4.setStyle("-fx-font-weight: bold; -fx-font-size: 34; -fx-text-fill: White");
                l4.setTranslateX(700);
                l4.setTranslateY(650);

                root.getChildren().add(l1);
                root.getChildren().add(l2);
                root.getChildren().add(l3);
                root.getChildren().add(l4);
            }

            Button b2 = new Button();
            b2.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
            b2.setTranslateX(1500);
            b2.setTranslateY(850);
            b2.setPrefSize(200, 50);
            currQ++;
            //System.out.println(currQ);
            //System.out.println(totQ);
            if (currQ == totQ) {
                b2.setText("EXIT");
                b2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        stage.close();
                        ViewQuizzesDao vq = new ViewQuizzesDao();
                        try {
                            vq.display(emailId, "teacher");
                        } catch (SQLException ex) {
                            Logger.getLogger(ViewCreatedQuizzesDao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                );
            } else {
                b2.setText("NEXT");
                b2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            display(value1, value2, value3, emailId);
                        } catch (SQLException ex) {
                            Logger.getLogger(ViewCreatedQuizzesDao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        value3++;
                        stage.close();

                    }

                }
                );
            }

            root.getChildren().add(b2);
            scene.setRoot(root);
            stage.show();

            if (resultSet.next()) {
                return true;
            }
        }
        return false;
    }
}
