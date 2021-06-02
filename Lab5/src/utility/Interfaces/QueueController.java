package utility.Interfaces;

import java.util.Queue;

public interface QueueController {

    default void controlQueue(Queue<String> commands, String command) {
        if (commands.size() > 13) commands.remove();

        commands.add(command);
    }
}
