package Logic;

import java.sql.SQLException;

/**
 * Абстракный класс-оснвоа для контроллера сцены, используется для стандартизации доступа,
 * установки сцены в фрейм и управление сценами из приложения. Наследуется всеми контролерами
 */
public abstract class PageController {
    private final int WIDTH = 1000;
    private final int HEIGHT = 600;
    protected AppController ai = null;

    /**
     * Метод определяющий имя сцены
     *
     * @return
     */
    public abstract String getStageName();

    /**
     * Метод утсановки контроллера приложения, использующегося для доступа к фрейму из сцены
     *
     * @param ai Приложение, унаследовавшее интерфейс
     */
    public void setAI(AppController ai) {
        this.ai = ai;
    }

    public AppController getAI() {
        return ai;
    }

    /**
     * Метод инициалиации
     *
     * @throws SQLException
     */
    public abstract void init() throws SQLException;

    /**
     * Метод получения ширины с дефолтным значением
     *
     * @return ширину сцены
     */
    public int getWIDTH() {
        return WIDTH;
    }

    /**
     * Метод получения высоты с дефолтным значеним
     *
     * @return высоту сцены
     */
    public int getHEIGHT() {
        return HEIGHT;
    }

}
