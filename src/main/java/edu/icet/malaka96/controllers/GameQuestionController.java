package edu.icet.malaka96.controllers;

import edu.icet.malaka96.models.GameQuestion;
import edu.icet.malaka96.services.GameQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameQuestionController {

//    public GameQuestionController(GameQuestionService gameQuestionService) {
//        this.gameQuestionService = gameQuestionService;
//    }

    final GameQuestionService gameQuestionService;


    @GetMapping("/questions")
    public ResponseEntity<?> getQuestions() {
        List<GameQuestion> gameQuestions = gameQuestionService.getQuestions();

        if (gameQuestions == null || gameQuestions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(gameQuestions);
    }


    @PostMapping("/add-question")
    public ResponseEntity<?> addQuestion(@RequestBody GameQuestion gameQuestion) {
        try {
            gameQuestionService.addQuestion(gameQuestion);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Question added successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add question");
        }
    }


    @PutMapping("/update-question/{id}")
    public ResponseEntity<?> updateQuestion(
            @PathVariable String id,
            @RequestBody GameQuestion gameQuestion) {

        boolean updated = gameQuestionService.updateQuestion(id, gameQuestion);

        if (!updated) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Question not found");
        }

        return ResponseEntity.ok("Question updated successfully");
    }


    @DeleteMapping("/delete-question/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable String id) {

        boolean deleted = gameQuestionService.deleteQuestion(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }


}
