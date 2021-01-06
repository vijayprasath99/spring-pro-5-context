package com.vj.prospring5.application.propertyeditor;

import java.beans.PropertyEditorSupport;

public class FullName {
    private String firstName;
    private String lastName;

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class FullNameEditor extends PropertyEditorSupport {
        // This can be its own class but somehow Spring automatically picks up this
        // editor without configuration which defeats the purpose of learning :)
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            String[] names = text.split("\\s");
            super.setValue(new FullName(names[0], names[1]));
        }
    }
}
