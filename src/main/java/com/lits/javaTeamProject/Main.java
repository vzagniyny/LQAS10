package com.lits.javaTeamProject;

import com.fasterxml.jackson.core.JsonParseException;
import com.lits.javaTeamProject.comparator.EmployeeComparator;
import com.lits.javaTeamProject.dto.EmployeeDTO;
import com.lits.javaTeamProject.parcer.JsonParser;

import java.io.IOException;
import java.util.Collections;

/**
 * Created by yuraku on 9/15/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        JsonParser parser = new JsonParser();

        try {
            Collections.sort(parser.ParseJsonUsingJackson(), new EmployeeComparator());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
