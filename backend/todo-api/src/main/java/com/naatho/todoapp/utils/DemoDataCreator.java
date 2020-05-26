package com.naatho.todoapp.utils;

import com.naatho.todoapp.entity.*;
import com.naatho.todoapp.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;

@Component
public class DemoDataCreator {

    public static final String ADMIN_EMAIL = "admin@gmail.com";
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    Logger logger = LoggerFactory.getLogger(DemoDataCreator.class);


    @PostConstruct
    public void init() {
        // Custom logic to check if DB is already populated with dummy data
        User adminUser = userRepository.findByEmail(ADMIN_EMAIL);
        if (adminUser == null) {
            logger.info("Filling DB with some dummy data");
            Privilege projectManagement = new Privilege("PROJECT_MANAGEMENT");
            Privilege userManagement = new Privilege("USER_MANAGEMENT");
            privilegeRepository.saveAll(Arrays.asList(projectManagement, userManagement));

            Role userRole = new Role(Role.USER_ROLE);
            Role adminRole = new Role(Role.ADMIN_ROLE);
            adminRole.setPrivileges(Arrays.asList(projectManagement, userManagement));
            roleRepository.saveAll(Arrays.asList(userRole, adminRole));

            User frontEndDeveloper = new User("Front end guy", "fe@gmail.com", passwordEncoder.encode("frontendiscool"));
            frontEndDeveloper.setRoles(Arrays.asList(userRole));
            User backEndDeveloper = new User("Back end dude", "be@gmail.com", passwordEncoder.encode("backendiscool"));
            backEndDeveloper.setRoles(Arrays.asList(userRole));
            adminUser = new User("Admin Elek", ADMIN_EMAIL, passwordEncoder.encode("pwd2"));
            adminUser.setRoles(Arrays.asList(adminRole));
            userRepository.saveAll(Arrays.asList(frontEndDeveloper, backEndDeveloper, adminUser));

            Label importantLabel = new Label("IMPORTANT", "Important task!");
            Label notImportantLabel = new Label("NOT_IMPORTANT", "Maybe later...");
            labelRepository.saveAll(Arrays.asList(importantLabel, notImportantLabel));

            Project alkFejlProject = new Project("Alkfejl hazi", "This is pretty cool");
            alkFejlProject.setMembers(Arrays.asList(frontEndDeveloper, backEndDeveloper));
            projectRepository.saveAll(Arrays.asList(alkFejlProject));

            Task frontEndDev = new Task("Front end dev", frontEndDeveloper, alkFejlProject, "Qt is not so great", new Date(2020, 6, 26), Arrays.asList(importantLabel));
            Task backEndDev = new Task("Back end dev", backEndDeveloper, alkFejlProject, "Spring is great", new Date(2020, 6, 27), Arrays.asList(importantLabel));
            Task emailSender = new Task("Send email reminders", backEndDeveloper, alkFejlProject, "Use an SMTP server", new Date(2020, 6, 28), Arrays.asList(notImportantLabel));
            taskRepository.saveAll(Arrays.asList(frontEndDev, backEndDev, emailSender));
        } else {
            logger.info("The database already has data in it, so not populating it with more data");
        }
    }
}
