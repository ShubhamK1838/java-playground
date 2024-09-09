package com.java.runner.helper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

@Component
@Scope(scopeName = "prototype")
public class JavaProgram {

    private String DIR;
    private String programName;
    private String className;
    private String programInput;



    public JavaProgram() {
        DIR = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "tmps";
    }

    public String  execute() {
        String  out="";
        try {

            ProcessBuilder processBuilder = new ProcessBuilder("java", programName);
            processBuilder.directory(new File(DIR));
            Process process = processBuilder.start();
            try (OutputStream processInput = process.getOutputStream();
                 InputStream processOutput = process.getInputStream();
                 InputStream processOutputError = process.getErrorStream();
            ) {
                if(programInput!=null || programInput.length()>0)
                {
                    processInput.write(programInput.getBytes());
                    processInput.flush();
                }
                out+=new String(processOutput.readAllBytes());
                out+=new String(processOutputError.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    // NONONONONONONONONONONON
    public boolean execute1(String input, OutputStream out) {

        try {

            ProcessBuilder processBuilder = new ProcessBuilder("java", className);
            processBuilder.directory(new File(DIR));
            Process process = processBuilder.start();
            try (OutputStream processInput = process.getOutputStream();
                 InputStream processOutput = process.getInputStream();
                 InputStream processOutputError = process.getErrorStream();
            ) {
                if(input!=null)
                {
                    processInput.write(input.getBytes());
                    processInput.flush();
                }
                out.write(processOutput.readAllBytes());
                out.write(processOutputError.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return true;
    }

    public boolean compile(OutputStream out) {
        try {

            ProcessBuilder processBuilder = new ProcessBuilder("javac", programName);
            processBuilder.directory(new File(DIR));
            Process process = processBuilder.start();

            try (InputStream in = process.getInputStream()) {
                out.write(in.readAllBytes());
                out.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getDIR() {
        return DIR;
    }

    public void setDIR(String DIR) {
        this.DIR = DIR;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className+"\n";
    }

    public String getProgramInput() {
        return programInput;
    }

    public void setProgramInput(String programInput) {
        this.programInput = programInput;
    }

    @Override
    public String toString() {
        return "JavaProgram{" +
                "DIR='" + DIR + '\'' +
                ", programName='" + programName + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
