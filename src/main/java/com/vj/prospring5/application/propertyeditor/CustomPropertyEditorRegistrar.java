package com.vj.prospring5.application.propertyeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        registry.registerCustomEditor(FullName.class, new FullName.FullNameEditor());
    }
}
