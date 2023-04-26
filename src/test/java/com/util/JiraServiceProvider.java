package com.util;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {
	public JiraClient jira;
	public String project;
	
	public JiraServiceProvider(String jiraUrl, String username, String password, String project)
	{
		BasicCredentials creds = new BasicCredentials(username, password);
		jira=new JiraClient(jiraUrl,creds);
		this.project=project;
	}
	
	public void CreateJiraTicket(String issuetype, String summary, String description, String reporterName)
	{
		 try {
			FluentCreate fluentCreate = jira.createIssue(project, issuetype);
			fluentCreate.field(Field.SUMMARY, summary);
			fluentCreate.field(Field.DESCRIPTION, description);
			Issue newIssue = fluentCreate.execute();
			System.out.println("New issue created in jira with ID: "+newIssue);
			
		} catch (JiraException e) {
			
			e.printStackTrace();
		}
	}

}
