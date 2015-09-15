package com.lits.javaTeamWork;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class testWorkers {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		  // JSON Jackson Parser
		  System.out.println("----------JSON Jackson Parser----------");
		  TeamProjectParser jacksonParser = new TeamProjectParser();
		  List<Workers> someData2 = jacksonParser.ParseJsonUsingJackson();
		  System.out.println("----------Sorted JSON Jackson Parser Data----------");
		  //Collections.sort(someData2, new EmployeeComparator());

		  for (Workers employer : someData2) {

		   System.out.println("JACKSON --" + " \"Last Name\": " + employer.getName() + " \"Position\": "
		     + employer.getPosition() + " \"Salary\": " + employer.getSalary());
		  }
	}
}
