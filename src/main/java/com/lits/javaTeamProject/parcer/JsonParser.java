package com.lits.javaTeamProject.parcer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.lits.javaTeamProject.dto.Employee;
import com.lits.javaTeamProject.dto.EmployeeDTO;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    @Test
    public List<Employee> ParseJsonUsingJackson() throws JsonParseException, JsonMappingException, IOException {

        InputStream input = new FileInputStream("res/test2JSON.json");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        TypeFactory typeFactory = TypeFactory.defaultInstance();

        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeDTO> workers = objectMapper.readValue(input,
                typeFactory.constructCollectionType(ArrayList.class, EmployeeDTO.class));

        for (int i = 0; i < workers.size(); i++) {
            String lastName = workers.get(i).getName();
            String position = workers.get(i).getPosition();
            String salary = workers.get(i).getSalary();

            employeeList.add(new Employee(lastName, position, salary));
            // for test purposes
            System.out.println("JacksonParserOutput: -- " + lastName + "--" + position + "--" + salary);
        }
        return employeeList;
    }
}
