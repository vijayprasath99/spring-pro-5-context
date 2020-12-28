package com.vj.prospring5.application.parentchild;

import com.vj.prospring5.model.Song;
import com.vj.prospring5.model.SongV2;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class ParentChildContext {
    public static void main(String[] args) {
        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("classpath:application-context-parent.xml");
        parent.refresh();
        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
        child.load("classpath:application-context-child.xml");
        child.setParent(parent);
        child.refresh();
        
        List<Song> songs = Arrays.asList(
            child.getBean("song1", Song.class),
            child.getBean("song2", Song.class),
            child.getBean("song3", Song.class),
            child.getBean("song4", SongV2.class)
        );

        songs.stream().forEach(System.out::println);
        
    }
}
