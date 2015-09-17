package com.lits.javaTeamProject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lits.javaTeamProject.comparator.EmployeeComparator;
import com.lits.javaTeamProject.dto.EmployeeDTO;
import com.lits.javaTeamProject.parcer.JsonParser;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.json.JSONException;

/**
 * Created by yuraku on 9/15/15.
 */
public class Main {
    public static void main(String[] args)
            throws Exception, JSONException, JsonParseException, JsonMappingException, IOException {

        // JSON Jackson Parser
        System.out.println("----------JSON Jackson Parser----------");
        JsonParser jacksonParser = new JsonParser();
        List<EmployeeDTO> someData2 = jacksonParser.ParseJsonUsingJackson();
        System.out.println("----------Sorted JSON Jackson Parser Data----------");
        Collections.sort(someData2, new EmployeeComparator());

        for (EmployeeDTO employer : someData2) {

            System.out.println("JACKSON --" + " \"Last Name\": " + employer.getName() + " \"Position\": "
                    + employer.getPosition() + " \"Salary\": " + employer.getSalary());
        }

        // XML Parser
        System.out.println("----------XML Parser----------");
        XMLParser xmlParser = new XMLParser();
        List<EmployeeDTO> someData3 = xmlParser.ParseXML();
        System.out.println("----------Sorted JSON Jackson Parser Data----------");
        Collections.sort(someData3, new EmployeeComparator());

        for (EmployeeDTO employer : someData3) {

            System.out.println("XML --" + " \"Last Name\": " + employer.getName() + " \"Position\": "
                    + employer.getPosition() + " \"Salary\": " + employer.getSalary());
        }
    }
}
