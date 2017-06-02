package Logic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Основной класс, концентартор приложения, отвечает за возможность смены сцен в приложении
 */
public class Main extends Application implements AppController {

    private Connection conn;
    private FXMLLoader loader;
    public Stage mainStage;
    private Parent root;
    private String currentUser;

    @Override
    public void start(Stage primaryStage) throws Exception {

        mainStage = primaryStage;
        this.travelToView("../loginView/LoginView.fxml");

    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Метод смены сцены приложения
     * @param viewLoaderName ориентир сцены для перехода
     * @throws IOException
     * @throws SQLException
     */
    @Override
    public void travelToView(String viewLoaderName) throws IOException, SQLException {

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(viewLoaderName));
        root = loader.load();

        PageController pci = (PageController) loader.getController();
        pci.setAI(this);
        pci.init();

        mainStage.setTitle(pci.getStageName());
        mainStage.setScene(new Scene(root, pci.getWIDTH(), pci.getHEIGHT()));
        mainStage.show();

    }

    @Override
    public void setConnection(Connection value) {
        this.conn = value;
    }

    /**
     * Метод, позволяющий закрыть приложение
     */
    @Override
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        mainStage.close();
    }

    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public void setLogin(String login) {
        this.currentUser = login;
    }

    @Override
    public String getLogin() {
        return currentUser;
    }

    @Override
    public Stage getStage(){
        return mainStage;
    }
}
