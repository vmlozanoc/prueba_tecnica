
package questions;
import interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;


public class ValidateObject implements Question<Boolean> {
    public final Target objet;

    public ValidateObject(Target objet) {
        this.objet = objet;
    }

    @Override
    public Boolean answeredBy(Actor actor) {


        boolean flag = false;

        actor.attemptsTo(Wait.forVisibility(objet,10));

        if (objet.resolveFor(actor).isClickable()) {
            flag = true;
        }else{
            throw new AssertionError("No se encontro el selector: "+objet);
        }

        return flag;

    }


    public static ValidateObject validateObject(Target objet) {
        return new ValidateObject(objet);
    }
}

