package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class NoExistValidator implements Question<Boolean> {

    public final Target objet;

    public NoExistValidator(Target objet) {
        this.objet = objet;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean flag = false;
        try {
            if (!objet.resolveFor(actor).isClickable()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new AssertionError("Se encontro el selector: " + objet);
        }

        return flag;
    }



    public static NoExistValidator noExistValidator(Target objet) {
        return new NoExistValidator(objet);
    }



}
