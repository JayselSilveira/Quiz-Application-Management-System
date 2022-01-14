package project;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
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

class Start extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Image img1 = new Image("project/quiz.png");
        ImageView view = new ImageView(img1);
        view.setX(50);
        view.setY(150);
        view.setFitHeight(750);
        view.setFitWidth(500);

        Label l1 = new Label("\t\t\t  WELCOME TO\nQUIZ APPLICATION MANAGEMENT SYSTEM!");
        l1.setStyle("-fx-font-weight: bold; -fx-font-size: 60; -fx-text-fill: White;");
        l1.setTranslateX(340);
        l1.setTranslateY(50);

        Label l2 = new Label("PROJECT BY:\n      JAYSEL SILVEIRA (1914018) \n      DRUVI TENDULKAR (1914014)");
        l2.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-text-fill: White;");
        l2.setTranslateX(750);
        l2.setTranslateY(400);

        Button btn = new Button("START");
        btn.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2.5em;");
        btn.setTranslateX(850);
        btn.setTranslateY(800);
        btn.setPrefSize(250, 80);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SelectUser user = new SelectUser();
                try {
                    user.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Group root = new Group(view, l1, l2, btn);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);
        stage.setTitle("Start Page");
        stage.setScene(scene);
        stage.show();
    }
}

class SelectUser extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //System.out.println(getClass());

        Label title = new Label("Welcome to Quiz Application Management System!");
        title.setTranslateX(350);
        title.setTranslateY(50);
        title.setPrefSize(1300, 80);
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 52; -fx-text-fill: White; -fx-underline: true;");

        Label user = new Label("SELECT USER");
        user.setStyle("-fx-font-weight: bold; -fx-font-size: 52; -fx-text-fill: White; -fx-underline: true;");
        user.setTranslateX(800);
        user.setTranslateY(250);

        Button btn1 = new Button("TEACHER");
        btn1.setStyle("-fx-background-color: white; -fx-font-size: 40; -fx-font-weight: bold; -fx-border-width: 5px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn1.setTranslateX(830);
        btn1.setTranslateY(450);
        btn1.setPrefSize(240, 90);

        Button btn2 = new Button("STUDENT");
        btn2.setStyle("-fx-background-color: white; -fx-font-size: 40; -fx-font-weight: bold; -fx-border-width: 5px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn2.setTranslateX(830);
        btn2.setTranslateY(650);
        btn2.setPrefSize(240, 90);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TeacherStart tStart = new TeacherStart();
                try {
                    tStart.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentStart sStart = new StudentStart();
                try {
                    sStart.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Image img1 = new Image("project/quiz.png");
        ImageView view1 = new ImageView(img1);
        view1.setX(50);
        view1.setY(150);
        view1.setFitHeight(750);
        view1.setFitWidth(500);

        ImageView view2 = new ImageView(img1);
        view2.setX(1380);
        view2.setY(150);
        view2.setFitHeight(750);
        view2.setFitWidth(500);

        Group root = new Group(title, view1, view2, user, btn1, btn2);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);

        stage.setTitle("Welcome to Quiz Application!");
        stage.setScene(scene);
        stage.show();
    }
}

class TeacherStart extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //System.out.println(getClass());

        Label user = new Label("REGISTER OR LOGIN");
        user.setStyle("-fx-font-weight: bold; -fx-font-size: 52; -fx-text-fill: White; -fx-underline: true;");
        user.setTranslateX(730);
        user.setTranslateY(100);

        Button btn1 = new Button("REGISTER");
        btn1.setStyle("-fx-background-color: white; -fx-font-size: 40; -fx-font-weight: bold; -fx-border-width: 5px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn1.setTranslateX(830);
        btn1.setTranslateY(400);
        btn1.setPrefSize(240, 90);

        Button btn2 = new Button("LOGIN");
        btn2.setStyle("-fx-background-color: white; -fx-font-size: 40; -fx-font-weight: bold; -fx-border-width: 5px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn2.setTranslateX(830);
        btn2.setTranslateY(600);
        btn2.setPrefSize(240, 90);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TeacherRegister tReg = new TeacherRegister();
                try {
                    tReg.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TeacherLogin tLog = new TeacherLogin();
                try {
                    tLog.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Image img1 = new Image("project/quiz.png");
        ImageView view1 = new ImageView(img1);
        view1.setX(50);
        view1.setY(150);
        view1.setFitHeight(750);
        view1.setFitWidth(500);

        ImageView view2 = new ImageView(img1);
        view2.setX(1380);
        view2.setY(150);
        view2.setFitHeight(750);
        view2.setFitWidth(500);

        Group root = new Group(view1, view2, user, btn1, btn2);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);

        stage.setTitle("Welcome to Quiz Application!");
        stage.setScene(scene);
        stage.show();
    }
}

class TeacherRegister extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label l1 = new Label("TEACHER'S REGISTRATION");
        l1.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-text-fill: White; -fx-underline: true;");
        l1.setTranslateX(750);
        l1.setTranslateY(30);

        Label lbFullName = new Label("Full Name: ");
        lbFullName.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbFullName.setTranslateX(700);
        lbFullName.setTranslateY(150);

        TextField txtFullName = new TextField();
        txtFullName.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtFullName.setPrefWidth(600);
        txtFullName.setMaxWidth(400);
        txtFullName.setTranslateX(900);
        txtFullName.setTranslateY(150);

        Label lbDesignation = new Label("Designation: ");
        lbDesignation.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbDesignation.setTranslateX(700);
        lbDesignation.setTranslateY(250);

        TextField txtDesignation = new TextField();
        txtDesignation.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtDesignation.setPrefWidth(400);
        txtDesignation.setMaxWidth(400);
        txtDesignation.setTranslateX(900);
        txtDesignation.setTranslateY(250);

        Label lbInstitute = new Label("Institute: ");
        lbInstitute.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbInstitute.setTranslateX(700);
        lbInstitute.setTranslateY(350);

        TextField txtInstitute = new TextField();
        txtInstitute.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtInstitute.setPrefWidth(400);
        txtInstitute.setMaxWidth(400);
        txtInstitute.setTranslateX(900);
        txtInstitute.setTranslateY(350);

        Label lbEmailId = new Label("Email ID: ");
        lbEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbEmailId.setTranslateX(700);
        lbEmailId.setTranslateY(450);

        TextField txtEmailId = new TextField();
        txtEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtEmailId.setPrefWidth(400);
        txtEmailId.setMaxWidth(400);
        txtEmailId.setTranslateX(900);
        txtEmailId.setTranslateY(450);

        Label lbPassword = new Label("Password: ");
        lbPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbPassword.setTranslateX(700);
        lbPassword.setTranslateY(550);

        TextField txtPassword = new TextField();
        txtPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtPassword.setPrefWidth(400);
        txtPassword.setMaxWidth(400);
        txtPassword.setTranslateX(900);
        txtPassword.setTranslateY(550);

        Image img1 = new Image("project/quiz.png");
        ImageView view1 = new ImageView(img1);
        view1.setX(50);
        view1.setY(150);
        view1.setFitHeight(750);
        view1.setFitWidth(500);

        Button btn3 = new Button("SUBMIT");
        btn3.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn3.setTranslateX(900);
        btn3.setTranslateY(700);
        btn3.setPrefSize(180, 50);

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Window owner = btn3.getScene().getWindow();
                if (txtFullName.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your name");
                    return;
                }
                if (txtDesignation.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your designation");
                    return;
                }
                if (txtInstitute.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your institute name");
                    return;
                }
                if (txtEmailId.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your email id");
                    return;
                }
                if (txtPassword.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter a password");
                    return;
                }

                String fullName = txtFullName.getText();
                String designation = txtDesignation.getText();
                String institute = txtInstitute.getText();
                String emailId = txtEmailId.getText();
                String password = txtPassword.getText();
                TeacherRegisterDao tRegisterDao = new TeacherRegisterDao();

                try {
                    Boolean verify = tRegisterDao.verify(emailId);
                    if (verify == false) {
                        try {
                            tRegisterDao.insertRecord(fullName, designation, institute, emailId, password);
                        } catch (SQLException ex) {
                            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        infoBox("Welcome " + txtFullName.getText(), null, "Registration Successful!");
                        TeacherLogin tLog = new TeacherLogin();
                        try {
                            tLog.start(stage);
                        } catch (Exception ex) {
                            Logger.getLogger(TeacherRegister.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (verify == true) {
                        infoBox("User with the entered email-id has already been registered!", null, "Attention");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherRegister.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );

        Button btn4 = new Button("LOGIN");
        btn4.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn4.setTranslateX(900);
        btn4.setTranslateY(850);
        btn4.setPrefSize(180, 50);

        btn4.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event
                    ) {
                        TeacherLogin tLog = new TeacherLogin();
                        try {
                            tLog.start(stage);
                        } catch (Exception ex) {
                            Logger.getLogger(TeacherRegister.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
        );

        Group root = new Group(view1, l1, lbFullName, txtFullName, lbDesignation, txtDesignation, lbInstitute, txtInstitute, lbEmailId, txtEmailId, lbPassword, txtPassword, btn3, btn4);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);

        stage.setTitle("Teacher's Registeration Page");
        stage.setScene(scene);
        stage.show();
    }
}

class TeacherLogin extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label l1 = new Label("TEACHER'S LOGIN");
        l1.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-text-fill: White; -fx-underline: true;");
        l1.setTranslateX(800);
        l1.setTranslateY(30);

        Label lbEmailId = new Label("Email ID: ");
        lbEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbEmailId.setTranslateX(700);
        lbEmailId.setTranslateY(250);

        TextField txtEmailId = new TextField();
        txtEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtEmailId.setPrefWidth(400);
        txtEmailId.setMaxWidth(400);
        txtEmailId.setTranslateX(900);
        txtEmailId.setTranslateY(250);

        Label lbPassword = new Label("Password: ");
        lbPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbPassword.setTranslateX(700);
        lbPassword.setTranslateY(400);

        TextField txtPassword = new TextField();
        txtPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtPassword.setPrefWidth(400);
        txtPassword.setMaxWidth(400);
        txtPassword.setTranslateX(900);
        txtPassword.setTranslateY(400);

        Image img1 = new Image("project/quiz.png");
        ImageView view1 = new ImageView(img1);
        view1.setX(50);
        view1.setY(150);
        view1.setFitHeight(750);
        view1.setFitWidth(500);

        Button btn3 = new Button("LOGIN");
        btn3.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn3.setTranslateX(880);
        btn3.setTranslateY(570);
        btn3.setPrefSize(180, 50);

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Window owner = btn3.getScene().getWindow();
                if (txtEmailId.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your email id");
                    return;
                }
                if (txtPassword.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter a password");
                    return;
                }

                String emailId = txtEmailId.getText();
                String password = txtPassword.getText();
                TeacherLoginDao tLoginDao = new TeacherLoginDao();
                boolean flag;
                try {
                    flag = tLoginDao.validate(emailId, password);
                    if (!flag) {
                        infoBox("Please enter correct Email and Password", null, "Failed");
                    } else {
                        infoBox("Login Successful!", null, "Passed");
                        TeacherDashboard tDash = new TeacherDashboard();
                        try {
                            tDash.start(stage, emailId);
                        } catch (Exception ex) {
                            Logger.getLogger(TeacherLogin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        stage.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        Button btn4 = new Button("RESET PASSWORD");
        btn4.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em;");
        btn4.setTranslateX(480);
        btn4.setTranslateY(750);
        btn4.setPrefSize(350, 50);

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TeacherResetPassword tResP = new TeacherResetPassword();
                try {
                    tResP.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(TeacherLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Button btn5 = new Button("REGISTER");
        btn5.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em;");
        btn5.setTranslateX(1100);
        btn5.setTranslateY(750);
        btn5.setPrefSize(250, 50);

        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TeacherRegister tReg = new TeacherRegister();
                try {
                    tReg.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(TeacherLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Group root = new Group(view1, l1, lbEmailId, txtEmailId, lbPassword, txtPassword, btn3, btn4, btn5);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);

        stage.setTitle("Teacher's Login Page");
        stage.setScene(scene);
        stage.show();
    }
}

class TeacherResetPassword extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label l1 = new Label("RESET PASSWORD");
        l1.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-text-fill: White; -fx-underline: true;");
        l1.setTranslateX(780);
        l1.setTranslateY(30);

        Label lbEmailId = new Label("Email ID: ");
        lbEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbEmailId.setTranslateX(650);
        lbEmailId.setTranslateY(200);

        TextField txtEmailId = new TextField();
        txtEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtEmailId.setPrefWidth(600);
        txtEmailId.setMaxWidth(400);
        txtEmailId.setTranslateX(900);
        txtEmailId.setTranslateY(200);

        Label lbCurrentPassword = new Label("Current Password: ");
        lbCurrentPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbCurrentPassword.setTranslateX(650);
        lbCurrentPassword.setTranslateY(400);

        TextField txtCurrentPassword = new TextField();
        txtCurrentPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtCurrentPassword.setPrefWidth(400);
        txtCurrentPassword.setMaxWidth(400);
        txtCurrentPassword.setTranslateX(900);
        txtCurrentPassword.setTranslateY(400);

        Label lbNewPassword = new Label("New Password: ");
        lbNewPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbNewPassword.setTranslateX(650);
        lbNewPassword.setTranslateY(600);

        TextField txtNewPassword = new TextField();
        txtNewPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtNewPassword.setPrefWidth(400);
        txtNewPassword.setMaxWidth(400);
        txtNewPassword.setTranslateX(900);
        txtNewPassword.setTranslateY(600);

        Image img1 = new Image("project/quiz.png");
        ImageView view1 = new ImageView(img1);
        view1.setX(50);
        view1.setY(150);
        view1.setFitHeight(750);
        view1.setFitWidth(500);

        Button btn3 = new Button("RESET");
        btn3.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn3.setTranslateX(900);
        btn3.setTranslateY(800);
        btn3.setPrefSize(180, 50);

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Window owner = btn3.getScene().getWindow();
                if (txtEmailId.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your email id");
                    return;
                }
                if (txtCurrentPassword.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your current password");
                    return;
                }
                if (txtNewPassword.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your new password");
                    return;
                }
                String emailId = txtEmailId.getText();
                String currentPassword = txtCurrentPassword.getText();
                String newPassword = txtNewPassword.getText();
                TeacherResetPasswordDao tResetPasswordDao = new TeacherResetPasswordDao();
                boolean flag;
                try {
                    flag = tResetPasswordDao.validate(emailId, currentPassword);
                    if (!flag) {
                        infoBox("Please enter correct Email and current Password", null, "Failed");
                    } else {
                        tResetPasswordDao.updateRecord(emailId, newPassword);
                        infoBox("Password Reset Successfully!", null, "Passed");
                        TeacherLogin tLog = new TeacherLogin();
                        try {
                            tLog.start(stage);
                        } catch (Exception ex) {
                            Logger.getLogger(TeacherResetPassword.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Group root = new Group(view1, l1, lbEmailId, txtEmailId, lbCurrentPassword, txtCurrentPassword, lbNewPassword, txtNewPassword, btn3);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);

        stage.setTitle("Teacher's Reset Password Page");
        stage.setScene(scene);
        stage.show();
    }
}

class TeacherDashboard extends Application {

    public void start(Stage stage1, String emailId) throws Exception {
        Stage stage = new Stage();
        Label l = new Label("TEACHER'S DASHBOARD");
        l.setTranslateX(750);
        l.setTranslateY(80);
        l.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-underline: true; -fx-text-fill: AQUA");

        Image img1 = new Image("project/quiz.png");
        ImageView view = new ImageView(img1);
        view.setX(50);
        view.setY(150);
        view.setFitHeight(750);
        view.setFitWidth(500);

        Button b1 = new Button("CREATE QUIZ");
        b1.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
        b1.setTranslateX(800);
        b1.setTranslateY(300);
        b1.setPrefSize(300, 70);
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CreateQuizInfo cqi = new CreateQuizInfo();
                try {
                    cqi.start(emailId);
                } catch (Exception ex) {
                    Logger.getLogger(TeacherDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Button b2 = new Button("VIEW QUIZZES");
        b2.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
        b2.setTranslateX(800);
        b2.setTranslateY(450);
        b2.setPrefSize(300, 70);
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewQuizzesDao vq = new ViewQuizzesDao();
                String user = "teacher";
                try {
                    vq.display(emailId, user);
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Button b3 = new Button("VIEW RESULTS");
        b3.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
        b3.setTranslateX(800);
        b3.setTranslateY(600);
        b3.setPrefSize(300, 70);
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TeacherResultDao res = new TeacherResultDao();
                try {
                    res.display(emailId);
                } catch (SQLException ex) {
                    Logger.getLogger(TeacherDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Button b4 = new Button("LOGOUT");
        b4.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
        b4.setTranslateX(800);
        b4.setTranslateY(750);
        b4.setPrefSize(300, 70);
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SelectUser user = new SelectUser();
                try {
                    stage.close();
                    infoBox("Logout Successful!", null, "Passed");
                    Stage stage1 = new Stage();
                    user.start(stage1);
                } catch (Exception ex) {
                    Logger.getLogger(TeacherDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Group root = new Group(l, view, b1, b2, b3, b4);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);
        stage.setTitle("Teacher's Dashboard");
        stage.setScene(scene);
        scene.setRoot(root);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class CreateQuizInfo extends Application {

    public static int n;
    String selected;
    Stage stage = new Stage();

    public void start(String emailId) throws Exception {
        Label l = new Label("CREATE QUIZ");
        l.setTranslateX(800);
        l.setTranslateY(50);
        l.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-underline: true; -fx-text-fill: AQUA");

        Image img1 = new Image("project/quiz.png");
        ImageView view = new ImageView(img1);
        view.setX(50);
        view.setY(150);
        view.setFitHeight(750);
        view.setFitWidth(500);

        Label l1 = new Label("QUIZ  NAME :");
        l1.setTranslateX(800);
        l1.setTranslateY(200);
        l1.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

        TextField tf1 = new TextField();
        tf1.setTranslateX(1200);
        tf1.setTranslateY(190);
        tf1.setPrefSize(500, 30);
        tf1.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26");

        Label l2 = new Label("NUMBER OF QUESTIONS :");
        l2.setTranslateX(800);
        l2.setTranslateY(330);
        l2.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

        TextField tf2 = new TextField();
        tf2.setTranslateX(1200);
        tf2.setTranslateY(320);
        tf2.setPrefSize(500, 30);
        tf2.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26");

        Label l3 = new Label("QUIZ DESCRIPTION :");
        l3.setTranslateX(800);
        l3.setTranslateY(460);
        l3.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

        TextField tf3 = new TextField();
        tf3.setTranslateX(1200);
        tf3.setTranslateY(450);
        tf3.setPrefSize(500, 30);
        tf3.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26");

        Label l4 = new Label("DIFFICULTY LEVEL :");
        l4.setTranslateX(800);
        l4.setTranslateY(590);
        l4.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

        RadioButton r1 = new RadioButton("Beginner");
        r1.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: White");
        r1.setTranslateX(1200);
        r1.setTranslateY(580);

        RadioButton r2 = new RadioButton("Intermediate");
        r2.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: White");
        r2.setTranslateX(1200);
        r2.setTranslateY(630);

        RadioButton r3 = new RadioButton("Advanced");
        r3.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: White");
        r3.setTranslateX(1200);
        r3.setTranslateY(680);

        ToggleGroup tg = new ToggleGroup();
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);

        r1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (r1.isSelected()) {
                    selected = "Beginner";
                }
            }
        });

        r2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (r2.isSelected()) {
                    selected = "Intermediate";
                }
            }
        });

        r3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (r3.isSelected()) {
                    selected = "Advanced";
                }
            }
        });

        Button btn = new Button("BACK");
        btn.setTranslateX(1000);
        btn.setTranslateY(800);
        btn.setPrefSize(180, 50);
        btn.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TeacherDashboard tDash = new TeacherDashboard();
                try {
                    stage.close();
                    tDash.start(stage, emailId);
                } catch (Exception ex) {
                    Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Button btn1 = new Button("SUBMIT");
        btn1.setTranslateX(1300);
        btn1.setTranslateY(800);
        btn1.setPrefSize(180, 50);
        btn1.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Window owner = btn1.getScene().getWindow();
                if (tf1.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter a quiz name");
                    return;
                }
                if (tf2.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter the total number of questions");
                    return;
                }
                if (tf3.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter a quiz description");
                    return;
                }
                if (r1.isSelected() == false && r2.isSelected() == false && r3.isSelected() == false) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter a difficulty level");
                    return;
                }

                String quizName = tf1.getText();
                String totalQuestions = tf2.getText();
                String description = tf3.getText();
                String difficulty = selected;

                CreateQuizDao cqDao = new CreateQuizDao();
                try {
                    String teacher = cqDao.getTeacherName(emailId);
                    Boolean verify = cqDao.verify(quizName, teacher, emailId);
                    if (verify == false) {
                        //cqDao.insertInfo(quizName, Integer.parseInt(totalQuestions), teacher, description, difficulty);
                        CreateQuiz cq = new CreateQuiz();
                        cq.start(stage, quizName, totalQuestions, teacher, description, difficulty, emailId);
                    }
                    if (verify == true) {
                        Project.showAlert(Alert.AlertType.CONFIRMATION, owner, "Attention", "Please enter a different quiz name");
                        //cqDao.insertQuiz();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(CreateQuizInfo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(CreateQuizInfo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Group root = new Group(l, view, l1, tf1, l2, tf2, l3, tf3, l4, r1, r2, r3, btn, btn1);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);
        stage.setTitle("Create Quiz");
        stage.setScene(scene);
        scene.setRoot(root);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class CreateQuiz extends Application {

    static int questionNumber = 0;
    int temp;
    String selected = "";

    public void start(Stage stage, String quizName, String totalQuestions, String teacher, String description, String difficulty, String emailId) throws Exception {

        Label l = new Label("CREATE QUIZ");
        l.setTranslateX(800);
        l.setTranslateY(50);
        l.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-underline: true; -fx-text-fill: AQUA");

        Image img1 = new Image("project/quiz.png");
        ImageView view = new ImageView(img1);
        view.setX(50);
        view.setY(150);
        view.setFitHeight(750);
        view.setFitWidth(500);

        temp = questionNumber + 1;
        Label l1 = new Label("ENTER QUESTION " + temp + " :");
        l1.setTranslateX(800);
        l1.setTranslateY(200);
        l1.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

        TextField quest = new TextField();
        quest.setTranslateX(1100);
        quest.setTranslateY(190);
        quest.setPrefSize(600, 30);
        quest.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26;");

        Label l2 = new Label("OPTION 1:");
        l2.setTranslateX(800);
        l2.setTranslateY(350);
        l2.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

        TextField op1 = new TextField();
        op1.setTranslateX(1000);
        op1.setTranslateY(340);
        op1.setPrefSize(200, 20);
        op1.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26");

        Label l3 = new Label("OPTION 2:");
        l3.setTranslateX(1400);
        l3.setTranslateY(350);
        l3.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

        TextField op2 = new TextField();
        op2.setTranslateX(1600);
        op2.setTranslateY(340);
        op2.setPrefSize(200, 20);
        op2.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26");

        Label l4 = new Label("OPTION 3:");
        l4.setTranslateX(800);
        l4.setTranslateY(500);
        l4.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

        TextField op3 = new TextField();
        op3.setTranslateX(1000);
        op3.setTranslateY(490);
        op3.setPrefSize(200, 20);
        op3.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26");

        Label l5 = new Label("OPTION 4:");
        l5.setTranslateX(1400);
        l5.setTranslateY(500);
        l5.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

        TextField op4 = new TextField();
        op4.setTranslateX(1600);
        op4.setTranslateY(490);
        op4.setPrefSize(200, 20);
        op4.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26");

        Label l6 = new Label("ENTER ANSWER :");
        l6.setTranslateX(800);
        l6.setTranslateY(650);
        l6.setStyle("-fx-font-weight: bold; -fx-font-size: 28; -fx-text-fill: WHITE");

        RadioButton ans1 = new RadioButton("option1");
        ans1.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: White");
        ans1.setTranslateX(1100);
        ans1.setTranslateY(650);

        RadioButton ans2 = new RadioButton("option2");
        ans2.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: White");
        ans2.setTranslateX(1400);
        ans2.setTranslateY(650);

        RadioButton ans3 = new RadioButton("option3");
        ans3.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: White");
        ans3.setTranslateX(1100);
        ans3.setTranslateY(750);

        RadioButton ans4 = new RadioButton("option4");
        ans4.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: White");
        ans4.setTranslateX(1400);
        ans4.setTranslateY(750);

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


        /*TextField ans = new TextField();
         ans.setTranslateX(1100);
         ans.setTranslateY(640);
         ans.setPrefSize(250, 20);
         ans.setStyle("-fx-text-box-border: AQUA; -fx-font-size: 26;");*/

        /*Button btn = new Button("BACK");
         btn.setTranslateX(850);
         btn.setTranslateY(750);
         btn.setPrefSize(180, 50);
         btn.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");*/
        Button btn1 = new Button("NEXT");
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

                CreateQuizDao cqDao = new CreateQuizDao();

                try {
                    cqDao.insertQuiz(quizName, Integer.parseInt(totalQuestions), questionNumber, teacher, emailId, description, difficulty, question, option1, option2, option3, option4, answer);
                } catch (SQLException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (questionNumber < Integer.parseInt(totalQuestions)) {
                    CreateQuiz cq = new CreateQuiz();
                    try {
                        infoBox("Record Inserted Succesfully!", null, "Passed");
                        cq.start(stage, quizName, totalQuestions, teacher, description, difficulty, emailId);
                    } catch (Exception ex) {
                        Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    infoBox("Quiz Created Succesfully!", null, "Passed");
                    stage.close();
                    ViewQuizzesDao vq = new ViewQuizzesDao();
                    try {
                        vq.display(emailId, "teacher");
                    } catch (SQLException ex) {
                        Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
        );

        Group root = new Group(l, view, quest, op1, op2, op3, op4, ans1, ans2, ans3, ans4, btn1, l1, l2, l3, l4, l5, l6);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);
        stage.setTitle("Create Quiz");
        stage.setScene(scene);
        scene.setRoot(root);
        stage.show();
    }

    @Override

    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class StudentStart extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //System.out.println(getClass());

        Label user = new Label("REGISTER OR LOGIN");
        user.setStyle("-fx-font-weight: bold; -fx-font-size: 52; -fx-text-fill: White; -fx-underline: true;");
        user.setTranslateX(730);
        user.setTranslateY(100);

        Button btn1 = new Button("REGISTER");
        btn1.setStyle("-fx-background-color: white; -fx-font-size: 40; -fx-font-weight: bold; -fx-border-width: 5px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn1.setTranslateX(830);
        btn1.setTranslateY(400);
        btn1.setPrefSize(240, 90);

        Button btn2 = new Button("LOGIN");
        btn2.setStyle("-fx-background-color: white; -fx-font-size: 40; -fx-font-weight: bold; -fx-border-width: 5px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn2.setTranslateX(830);
        btn2.setTranslateY(600);
        btn2.setPrefSize(240, 90);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentRegister sReg = new StudentRegister();
                try {
                    sReg.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentLogin sLog = new StudentLogin();
                try {
                    sLog.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Image img1 = new Image("project/quiz.png");
        ImageView view1 = new ImageView(img1);
        view1.setX(50);
        view1.setY(150);
        view1.setFitHeight(750);
        view1.setFitWidth(500);

        ImageView view2 = new ImageView(img1);
        view2.setX(1380);
        view2.setY(150);
        view2.setFitHeight(750);
        view2.setFitWidth(500);

        Group root = new Group(view1, view2, user, btn1, btn2);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);

        stage.setTitle("Welcome to Quiz Application!");
        stage.setScene(scene);
        stage.show();
    }
}

class StudentRegister extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label l1 = new Label("STUDENT'S REGISTRATION");
        l1.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-text-fill: White; -fx-underline: true;");
        l1.setTranslateX(750);
        l1.setTranslateY(30);

        Label lbFullName = new Label("Full Name: ");
        lbFullName.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbFullName.setTranslateX(650);
        lbFullName.setTranslateY(150);

        TextField txtFullName = new TextField();
        txtFullName.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtFullName.setPrefWidth(600);
        txtFullName.setMaxWidth(400);
        txtFullName.setTranslateX(900);
        txtFullName.setTranslateY(150);

        Label lbInstitute = new Label("Institute: ");
        lbInstitute.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbInstitute.setTranslateX(650);
        lbInstitute.setTranslateY(250);

        TextField txtInstitute = new TextField();
        txtInstitute.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtInstitute.setPrefWidth(400);
        txtInstitute.setMaxWidth(400);
        txtInstitute.setTranslateX(900);
        txtInstitute.setTranslateY(250);

        Label lbYear = new Label("Year of Graduation: ");
        lbYear.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbYear.setTranslateX(650);
        lbYear.setTranslateY(350);

        TextField txtYear = new TextField();
        txtYear.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtYear.setPrefWidth(400);
        txtYear.setMaxWidth(400);
        txtYear.setTranslateX(900);
        txtYear.setTranslateY(350);

        Label lbEmailId = new Label("Email ID: ");
        lbEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbEmailId.setTranslateX(650);
        lbEmailId.setTranslateY(450);

        TextField txtEmailId = new TextField();
        txtEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtEmailId.setPrefWidth(400);
        txtEmailId.setMaxWidth(400);
        txtEmailId.setTranslateX(900);
        txtEmailId.setTranslateY(450);

        Label lbPassword = new Label("Password: ");
        lbPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbPassword.setTranslateX(650);
        lbPassword.setTranslateY(550);

        TextField txtPassword = new TextField();
        txtPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtPassword.setPrefWidth(400);
        txtPassword.setMaxWidth(400);
        txtPassword.setTranslateX(900);
        txtPassword.setTranslateY(550);

        Image img1 = new Image("project/quiz.png");
        ImageView view1 = new ImageView(img1);
        view1.setX(50);
        view1.setY(150);
        view1.setFitHeight(750);
        view1.setFitWidth(500);

        Button btn3 = new Button("SUBMIT");
        btn3.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn3.setTranslateX(900);
        btn3.setTranslateY(700);
        btn3.setPrefSize(180, 50);

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Window owner = btn3.getScene().getWindow();
                if (txtFullName.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your name");
                    return;
                }
                if (txtInstitute.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your institute name");
                    return;
                }
                if (txtYear.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your year of graduation");
                    return;
                }
                if (txtEmailId.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your email id");
                    return;
                }
                if (txtPassword.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter a password");
                    return;
                }

                String fullName = txtFullName.getText();
                String institute = txtInstitute.getText();
                String year = txtYear.getText();
                String emailId = txtEmailId.getText();
                String password = txtPassword.getText();
                StudentRegisterDao sRegisterDao = new StudentRegisterDao();

                try {
                    Boolean verify = sRegisterDao.verify(emailId);
                    if (verify == false) {
                        try {
                            sRegisterDao.insertRecord(fullName, institute, year, emailId, password);
                        } catch (SQLException ex) {
                            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        infoBox("Welcome " + txtFullName.getText(), null, "Registration Successful!");
                        StudentLogin sLog = new StudentLogin();
                        try {
                            sLog.start(stage);
                        } catch (Exception ex) {
                            Logger.getLogger(StudentRegister.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (verify == true) {
                        infoBox("User with the entered email-id has already been registered!", null, "Attention");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StudentRegister.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        Button btn4 = new Button("LOGIN");
        btn4.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn4.setTranslateX(900);
        btn4.setTranslateY(850);
        btn4.setPrefSize(180, 50);

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentLogin sLog = new StudentLogin();
                try {
                    sLog.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(StudentRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Group root = new Group(view1, l1, lbFullName, txtFullName, lbInstitute, txtInstitute, lbYear, txtYear, lbEmailId, txtEmailId, lbPassword, txtPassword, btn3, btn4);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);
        stage.setTitle("Student's Registration Page");
        stage.setScene(scene);
        stage.show();
    }
}

class StudentLogin extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label l1 = new Label("STUDENT'S LOGIN");
        l1.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-text-fill: White; -fx-underline: true;");
        l1.setTranslateX(800);
        l1.setTranslateY(30);

        Label lbEmailId = new Label("Email ID: ");
        lbEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbEmailId.setTranslateX(700);
        lbEmailId.setTranslateY(250);

        TextField txtEmailId = new TextField();
        txtEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtEmailId.setPrefWidth(400);
        txtEmailId.setMaxWidth(400);
        txtEmailId.setTranslateX(900);
        txtEmailId.setTranslateY(250);

        Label lbPassword = new Label("Password: ");
        lbPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbPassword.setTranslateX(700);
        lbPassword.setTranslateY(400);

        TextField txtPassword = new TextField();
        txtPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtPassword.setPrefWidth(400);
        txtPassword.setMaxWidth(400);
        txtPassword.setTranslateX(900);
        txtPassword.setTranslateY(400);

        Image img1 = new Image("project/quiz.png");
        ImageView view1 = new ImageView(img1);
        view1.setX(50);
        view1.setY(150);
        view1.setFitHeight(750);
        view1.setFitWidth(500);

        Button btn3 = new Button("LOGIN");
        btn3.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn3.setTranslateX(880);
        btn3.setTranslateY(570);
        btn3.setPrefSize(180, 50);

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Window owner = btn3.getScene().getWindow();
                if (txtEmailId.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your email id");
                    return;
                }
                if (txtPassword.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter a password");
                    return;
                }

                String emailId = txtEmailId.getText();
                String password = txtPassword.getText();
                StudentLoginDao sLoginDao = new StudentLoginDao();
                boolean flag;
                try {
                    flag = sLoginDao.validate(emailId, password);
                    if (!flag) {
                        infoBox("Please enter correct Email and Password", null, "Failed");
                    } else {
                        infoBox("Login Successful!", null, "Passed");
                        StudentDashboard sDash = new StudentDashboard();
                        try {
                            sDash.start(stage, emailId);
                        } catch (Exception ex) {
                            Logger.getLogger(StudentLogin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        stage.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        Button btn4 = new Button("RESET PASSWORD");
        btn4.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em;");
        btn4.setTranslateX(480);
        btn4.setTranslateY(750);
        btn4.setPrefSize(350, 50);

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentResetPassword sResP = new StudentResetPassword();
                try {
                    sResP.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(StudentLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Button btn5 = new Button("REGISTER");
        btn5.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em;");
        btn5.setTranslateX(1100);
        btn5.setTranslateY(750);
        btn5.setPrefSize(250, 50);

        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentRegister sReg = new StudentRegister();
                try {
                    sReg.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(StudentLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Group root = new Group(view1, l1, lbEmailId, txtEmailId, lbPassword, txtPassword, btn3, btn4, btn5);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);

        stage.setTitle("Student's Login Page");
        stage.setScene(scene);
        stage.show();
    }
}

class StudentResetPassword extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label l1 = new Label("RESET PASSWORD");
        l1.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-text-fill: White; -fx-underline: true;");
        l1.setTranslateX(780);
        l1.setTranslateY(30);

        Label lbEmailId = new Label("Email ID: ");
        lbEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbEmailId.setTranslateX(650);
        lbEmailId.setTranslateY(200);

        TextField txtEmailId = new TextField();
        txtEmailId.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtEmailId.setPrefWidth(600);
        txtEmailId.setMaxWidth(400);
        txtEmailId.setTranslateX(900);
        txtEmailId.setTranslateY(200);

        Label lbCurrentPassword = new Label("Current Password: ");
        lbCurrentPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbCurrentPassword.setTranslateX(650);
        lbCurrentPassword.setTranslateY(400);

        TextField txtCurrentPassword = new TextField();
        txtCurrentPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtCurrentPassword.setPrefWidth(400);
        txtCurrentPassword.setMaxWidth(400);
        txtCurrentPassword.setTranslateX(900);
        txtCurrentPassword.setTranslateY(400);

        Label lbNewPassword = new Label("New Password: ");
        lbNewPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 26; -fx-text-fill: White;");
        lbNewPassword.setTranslateX(650);
        lbNewPassword.setTranslateY(600);

        TextField txtNewPassword = new TextField();
        txtNewPassword.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-box-border: AQUA");
        txtNewPassword.setPrefWidth(400);
        txtNewPassword.setMaxWidth(400);
        txtNewPassword.setTranslateX(900);
        txtNewPassword.setTranslateY(600);

        Image img1 = new Image("project/quiz.png");
        ImageView view1 = new ImageView(img1);
        view1.setX(50);
        view1.setY(150);
        view1.setFitHeight(750);
        view1.setFitWidth(500);

        Button btn3 = new Button("RESET");
        btn3.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-border-width: 4px; -fx-border-color: AQUA; -fx-font-size: 2em; -fx-font-weight: bold;");
        btn3.setTranslateX(900);
        btn3.setTranslateY(800);
        btn3.setPrefSize(180, 50);

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Window owner = btn3.getScene().getWindow();
                if (txtEmailId.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your email id");
                    return;
                }
                if (txtCurrentPassword.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your current password");
                    return;
                }
                if (txtNewPassword.getText().isEmpty()) {
                    Project.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "Please enter your new password");
                    return;
                }
                String emailId = txtEmailId.getText();
                String currentPassword = txtCurrentPassword.getText();
                String newPassword = txtNewPassword.getText();
                StudentResetPasswordDao sResetPasswordDao = new StudentResetPasswordDao();
                boolean flag;
                try {
                    flag = sResetPasswordDao.validate(emailId, currentPassword);
                    if (!flag) {
                        infoBox("Please enter correct Email and current Password", null, "Failed");
                    } else {
                        sResetPasswordDao.updateRecord(emailId, newPassword);
                        Project.showAlert(Alert.AlertType.CONFIRMATION, owner, "Success",
                                "Password Reset Successfully!");
                        StudentLogin sLog = new StudentLogin();
                        try {
                            sLog.start(stage);
                        } catch (Exception ex) {
                            Logger.getLogger(StudentResetPassword.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Group root = new Group(view1, l1, lbEmailId, txtEmailId, lbCurrentPassword, txtCurrentPassword, lbNewPassword, txtNewPassword, btn3);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);

        stage.setTitle("Student's Reset Password Page");
        stage.setScene(scene);
        stage.show();
    }
}

class StudentDashboard extends Application {

    public void start(Stage stage1, String emailId) throws Exception {

        Stage stage = new Stage();
        Label l = new Label("STUDENT'S DASHBOARD");
        l.setTranslateX(750);
        l.setTranslateY(80);
        l.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-underline: true; -fx-text-fill: AQUA");

        Image img1 = new Image("project/quiz.png");
        ImageView view = new ImageView(img1);
        view.setX(50);
        view.setY(150);
        view.setFitHeight(750);
        view.setFitWidth(500);

        Button b1 = new Button("VIEW QUIZZES");
        b1.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
        b1.setTranslateX(800);
        b1.setTranslateY(300);
        b1.setPrefSize(300, 70);
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewQuizzesDao vq = new ViewQuizzesDao();
                try {
                    String user = "student";
                    vq.display(emailId, user);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Button b2 = new Button("VIEW RESULTS");
        b2.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
        b2.setTranslateX(800);
        b2.setTranslateY(450);
        b2.setPrefSize(300, 70);
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentResultDao res = new StudentResultDao();
                try {
                    res.display(emailId);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Button b3 = new Button("LOGOUT");
        b3.setStyle("-fx-background-color: white; -fx-border-width: 2px; -fx-font-size: 2em; -fx-font-weight: bold;");
        b3.setTranslateX(800);
        b3.setTranslateY(600);
        b3.setPrefSize(300, 70);
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SelectUser user = new SelectUser();
                try {
                    stage.close();
                    Stage stage1 = new Stage();
                    user.start(stage1);
                    infoBox("Logout Successful!", null, "Passed");
                } catch (Exception ex) {
                    Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        Group root = new Group(l, view, b1, b2, b3);
        Scene scene = new Scene(root, 3050, 1100, Color.BLACK);
        stage.setTitle("Student's Dashboard");
        stage.setScene(scene);
        scene.setRoot(root);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class StudentStartQuiz extends Application {

    public void start(String value1, String value2, String value3, String emailId, String user) throws Exception {
        QuizDescriptionDao qdd = new QuizDescriptionDao();
        qdd.display(value1, value2, value3, 1, emailId, user);
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

public class Project extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Start start = new Start();
        start.start(stage);
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
