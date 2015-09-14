package com.lits.javaTeamWork;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class TeamProjectParser {
	public List<Workers> ParseJsonUsingJackson() throws JsonParseException, JsonMappingException, IOException {
		InputStream input = new FileInputStream("test2JSON.json");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		TypeFactory typeFactory = TypeFactory.defaultInstance();

		List<Workers> workersList = new ArrayList<>();
		List<WorkersDTO> workers = objectMapper.readValue(input,
				typeFactory.constructCollectionType(ArrayList.class, WorkersDTO.class));

		for (int i = 0; i < workers.size(); i++) {
			String lastName = workers.get(i).getName();
			String position = workers.get(i).getPosition();
			String salary = workers.get(i).getSalary();

			workersList.add(new Workers(lastName, position, salary));
			// for test purposes
			//System.out.println("JacksonParserOutput: -- " + lastName + "--" + position + "--" + salary);
		}
		return workersList;
	}
}
