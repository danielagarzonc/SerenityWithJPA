package com.serenityjpa.interactions;

import com.serenityjpa.abilities.InteractWithDatabase;
import com.serenityjpa.database.entities.Users;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import javax.persistence.EntityManager;
import java.util.List;

public class GetUserList implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        EntityManager entityManager = InteractWithDatabase.as(actor).getEntityManager();
        String query = "FROM Users";
        List<Users> usersList = (List<Users>) entityManager.createQuery(query).getResultList();
        System.out.println(usersList);
    }

    public static GetUserList fromDataBase(){
        return Tasks.instrumented(GetUserList.class);
    }
}
