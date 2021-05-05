package aliveInterface;

import innerInterface.OpinionStatus;
import innerInterface.Think;

public interface Thinkable {

    void toThink(Think aThink);

    OpinionStatus getThinkFeeling();

    String getThinkContent();
}
