package aliveInterface;

import innerInterface.IntonationStatus;
import innerInterface.Phrase;

public interface Phrasable {

    void toSay(Phrase aPhrase);

    void setPhraseFeeling(IntonationStatus aIntonationStatus);

    String getPhraseContent();

    IntonationStatus getPhraseFeeling();
}
