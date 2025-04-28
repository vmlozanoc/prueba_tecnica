package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class WaitExplicit implements Interaction {
    private final int time;

    public WaitExplicit(int time){
        this.time = time;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       try {
           Thread.sleep(time);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
    }

    public static WaitExplicit waitExplicit( int time) {
        return Tasks.instrumented(WaitExplicit.class, time);
    }
}
