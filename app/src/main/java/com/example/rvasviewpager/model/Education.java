package com.example.rvasviewpager.model;

public class Education {
    public String name;
    public String projectName;

    public Education(String name, String projectName) {
        this.name = name;
        this.projectName = projectName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}
