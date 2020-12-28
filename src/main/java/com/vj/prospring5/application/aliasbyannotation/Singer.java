package com.vj.prospring5.application.aliasbyconfiguration;

import org.springframework.stereotype.Component;

@Component("johnSnow")
@Award(prize={"grammy", "oscar"})
public class Singer {
    private String lyrics = "We found the boot leg pirate!";

    public void sing() {
        System.out.println(lyrics);
    }
}
