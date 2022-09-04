package com.serenityjpa.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InteractWithDatabase implements Ability {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public InteractWithDatabase() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager(){
        return this.entityManager;
    }

    public static InteractWithDatabase toDoOperations(){
        return new InteractWithDatabase();
    }

    public static InteractWithDatabase as(Actor actor){
        return actor.abilityTo(InteractWithDatabase.class);
    }
}
