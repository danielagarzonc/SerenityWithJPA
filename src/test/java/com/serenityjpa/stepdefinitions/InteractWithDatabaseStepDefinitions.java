package com.serenityjpa.stepdefinitions;

import com.serenityjpa.abilities.InteractWithDatabase;
import com.serenityjpa.interactions.DeleteUser;
import com.serenityjpa.interactions.InsertAnUser;
import com.serenityjpa.interactions.UpdateUserName;
import cucumber.api.java.en.Given;
import com.serenityjpa.interactions.GetUserList;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hibernate.sql.Update;

public class InteractWithDatabaseStepDefinitions {
    @Given("^(.*) get the users list$")
    public void administratorGetTheUsersList(String actor) {
        OnStage.theActorCalled(actor).whoCan(InteractWithDatabase.toDoOperations());
        OnStage.theActorInTheSpotlight().attemptsTo(GetUserList.fromDataBase());
    }

    @Given("^(.*) update data in the users list$")
    public void adminUpdateDataInTheUsersList(String actor) {
        OnStage.theActorCalled(actor).whoCan(InteractWithDatabase.toDoOperations());
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateUserName.inDatabase());

    }

    @Given("^(.*) deletes info from database$")
    public void adminDeletesInfoFromDatabase(String actor) {
        OnStage.theActorCalled(actor).whoCan(InteractWithDatabase.toDoOperations());
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteUser.fromTable());

    }

    @Given("^(.*) insert a new user into users table$")
    public void adminInsertANewUserIntoUsersTable(String actor) {
        OnStage.theActorCalled(actor).whoCan(InteractWithDatabase.toDoOperations());
        OnStage.theActorInTheSpotlight().attemptsTo(InsertAnUser.intoUsersTable());

    }
}
