package be.ehb.vermeirines.finalworkapi.controllers;

import be.ehb.vermeirines.finalworkapi.model.CCUser;
import be.ehb.vermeirines.finalworkapi.model.Resident;
import be.ehb.vermeirines.finalworkapi.model.ResidentialCareCenter;
import be.ehb.vermeirines.finalworkapi.repositories.CCUserRepository;
import be.ehb.vermeirines.finalworkapi.repositories.RccRepository;
import be.ehb.vermeirines.finalworkapi.repositories.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/database")
public class DatabaseController {

    @Autowired
    RccRepository rccRepository;
    @Autowired
    ResidentRepository residentRepository;
    @Autowired
    CCUserRepository ccUserRepository;

    @GetMapping("/init")
    public void initDatabase(){

        rccRepository.deleteAll();
        residentRepository.deleteAll();
        ccUserRepository.deleteAll();

        CCUser ccUser1Resident1Rcc1 = new CCUser();
        ccUser1Resident1Rcc1.setFullName("Pol De Tremmerie");
        ccUser1Resident1Rcc1.setTags(Arrays.asList(new String[]{"echtgenoot"}));
        ccUser1Resident1Rcc1.setId(106089);

        CCUser ccUser2Resident1Rcc1 = new CCUser();
        ccUser2Resident1Rcc1.setFullName("Billie Coppens");
        ccUser2Resident1Rcc1.setTags(Arrays.asList(new String[]{"zoon"}));
        ccUser2Resident1Rcc1.setId(106090);

        List<CCUser> ccUserListResident1Rcc1 = new ArrayList<>();
        ccUserListResident1Rcc1.add(ccUser1Resident1Rcc1);
        ccUserListResident1Rcc1.add(ccUser2Resident1Rcc1);

        Resident resident1Rcc1 = new Resident();
        resident1Rcc1.setRoomNumber("8");
        resident1Rcc1.setName("Doortje Van Hoeck");
        resident1Rcc1.setCcid(106081);
        resident1Rcc1.setCcusers(ccUserListResident1Rcc1);


        CCUser ccUser1Resident2Rcc1 = new CCUser();
        ccUser1Resident2Rcc1.setFullName("Bieke Crucke");
        ccUser1Resident2Rcc1.setTags(Arrays.asList(new String[]{"dochter", "Bea"}));
        ccUser1Resident2Rcc1.setId(106093);

        CCUser ccUser2Resident2Rcc1 = new CCUser();
        ccUser2Resident2Rcc1.setFullName("Paulien Vertongen");
        ccUser2Resident2Rcc1.setTags(Arrays.asList(new String[]{"kleindochter", "Paulientje"}));
        ccUser2Resident2Rcc1.setId(106096);

        List<CCUser> ccUserListResident2Rcc1 = new ArrayList<>();
        ccUserListResident2Rcc1.add(ccUser1Resident2Rcc1);
        ccUserListResident2Rcc1.add(ccUser2Resident2Rcc1);

        Resident resident2Rcc1 = new Resident();
        resident2Rcc1.setRoomNumber("15");
        resident2Rcc1.setName("Pascale De Backer");
        resident2Rcc1.setCcid(106086);
        resident2Rcc1.setCcusers(ccUserListResident2Rcc1);

        List<Resident> residentListrcc1 = new ArrayList<>();
        residentListrcc1.add(resident1Rcc1);
        residentListrcc1.add(resident2Rcc1);

        ResidentialCareCenter rcc1 = new ResidentialCareCenter();
        rcc1.setUsername("rcc1");
        rcc1.setPassword("PraatmaatjeRcc1");
        rcc1.setResidents(residentListrcc1);

        rccRepository.save(rcc1);
    }
}
