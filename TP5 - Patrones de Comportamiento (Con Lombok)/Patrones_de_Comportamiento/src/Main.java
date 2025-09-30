import chain_of_Responsibility.MainCOR;
import command.MainCommand;
import iterator.MainIterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n= = = = Chain Of Responsibility = = = =\n");
        MainCOR.main(null);

        System.out.println("\n= = = = Command = = = =\n");
        MainCommand.main(null);

        System.out.println("\n= = = = Iterator = = = =\n");
        MainIterator.main(null);

    }
}