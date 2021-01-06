package com.vj.prospring5.application.propertyeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

import static com.vj.prospring5.util.PrintHelper.delimitLine;

public class Application {
    private Character character;         //CharacterEditor
    private Class cls;                   // ClassEditor
    private Boolean trueOrFalse;         // CustomBooleanEditor
    private List<String> stringList;     // CustomCollectionEditor
    private Float floatValue;            // CustomNumberEditor
    private Date date;                   // CustomDateEditor
    private File file;                   // FileEditor
    private Locale locale;               // LocaleEditor
    private Pattern pattern;             // PatternEditor
    private Properties properties;       // PropertiesEditor
    private URL url;                     // URLEditor
    private InputStream stream;          // InputStreamEditor
    private byte[] bytes;
    private String trimString;           // StringTrimmerEditor
    private String normalString;
    private FullName fullName;          // Custom Editor


    public void setFullName(FullName fullName) {
        System.out.println("Setting setFullName " + fullName.toString());
        this.fullName = fullName;
    }

    public void setNormalString(String normalString) {
        System.out.printf("Setting normalString: '%s'%n",normalString);
        this.normalString = normalString;
    }

    public void setBytes(byte[] bytes) {
        System.out.println("Setting bytes " + Arrays.toString(bytes));
        this.bytes = bytes;
    }

    public void setCharacter(Character character) {
        System.out.println("Setting Character " + character);
        this.character = character;
    }

    public void setCls(Class cls) {
        System.out.println("Setting Class " + cls);
        this.cls = cls;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        System.out.println("Setting trueOrFalse " + trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList) {
        System.out.println("Setting stringList " + stringList);
        this.stringList = stringList;
    }

    public void setDate(Date date) {
        System.out.println("Setting date " + date);
        this.date = date;
    }

    public void setFloatValue(Float floatValue) {
        System.out.println("Setting floatValue " + floatValue);
        this.floatValue = floatValue;
    }

    public void setFile(File file) {
        System.out.println("Setting file " + file);
        this.file = file;
    }

    public void setStream(InputStream stream) {
        System.out.println("Setting stream " + stream);
        this.stream = stream;
    }

    public void setLocale(Locale locale) {
        System.out.println("Setting locale: " + locale.getDisplayName());
        this.locale = locale;
    }

    public void setPattern(Pattern pattern) {
        System.out.println("Setting pattern: " + pattern);
        this.pattern = pattern;
    }

    public void setProperties(Properties properties) {
        System.out.printf("Setting properties(%d): %s %n", properties.size(), properties);
        this.properties = properties;
    }

    public void setTrimString(String trimString) {
        System.out.printf("Setting trimString: '%s'%n",trimString);
        this.trimString = trimString;
    }

    public void setUrl(URL url) {
        System.out.println("Setting url: " + url.toExternalForm());
        this.url = url;
    }

    public static void main(String[] args) throws IOException {
        File tempFile = File.createTempFile("test", "txt");
        tempFile.deleteOnExit();

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:application-context/propertyeditor.xml");
        ctx.refresh();

        delimitLine();

        ctx.getBean(Application.class);

        delimitLine();

        ctx.close();
    }
}
