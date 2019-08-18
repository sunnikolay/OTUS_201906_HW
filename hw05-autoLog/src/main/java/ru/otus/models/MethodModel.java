package ru.otus.models;

import java.lang.reflect.Parameter;
import java.util.Arrays;

public class MethodModel {

    private String name;

    private Parameter[] parameters;

    public MethodModel( String name, Parameter[] parameters ) {
        this.name       = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public Parameter[] getParameters() {
        return parameters;
    }

}
