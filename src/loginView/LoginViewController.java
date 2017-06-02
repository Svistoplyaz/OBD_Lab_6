package loginView;

import Logic.PageController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.TreeMap;

import oracle.jdbc.driver.*;

public class LoginViewController extends PageController {
    public TextField tb_login;
    public PasswordField tb_password;
    public Label lbl_status;

    public ProgressIndicator r_rotator;
    public ComboBox cb_accountType;

    private TreeMap<String, String> login_toUsername = new TreeMap<>();
    private final String viewName = "Авторизация";
    //private final int WIDTH = 600;
    //private final int HEIGHT = 400;

    public void onClickLogin(ActionEvent actionEvent) {
        Connection conn = null;

        try {

            Locale.setDefault(Locale.ENGLISH);
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    tb_login.getText(), tb_password.getText());
            ai.setLogin(tb_login.getText());


            ai.setConnection(conn);
            ai.travelToView("../DirectorView/DirectorView.fxml");

        } catch (SQLException e) {
            e.printStackTrace();
            lbl_status.setText("Wrong Authentication info!");
            tb_password.setText("");
        } catch (IOException e) {
            e.printStackTrace();
            lbl_status.setText("Can't load view");
            tb_password.setText("");
        } catch (RuntimeException e) {
            e.printStackTrace();
            lbl_status.setText("No such user registred");
            tb_password.setText("");
            tb_login.setText("");
        }

        if (conn == null) {
            System.out.println("Can't connect to DataBase!");
        }

    }

    public void onClickQuit(ActionEvent actionEvent) {
        ai.close();
    }

    @Override
    public String getStageName() {
        return viewName;
    }

    @Override
    public void init() {
        tb_login.setText("Alexandr");
        tb_password.setText("pass");
    }

}
