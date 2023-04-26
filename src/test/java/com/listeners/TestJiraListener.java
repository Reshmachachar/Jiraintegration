package com.listeners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.util.JiraPolicy;
import com.util.JiraServiceProvider;

public class TestJiraListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTicketReady = jiraPolicy.logTicketReady();
		
		if(isTicketReady)
		{
			//raise jira ticket:
			System.out.println("is ticket ready for jira :"+isTicketReady);
			JiraServiceProvider jiraSp= new JiraServiceProvider("https://123rajani.atlassian.net", "mayur.patil1@cogniwize.com", "ATATT3xFfGF0Z25wz1uK5jFFSzAIa9oYf_e_-gEcQpKWlp6M7eWSCBZHAUhRz6Q9Lsn35XQeREXVMvBDAVz6990tPcU6iCNvwbkkOJS4tx6iIazlSsCFvIWzeVcq1oOALy8UV3ThP9gFDGrMXE4_GTdiBLP1yAQJCbMyFusg_ENIUCl0af4Sjmk=0A37FAA5", "CHER");
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + "got failed due to some assertion failed or exceptions.";
			
			String issueDescription = result.getThrowable().getMessage()+"\n";
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			
			jiraSp.CreateJiraTicket("Task",issueSummary, issueDescription, "Mayur Patil1");
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
	
	

}
