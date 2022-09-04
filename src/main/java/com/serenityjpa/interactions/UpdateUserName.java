package com.serenityjpa.interactions;

import com.serenityjpa.abilities.InteractWithDatabase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import javax.persistence.EntityManager;

public class UpdateUserName implements Interaction{
    @Override
    public <T extends Actor> void performAs(T actor) {
        EntityManager entityManager = InteractWithDatabase.as(actor).getEntityManager();
        String updateQuery = "UPDATE Users SET name = 'Paramore' where id=1";
        entityManager.getTransaction().begin();
        entityManager.createQuery(updateQuery).executeUpdate();
        entityManager.getTransaction().commit();
        actor.attemptsTo(GetUserList.fromDataBase());
        entityManager.close();
    }

    public static UpdateUserName inDatabase(){
        return Tasks.instrumented(UpdateUserName.class);
    }
}
