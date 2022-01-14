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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.Window;
import static project.Project.infoBox;
import static project.ViewQuizzesDao.printSQLException;

public class QuizQuestionsDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_project?useSSL=true";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String SELECT_QUERY = "SELECT total_questions, question, option1, option2, option3, option4, answer FROM quiz WHERE quiz_name = ? AND question_number = ? AND teacher = ?";

    String val1, val2, val3, selected, op1, op2, op3, op4, answer;
    int value3 = 2, obtMarks = 0, totQ, currQ = 0, totMarks = 0, tQ, tM = 0;
    Boolean flag = false, next = false;
    RadioButton r1, r2, r3, r4;

    public boolean display(String value1, String value2, String valueE, int i, String emailId) throws SQLException {

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
            val3 = valueE;

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

                Group root = new Group(l, view, lm);
                Scene scene = new Scene(root, 3050, 1100, Color.BLACK);
                stage.setTitle("Answer Quiz");
                stage.setScene(scene);

                if (flag == false) {
                    flag = true;
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
                    q.setTranslateX(700);
                    q.setTranslateY(200);
                    q.setStyle("-fx-font-weight: bold; -fx-font-size: 36; -fx-text-fill: White");
                    root.getChildren().add(q);

                    r1 = new RadioButton(op1);
                    r1.setStyle("-fx-font-weight: bold; -fx-font-size: 34; -fx-text-fill: White");
                    r1.setTranslateX(700);
                    r1.setTranslateY(350);

                    r2 = new RadioButton(op2);
                    r2.setStyle("-fx-font-weight: bold; -fx-font-size: 34; -fx-text-fill: White");
                    r2.setTranslateX(700);
                    r2.setTranslateY(450);

                    r3 = new RadioButton(op3);
                    r3.setStyle("-fx-font-weight: bold; -fx-font-size: 34; -fx-text-fill: White");
                    r3.setTranslateX(700);
                    r3.setTranslateY(550);

                    r4 = new RadioButton(op4);
                    r4.setStyle("-fx-font-weight: bold; -fx-font-size: 34; -fx-text-fill: White");
                    r4.setTranslateX(700);
                    r4.setTranslateY(650);

                    ToggleGroup tg = new ToggleGroup();
                    r1.setToggleGroup(tg);
                    r2.setToggleGroup(tg);
                    r3.setToggleGroup(tg);
                    r4.setToggleGroup(tg);

                    root.getChildren().add(r1);
                    root.getChildren().add(r2);
                    root.getChildren().add(r3);
                    root.getChildren().add(r4);

                    r1.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            if (r1.isSelected()) {
                                selected = op1;
                            }
                        }
                    });

                    r2.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            if (r2.isSelected()) {
                                selected = op2;
                            }
                        }
                    });

                    r3.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            if (r3.isSelected()) {
                                selected = op3;
                            }
                        }
                    });

                    r4.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            if (r4.isSelected()) {
                                selected = op4;
                            }
                        }
                    });
                }

                /*Button b1 = new Button("BACK");
                 b1.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
                 b1.setTranslateX(850);
                 b1.setTranslateY(500);
                 b1.setPrefSize(180, 50);
                 root.getChildren().add(b1);*/
                Button b2 = new Button("NEXT");
                b2.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
                b2.setTranslateX(1500);
                b2.setTranslateY(850);
                b2.setPrefSize(200, 50);
                b2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Window owner = b2.getScene().getWindow();
                        if (r1.isSelected() || r2.isSelected() || r3.isSelected() || r4.isSelected()) {
                            if (selected == null ? answer == null : selected.equals(answer)) {
                                System.out.println("Correct");
                                currQ++;
                                flag = false;
                                try {
                                    display(value1, value2, valueE, value3, emailId);
                                    value3++;
                                    obtMarks += 10;
                                    totMarks += 10;
                                    System.out.println(obtMarks);
                                    stage.close();
                                } catch (SQLException ex) {
                                    Logger.getLogger(QuizQuestionsDao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (currQ == totQ) {
                                    try {
                                        //System.out.println(currQ);
                                        //System.out.println(totQ);
                                        infoBox("Thank you for taking the quiz!", null, "Passed");
                                        score(emailId);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(QuizQuestionsDao.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            } else {
                                System.out.println("Incorrect");
                                //System.out.println(selected);
                                //System.out.println(answer);
                                currQ++;
                                flag = false;
                                try {
                                    display(value1, value2, valueE, value3, emailId);
                                    value3++;
                                    obtMarks += 0;
                                    totMarks += 10;
                                    System.out.println(obtMarks);
                                    stage.close();
                                } catch (SQLException ex) {
                                    Logger.getLogger(QuizQuestionsDao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (currQ == totQ) {
                                    try {
                                        //System.out.println(currQ);
                                        //System.out.println(totQ);
                                        infoBox("Thank you for taking the quiz!", null, "Passed");
                                        score(emailId);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(QuizQuestionsDao.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        } else {
                            Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                                    "Please select an answer");
                        }
                    }
                }
                );
                root.getChildren().add(b2);
                scene.setRoot(root);
                stage.show();

                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return false;
    }

    public void score(String emailId) throws SQLException {
        StudentResultDao res = new StudentResultDao();
        res.insertRecord(emailId, val1, val2, val3, obtMarks, totMarks);

        Label l, l1, l2, l3;
        Group root;
        Button b1, b2;
        Stage stage = new Stage();

        l1 = new Label("YOUR SCORE: ");
        l1.setTranslateX(780);
        l1.setTranslateY(40);
        l1.setStyle("-fx-font-weight: bold; -fx-font-size: 50; -fx-text-fill: AQUA");

        l = new Label("QUIZ NAME: " + val1);
        l.setTranslateX(750);
        l.setTranslateY(150);
        l.setStyle("-fx-font-weight: bold; -fx-font-size: 36;-fx-text-fill: white");

        l2 = new Label("BY: " + val2);
        l2.setTranslateX(750);
        l2.setTranslateY(200);
        l2.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: white");

        l3 = new Label("" + obtMarks);
        l3.setTranslateX(880);
        l3.setTranslateY(400);
        l3.setStyle("-fx-font-weight: bold; -fx-font-size: 120;  -fx-text-fill: black");

        Circle c = new Circle();
        c.setCenterX(950);
        c.setCenterY(500);
        c.setRadius(180);
        c.setStyle("-fx-fill: White ; -fx-stroke: AQUA; -fx-stroke-width: 8;");

        Image img1 = new Image("project/quiz.png");
        ImageView view = new ImageView(img1);
        view.setX(50);
        view.setY(150);
        view.setFitHeight(750);
        view.setFitWidth(500);

        b1 = new Button("RETRY");
        b1.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        b1.setTranslateX(600);
        b1.setTranslateY(800);
        b1.setPrefSize(220, 70);
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
                StudentStartQuiz ssq = new StudentStartQuiz();
                try {
                    ssq.start(val1, val2, val3, emailId, "student");
                } catch (Exception ex) {
                    Logger.getLogger(QuizQuestionsDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        b2 = new Button("EXIT");
        b2.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        b2.setTranslateX(1100);
        b2.setTranslateY(800);
        b2.setPrefSize(220, 70);
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
                ViewQuizzesDao vq = new ViewQuizzesDao();
                try {
                    vq.display(emailId, "student");
                } catch (SQLException ex) {
                    Logger.getLogger(QuizQuestionsDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        root = new Group(l, l1, l2, view, c, l3, b1, b2);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);
        stage.setTitle("Quiz Score");
        stage.setScene(scene);
        scene.setRoot(root);
        stage.show();
    }
}
