package edu.icet.malaka96.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class GameQuestion {
    private String id;
    private String title;
    private String question;
    private String[] answers;
    private String type;
}
