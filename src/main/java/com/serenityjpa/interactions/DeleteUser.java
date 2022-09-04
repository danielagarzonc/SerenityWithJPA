package com.serenityjpa.interactions;

import com.serenityjpa.abilities.InteractWithDatabase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import javax.persistence.EntityManager;

public class DeleteUser implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        EntityManager entityManager = InteractWithDatabase.as(actor).getEntityManager();
        String deleteQuery = "DELETE FROM Users WHERE id='1'";
        entityManager.getTransaction().begin();
        entityManager.createQuery(deleteQuery).executeUpdate();
        entityManager.getTransaction().commit();
        actor.attemptsTo(GetUserList.fromDataBase());
        entityManager.close();
    }

    public static DeleteUser fromTable(){
        return Tasks.instrumented(DeleteUser.class);
    }
}
