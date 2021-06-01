import utility.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner, false);
        CollectionManager collectionManager = new CollectionManager();
        Invoker invoker = new Invoker(console, collectionManager);
        CommandReader commandReader = new CommandReader(invoker, false);
        FileWorker fileWorker = new FileWorker(collectionManager, console);
        console.print(fileWorker.getFromXmlFormat());
        commandReader.enable();
        scanner.close();
    }
    //хз насчет автосортировки(выполняется ли она вообще)
    //идет странный отлов рекурсии(при втором запуске а не при первом)
    //пропуска не происходит(слава богу), точнее пропускаем только вызов скрипта
    //при вызове команды add из вложенного скрипта, теряется сканнер и начинаем выводить всякую хуету + не идет возврата в интерактивный режим
}
