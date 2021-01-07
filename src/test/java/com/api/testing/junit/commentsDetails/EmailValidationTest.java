package com.api.testing.junit.commentsDetails;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.api.testing.cucumber.serenity.CommentsSerenitySteps;
import com.api.testing.cucumber.serenity.PostsSerenitySteps;
import com.api.testing.cucumber.serenity.UsersSerenitySteps;
import com.api.testing.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.UseTestDataFrom;

@UseTestDataFrom("testData\\userInfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class EmailValidationTest  extends TestBase{
	
	 private static String username;
		
		
	  public String getUsername()
	  { return username; }
	    
	  public void setUsername(String username)
	  { this.username = username; }
	
	CommentsSerenitySteps comser = new CommentsSerenitySteps();
	UsersSerenitySteps uSteps=new UsersSerenitySteps();
	PostsSerenitySteps pSteps=new PostsSerenitySteps();
	String userId = null;
	
	
	@WithTags(
			{
	@WithTag("usersfeature:INTEGRATION"),
	@WithTag("usersfeature:POSITIVE")
			}
	)
	@Title("This is to validate the format of all emails for each comment")
	@Test
	public void getCommentsIds()
	{
		userId= uSteps.getUserIdByUsername(username);
		comser.validateEmails(userId);
			
	}
}
	
	
