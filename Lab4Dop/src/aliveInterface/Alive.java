package aliveInterface;

/**
 * Интерфейс живых
 * <p>
 * Реализует методы:
 * <p>
 * void goTo(String aPlace) --- куда пойти
 * <p>
 * String toSay(Phrase aPhrase) --- что сказать
 * <p>
 * String toThink(Think aThink) --- что подумать
 * <p>
 * String getCurrentPlace() --- где находится
 */

import innerInterface.Phrase;
import innerInterface.Think;

public interface Alive {
    void goTo(Object aPlace);

    String toSay(Phrase aPhrase);

    String toThink(Think aThink);

    String getCurrentPlace();
}
