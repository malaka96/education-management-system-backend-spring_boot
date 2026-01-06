package edu.icet.malaka96.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameQuestionController {

    @GetMapping("/questions")
    public List<String> getQuestions(){
        return null;
    }

    @PostMapping("/add-question")
    public void addQuestion(@RequestBody String string){
        //
    }

    @PutMapping("/update-question/{id}")
    public void updateQuestion(@PathVariable String id, @RequestBody String string){
        //
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable String id){
        //
    }

}
