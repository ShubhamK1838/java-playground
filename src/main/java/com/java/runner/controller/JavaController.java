package com.java.runner.controller;

import com.java.runner.dto.ProgramDTO;
import com.java.runner.helper.JavaProgram;
import com.java.runner.helper.JavaProgramBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaController {


    @Autowired
    JavaProgramBuilder builder;

    @PostMapping("/run")
    public ResponseEntity<String> run(@RequestBody ProgramDTO dto)
    {
        JavaProgram program = builder.build(dto);

        if(program !=null)
        {
            return ResponseEntity.ok().body(program.execute());
        }else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
