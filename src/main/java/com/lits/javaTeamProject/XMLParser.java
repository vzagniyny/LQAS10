package com.lits.javaTeamProject;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    @Test
    public List<com.lits.javaTeamProject.dto.Employee> ParseXML() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(ClassLoader.getSystemResourceAsStream("Untitled.xml"));

        List<Employee> empList = new ArrayList<>();

        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Employee emp = new Employee();
                emp.id = node.getAttributes().getNamedItem("id").getNodeValue();

                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().getTextContent().trim();
                        switch (cNode.getNodeName()) {
                            case "lastName":
                                emp.lastName = content;
                                break;
                            case "position":
                                emp.position = content;
                                break;
                            case "salary":
                                emp.salary = content;
                                break;
                        }
                    }
                }
                empList.add(emp);
            }
        }

        List<com.lits.javaTeamProject.dto.Employee> employeeList = new ArrayList<>();
        for (Employee emp : empList) {
            String lastName = emp.lastName;
            String position = emp.position;
            String salary = emp.salary;
            employeeList.add(new com.lits.javaTeamProject.dto.Employee(lastName, position, salary));
            System.out.println("XMLParser -- " + lastName + "--" + position + "--" + salary);
        }
        return employeeList;
    }
}

class Employee {
    String id;
    String lastName;
    String position;
    String salary;
}