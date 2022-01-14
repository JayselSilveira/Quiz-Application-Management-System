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

public class QuizDescriptionDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_project?useSSL=true";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String SELECT_QUERY = "SELECT quiz_name, teacher, description, diff_level, total_questions FROM quiz WHERE quiz_name = ? AND teacher = ? AND teacher_email = ? LIMIT 1";
    private static final String SELECT_TEACHER_QUERY = "SELECT full_name, designation, email_id FROM teachers WHERE email_id = ?";

    Label l, l1;
    Group root;
    Button btn, btn1, btn2, btn3;
    Stage stage = new Stage();
    Scene scene;

    public boolean display(String value1, String value2, String value3, int i, String emailId, String user) throws SQLException {

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, value1);
            preparedStatement.setString(2, value2);
            preparedStatement.setString(3, value3);
            ResultSet resultSet = preparedStatement.executeQuery();

            //after clicking on the rectangle
            while (resultSet.next()) {
                l = new Label("QUIZ NAME: " + resultSet.getString("quiz_name"));
                l.setTranslateX(750);
                l.setTranslateY(30);
                l.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-underline: true; -fx-text-fill: AQUA");

                Image img1 = new Image("project/quiz.png");
                ImageView view = new ImageView(img1);
                view.setX(50);
                view.setY(150);
                view.setFitHeight(750);
                view.setFitWidth(500);

                String designation = "";
                try (Connection connection1 = DriverManager
                        .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(SELECT_TEACHER_QUERY)) {
                    preparedStatement1.setString(1, value3);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    while (resultSet1.next()) {
                        designation = resultSet1.getString("designation");
                    }
                }

                l1 = new Label("By: " + designation + " " + resultSet.getString("teacher")
                        + "\n\nDescription: " + resultSet.getString("description")
                        + "\n\nDifficulty Level: " + resultSet.getString("diff_level")
                        + "\n\nTotal Number of Questions: " + resultSet.getString("total_questions")
                        //+ "\n\nTotal Time Allotted: 10mins"
                        + "\n\nGeneral Rules:"//\n1. The time on the top right corner indicates the time left."
                        + "\n1. Total marks are displayed at the top right corner."
                        + "\n2. Click on the radiobutton next to the option to select an answer."
                        + "\n3. Once you click on NEXT you cannot go back to the previous question."
                        + "\n4. 10 points for every correct answer and no points for wrong."
                        + "\n5. Once done, click on the EXIT button."
                        + "\n6. Upon exiting, you can view your score and retry.");
                l1.setTranslateX(700);
                l1.setTranslateY(200);
                l1.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-fill: White");

                //System.out.println(user);
                if ("student".equals(user)) {
                    btn = new Button("START QUIZ");
                    btn.setTranslateX(850);
                    btn.setTranslateY(840);
                    btn.setPrefSize(220, 60);
                    btn.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
                    btn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            stage.close();
                            //System.out.println(value2);
                            QuizQuestionsDao qqd = new QuizQuestionsDao();
                            try {
                                qqd.display(value1, value2, value3, 1, emailId);
                            } catch (SQLException ex) {
                                Logger.getLogger(StudentStartQuiz.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });

                    btn2 = new Button("BACK");
                    btn2.setTranslateX(1700);
                    btn2.setTranslateY(20);
                    btn2.setPrefSize(200, 50);
                    btn2.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
                    btn2.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            stage.close();
                            ViewQuizzesDao vq = new ViewQuizzesDao();
                            try {
                                vq.display(emailId, "student");
                            } catch (SQLException ex) {
                                Logger.getLogger(QuizDescriptionDao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });

                    root = new Group(l, l1, view, btn, btn2);
                }

                if ("teacher".equals(user)) {
                    try (Connection connection1 = DriverManager
                            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                            PreparedStatement preparedStatement1 = connection1.prepareStatement(SELECT_TEACHER_QUERY)) {
                        preparedStatement1.setString(1, emailId);
                        ResultSet resultSet1 = preparedStatement1.executeQuery();

                        while (resultSet1.next()) {
                            String teacher = resultSet1.getString("full_name");
                            String teacherEmailId = resultSet1.getString("email_id");
                            //System.out.println(teacher);
                            //System.out.println(value2);
                            if (teacher == null ? value2 == null : teacher.equals(value2) && (teacherEmailId == null ? value3 == null : teacherEmailId.equals(value3))) {
                                btn3 = new Button("EDIT");
                                btn3.setTranslateX(480);
                                btn3.setTranslateY(840);
                                btn3.setPrefSize(200, 50);
                                btn3.setStyle("-fx-background-color: teal; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
                                btn3.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        stage.close();
                                        EditQuizDao eq = new EditQuizDao();
                                        try {
                                            eq.display(value1, value2, i, emailId);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(QuizDescriptionDao.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });

                                btn = new Button("VIEW");
                                btn.setTranslateX(870);
                                btn.setTranslateY(840);
                                btn.setPrefSize(200, 50);
                                btn.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
                                btn.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        stage.close();
                                        ViewCreatedQuizzesDao vcq = new ViewCreatedQuizzesDao();
                                        try {
                                            vcq.display(value1, value2, 1, emailId);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(QuizDescriptionDao.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });

                                btn1 = new Button("DELETE");
                                btn1.setTranslateX(1260);
                                btn1.setTranslateY(840);
                                btn1.setPrefSize(200, 50);
                                btn1.setStyle("-fx-background-color: red; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
                                btn1.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        DeleteQuizDao dq = new DeleteQuizDao();
                                        try {
                                            dq.delete(value1, value2);
                                            stage.close();
                                            ViewQuizzesDao vq = new ViewQuizzesDao();
                                            vq.display(emailId, "teacher");
                                        } catch (SQLException ex) {
                                            Logger.getLogger(QuizDescriptionDao.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });

                                btn2 = new Button("BACK");
                                btn2.setTranslateX(1700);
                                btn2.setTranslateY(20);
                                btn2.setPrefSize(200, 50);
                                btn2.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
                                btn2.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        stage.close();
                                        ViewQuizzesDao vq = new ViewQuizzesDao();
                                        try {
                                            vq.display(emailId, "teacher");
                                        } catch (SQLException ex) {
                                            Logger.getLogger(QuizDescriptionDao.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });

                                root = new Group(l, l1, view, btn, btn1, btn2, btn3);
                            } else {
                                btn = new Button("BACK");
                                btn.setTranslateX(870);
                                btn.setTranslateY(830);
                                btn.setPrefSize(200, 50);
                                btn.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
                                btn.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        stage.close();
                                        ViewQuizzesDao vq = new ViewQuizzesDao();
                                        try {
                                            vq.display(emailId, "teacher");
                                        } catch (SQLException ex) {
                                            Logger.getLogger(QuizDescriptionDao.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                                root = new Group(l, l1, view, btn);
                            }
                        }
                    }
                }

                scene = new Scene(root, 3050, 1100, Color.BLACK);
                stage.setTitle("Quiz Description");
                stage.setScene(scene);
                scene.setRoot(root);
                stage.show();
            }
            return false;
        }
    }
}
