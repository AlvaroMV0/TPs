import ChainOfResponsibility.MainCom;
import Command.MainCommand;
import Iterator.MainIterator;
import Mediator.MainMediator;
import Memento.MainMemento;
import Observer.MainObserver;
import State.MainState;
import Strategy.MainStrategy;
import Template.MainTemplate;
import Visitor.MainVisitor;


public class Main {
    public static void main(String[] args) {

        MainCom.main(args);
        MainCommand.main(args);
        MainIterator.main(args);
        MainMediator.main(args);
        MainMemento.main(args);
        MainObserver.main(args);
        MainState.main(args);
        MainStrategy.main(args);
        MainTemplate.main(args);
        MainVisitor.main(args);

    }
}