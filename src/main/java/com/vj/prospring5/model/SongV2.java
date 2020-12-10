package com.vj.prospring5.model;

public class SongV2 extends Song {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SongV2{" +
                "description='" + description + '\'' +
                "} + " + super.toString();
    }
}
