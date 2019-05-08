package org.utdallas.atos.training.recommendationengine.service;

import org.utdallas.atos.training.recommendationengine.model.Employees;
import org.utdallas.atos.training.recommendationengine.model.Skills;
import org.utdallas.atos.training.recommendationengine.model.Tools;
import org.utdallas.atos.training.recommendationengine.repository.EmployeesRepository;
import org.utdallas.atos.training.recommendationengine.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("Employees")
public class EmployeeServiceImpl {
    @Autowired
    EmployeesRepository employeesRepository;

    @Transactional
    public void addSkillToEmployee(Skills skill, Employees employee )
    {
        Employees retrievedEmployee = employeesRepository.findAllByEmailAddressContaining(employee.getEmailAddress()).get(0);

        List<Skills> listOfSkills = new ArrayList<>(retrievedEmployee.getSkills());

        if(listOfSkills.contains(skill))
        {
            System.out.println("The employee already contains that skill");
        }
        else
        {
            listOfSkills.add(skill);
            retrievedEmployee.setSkills(listOfSkills);
            employeesRepository.save(retrievedEmployee);
        }
    }

    @Transactional
    public void addToolToEmployee(Tools tool, Employees employee )
    {

        Employees retrievedEmployee = employeesRepository.findAllByEmailAddressContaining(employee.getEmailAddress()).get(0);
        List<Tools> listOfTools  = retrievedEmployee.getTools();

        if(listOfTools.contains(tool))
        {
            System.out.println("The employee already contains that tool");
        }
        else
        {
            listOfTools.add(tool);
            retrievedEmployee.setTools(listOfTools);
            employeesRepository.save(retrievedEmployee);
        }
    }

    @Transactional
    public void saveEmployee(Employees employees)
    {
        //List<Employees> employeesList = employeesRepository.findAllByEmailAddressContaining(employees.getEmailAddress());

        boolean flag = employeesRepository.existsByEmailAddress(employees.getEmailAddress());
        if(flag == true)
        {

        }
        else
        {
            employeesRepository.save(employees);
        }

    }


    public List<Skills> removeLearnedSkills(List<Skills> skillsToCheck, Employees employees)
    {
        List<Skills> learnedSkills = employeesRepository.findAllByEmailAddressContaining(employees.getEmailAddress()).get(0).getSkills();
        List<Skills> skillsToReturn = new ArrayList<>(skillsToCheck);

        for (Skills skillToCheck: skillsToCheck)
        {
            if(learnedSkills != null && learnedSkills.contains(skillToCheck))
            {
                skillsToReturn.remove(skillToCheck);
            }
        }
        return skillsToReturn;
    }

    public List<Tools> removeLearnedTools(List<Tools> toolsToCheck, Employees employees)
    {
        List<Tools> learnedTools = employeesRepository.findAllByEmailAddressContaining(employees.getEmailAddress()).get(0).getTools();
        List<Tools> toolsToReturn = new ArrayList<>(toolsToCheck);

        for (Tools toolToCheck: toolsToCheck)
        {
            if(learnedTools != null && learnedTools.contains(toolToCheck))
            {
                toolsToReturn.remove(toolToCheck);
            }
        }
        return toolsToReturn;
    }

}
