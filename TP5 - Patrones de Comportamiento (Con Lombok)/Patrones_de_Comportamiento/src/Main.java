import chain_of_Responsibility.Chain_Of_Responsibility;
import command.Command;
import iterator.Iterator;
import mediator.Mediator;
import memento.MementoMain;
import observer.ObserverMain;
import state.State;
import strategy.Strategy;
import template_Method.Temple_Method;
import visitor.Visitor;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n= = = = Chain Of Responsibility = = = =\n");
        Chain_Of_Responsibility.main(null);

        System.out.println("\n= = = = Command = = = =\n");
        Command.main(null);

        System.out.println("\n= = = = Iterator = = = =\n");
        Iterator.main(null);

        System.out.println("\n= = = = Mediator = = = =\n");
        Mediator.main(null);

        System.out.println("\n= = = = Memento = = = =\n");
        MementoMain.main(null);

        System.out.println("\n= = = = Observer = = = =\n");
        ObserverMain.main(null);

        System.out.println("\n= = = = State = = = =\n");
        State.main(null);

        System.out.println("\n= = = = Strategy = = = =\n");
        Strategy.main(null);

        System.out.println("\n= = = = Temple Method = = = =\n");
        Temple_Method.main(null);

        System.out.println("\n= = = = Visitor = = = =\n");
        Visitor.main(null);
    }
}