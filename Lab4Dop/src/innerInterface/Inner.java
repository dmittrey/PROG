package innerInterface;

/**
 * Интерфейс для внутренних вещей человека
 * <p>
 * Реализованы методы:
 * <p>
 * String getContent()
 * <p>
 * String getFeeling()
 */

public interface Inner {

    String getContent();

    String getFeeling();

    void setFeeling(String aFeeling);

    void setContent(String aContent);
}
