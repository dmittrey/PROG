package aliveInterface;

import innerInterface.Phrase;
import innerInterface.Think;

public interface Alive {
    void goTo(Object aPlace);

    void toSay(Phrase aPhrase);

    void toThink(Think aThink);

    void setPhraseFeeling(String aFeeling);

    Object getCurrentPlace();

    String getThinkFeeling();

    String getThinkContent();

    String getPhraseContent();

    String getPhraseFeeling();


}
