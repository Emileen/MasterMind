package com.theironyard.controllers;

import com.theironyard.entities.MasterMind;
import com.theironyard.services.MasterMindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created by emileenmarianayagam on 1/20/17.
 */
@RestController
public class MasterMindController {
    @Autowired
    MasterMindRepository games;


    // sending data back
    @RequestMapping(path ="/", method = RequestMethod.GET)
    public String homePage(){
        return "home";
    }

    //pulling data back
  /*  @RequestMapping(path = "/", method = RequestMethod.POST)
    public String game(){
        return "home";
    }*/



    @PostConstruct
    public void init() {
        if (games.count() == 0) {
            MasterMind masterMind = new MasterMind();
            int a = randomNum();
            masterMind.guesses = new int [4];
            masterMind.guesses[0] = a;
            masterMind.guesses[1] = a;
            masterMind.guesses[2] = a;
            masterMind.guesses[3] = a;
            masterMind.checks = new int [4];
            masterMind.checks[0] =0;
            masterMind.checks[1] =0;
            masterMind.checks[2] =0;
            masterMind.checks[3] =0;
            games.save(masterMind);

        }
    }


    public static int randomNum (){
        return (int )(Math.random() * 8 + 1);
    }

}
