package com.java.runner.helper;


import com.java.runner.dto.ProgramDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;

@Component
@Scope(scopeName = "prototype")
public class JavaProgramBuilder {

    private String DIR;
    @Autowired
    private JavaProgram javaProgram;

    public JavaProgramBuilder() {
        DIR = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "tmps";

    }

    public JavaProgram build(ProgramDTO dto) {
        try {
            File file = new File(DIR + File.separator + dto.getProgramName());
            javaProgram.setProgramName(file.getName());
            javaProgram.setProgramInput(dto.getProgramInput());
            javaProgram.setDIR(DIR);
            javaProgram.setClassName(file.getName().substring(0, file.getName().indexOf(".")));
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(dto.getProgramData().getBytes());
            }

        } catch (Exception er) {
            er.printStackTrace();
        }
        return javaProgram;
    }


}
