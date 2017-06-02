package Logic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Интерфейс управления приложением из текущей сцены, используется для навигации в приложении и доступа к общим
 * для нескольких сцен константам
 */
public interface AppController {

    /**
     * Метод смены сцены на заданную
     *
     * @param viewLoaderName ориентир сцены для перехода
     */
    public void travelToView(String viewLoaderName) throws IOException, SQLException;


    /**
     * Метод выхода из приложения через сцену
     */
    public void close();

    /**
     * Метод получения сцены-предка
     *
     * @return
     */

    public void setConnection(Connection value);

    public Connection getConnection();

    public void setLogin(String login);

    public String getLogin();

    public Stage getStage();
}
