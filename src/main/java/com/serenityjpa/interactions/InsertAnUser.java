package com.serenityjpa.interactions;

import com.serenityjpa.abilities.InteractWithDatabase;
import com.serenityjpa.database.entities.Users;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class InsertAnUser implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        EntityManager entityManager = InteractWithDatabase.as(actor).getEntityManager();
        Users newUser =  new Users(1, "Travis Barker", "travismail@email.com");
        entityManager.getTransaction().begin();
        entityManager.persist(newUser);
        entityManager.getTransaction().commit();
        actor.attemptsTo(GetUserList.fromDataBase());
        entityManager.close();
    }

    public static InsertAnUser intoUsersTable(){
        return Tasks.instrumented(InsertAnUser.class);
    }
}
