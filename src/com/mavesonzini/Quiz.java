package com.mavesonzini;

/**
 * Created by mave on 31/05/2017.
 */
public class Quiz {

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    public Quiz(String Question, String answer1, String answer2, String answer3, String answer4){
        question = Question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    String getQuestion(){
        return question;
    }

    String getAnswer1(){
        return answer1;
    }

    String getAnswer2(){
        return answer2;
    }

    String getAnswer3(){
        return answer3;
    }

    String getAnswer4(){
        return answer4;
    }

}
