import chain_of_Responsibility.Chain_Of_Responsibility_Main;
import command.CommandMain;
import iterator.IteratorMain;
import mediator.MediatorMain;
import memento.MementoMain;
import observer.ObserverMain;
import state.StateMain;
import strategy.StrategyMain;
import template_Method.Temple_Method_Main;
import visitor.VisitorMain;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n= = = = Chain Of Responsibility = = = =\n");
        Chain_Of_Responsibility_Main.main(null);

        System.out.println("\n= = = = Command = = = =\n");
        CommandMain.main(null);

        System.out.println("\n= = = = Iterator = = = =\n");
        IteratorMain.main(null);

        System.out.println("\n= = = = Mediator = = = =\n");
        MediatorMain.main(null);

        System.out.println("\n= = = = Memento = = = =\n");
        MementoMain.main(null);

        System.out.println("\n= = = = Observer = = = =\n");
        ObserverMain.main(null);

        System.out.println("\n= = = = State = = = =\n");
        StateMain.main(null);

        System.out.println("\n= = = = Strategy = = = =\n");
        StrategyMain.main(null);

        System.out.println("\n= = = = Temple Method = = = =\n");
        Temple_Method_Main.main(null);

        System.out.println("\n= = = = Visitor = = = =\n");
        VisitorMain.main(null);
    }
}