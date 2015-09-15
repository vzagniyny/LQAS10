package com.lits.javaTeamProject.comparator;

import com.lits.javaTeamProject.dto.EmployeeDTO;

import java.util.Comparator;

/**
 * Created by yuraku on 9/15/15.
 */
public class EmployeeComparator implements Comparator<EmployeeDTO> {

    @Override
    public int compare(EmployeeDTO o1, EmployeeDTO o2) {

        int result = o1.getName().compareTo(o2.getName());

        if (result == 0) {
            result = o1.getPosition().compareTo(o2.getPosition());
            if (result == 0) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        }
        return result;
    }
}

