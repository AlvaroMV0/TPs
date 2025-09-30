package command;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor

public class Invoker {
    @Setter
    private CommandInterface commandInterface;
    public void execute(){
        commandInterface.execute();
    }
}
