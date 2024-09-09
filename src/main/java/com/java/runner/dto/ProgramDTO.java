package com.java.runner.dto;

public class ProgramDTO {

    private String programName;
    private String programData;
    private String programInput;

    public ProgramDTO(){}

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramData() {
        return programData;
    }

    public void setProgramData(String programData) {
        this.programData = programData;
    }

    public String getProgramInput() {
        return programInput;
    }

    public void setProgramInput(String programInput) {
        this.programInput = programInput+"\n";
    }

    @Override
    public String toString() {
        return "ProgramDTO{" +
                "programName='" + programName + '\'' +
                ", programData='" + programData + '\'' +
                ", programInput='" + programInput + '\'' +
                '}';
    }
}
