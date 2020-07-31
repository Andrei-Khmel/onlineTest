package com.andrei.test.models;

public class PsychotypesCalqulator {

    private static String[] results;

    private static int[] extraversionYesMatrix = {0, 2, 8, 10, 13, 16, 18, 21, 24, 26, 29, 34, 37, 40, 42, 45, 48, 52, 56};
    private static int[] extraversionNoMatrix = {5, 32, 50, 54, 58};
    private static int[] neuroticismYesMatrix = {1, 4, 6, 9, 12, 14, 17, 20, 22, 25, 28, 30, 33, 36, 38, 41, 44, 46, 49, 51, 53, 55, 57, 59};
    private static int[] deceitYesMatrix = {7, 15, 23, 27, 35, 43};
    private static int[] deceitNoMatrix = {3, 11, 19, 31, 39, 47};

    public static String calqulatePsychotypes(String[] res) {
        results = res;
        int extraversion = compareReplies(extraversionYesMatrix, "Yes") + compareReplies(extraversionNoMatrix, "No");
        int neuroticism = compareReplies(neuroticismYesMatrix, "Yes");
        int deceit = compareReplies(deceitYesMatrix, "Yes") + compareReplies(deceitNoMatrix, "No");

        return "Э: " + extraversion +  "; " + "Н: " + neuroticism + "; " + "Л: " + deceit;
    }

    private static int compareReplies(int[] matrix, String reply) {
        int counter = 0;
        for(int i : matrix){
            if(results[i].equals(reply)) counter++;
        }
        return counter;
    }
}
