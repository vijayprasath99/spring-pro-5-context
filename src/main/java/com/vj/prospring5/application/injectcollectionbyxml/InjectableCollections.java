package com.vj.prospring5.application.injectcollectionbyxml;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class InjectableCollections {
    Set<String> aSet;
    Map<String, String> aMap;
    List<String> aList;
    Properties props;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:application-context-injectable-collections.xml");
        ctx.refresh();
        
        InjectableCollections collection = ctx.getBean("injectableCollection", InjectableCollections.class);
        String output = collection.toString();
        System.out.println(output);
    }

    public void setaSet(Set<String> aSet) {
        this.aSet = aSet;
    }

    public void setaMap(Map<String, String> aMap) {
        this.aMap = aMap;
    }

    public void setaList(List<String> aList) {
        this.aList = aList;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "InjectableCollections{" +
                "aSet=" + aSet +
                ", aMap=" + aMap +
                ", list=" + aList +
                ", props=" + props +
                '}';
    }
}
