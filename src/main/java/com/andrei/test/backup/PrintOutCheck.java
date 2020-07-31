package com.andrei.test.backup;

import com.andrei.test.models.Questions;

import java.util.Arrays;

public class PrintOutCheck {

    public static void printInfoToConsole(Questions questionsObjectToCheck, String refName){

        System.out.println(refName);
        System.out.println("idCode: " + questionsObjectToCheck.getIdCode());
        System.out.println("results: " + Arrays.toString(questionsObjectToCheck.results));
        System.out.println("questions [] length: " + questionsObjectToCheck.getQuestions().length);

    }
}
