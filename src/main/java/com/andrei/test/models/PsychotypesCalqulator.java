package com.andrei.test.models;

import com.andrei.test.repo.OutputTableCreatorRepository;

import java.util.Optional;

public class PsychotypesCalqulator {

    private static String[] results;

    private static final int[] EXTRAVERSION_YES_MATRIX = {0, 2, 8, 10, 13, 16, 18, 21, 24, 26, 29, 34, 37, 40, 42, 45, 48, 52, 56};
    private static final int[] EXTRAVERSION_NO_MATRIX = {5, 32, 50, 54, 58};
    private static final int[] NEUROTICISM_YES_MATRIX = {1, 4, 6, 9, 12, 14, 17, 20, 22, 25, 28, 30, 33, 36, 38, 41, 44, 46, 49, 51, 53, 55, 57, 59};
    private static final int[] DECEIT_YES_MATRIX = {7, 15, 23, 27, 35, 43};
    private static final int[] DECEIT_NO_MATRIX = {3, 11, 19, 31, 39, 47};
    public static String calqulatePsychotypes(String[] res, String idCode) {
        results = res;

        int extraversion = compareReplies(EXTRAVERSION_YES_MATRIX, "Yes") + compareReplies(EXTRAVERSION_NO_MATRIX, "No");
        int neuroticism = compareReplies(NEUROTICISM_YES_MATRIX, "Yes");
        int deceit = compareReplies(DECEIT_YES_MATRIX, "Yes") + compareReplies(DECEIT_NO_MATRIX, "No");


        OutputTableCreator record = new OutputTableCreator(idCode, extraversion, neuroticism, deceit);
        OutputTableCreatorRepository outputTableCreatorRepository = new OutputTableCreatorRepository() {
            @Override
            public <S extends OutputTableCreator> S save(S s) {
                return null;
            }

            @Override
            public <S extends OutputTableCreator> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<OutputTableCreator> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<OutputTableCreator> findAll() {
                return null;
            }

            @Override
            public Iterable<OutputTableCreator> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(OutputTableCreator outputTableCreator) {

            }

            @Override
            public void deleteAll(Iterable<? extends OutputTableCreator> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };
        outputTableCreatorRepository.save(record);

        return "idCode: " + idCode + "; " + "Э: " + extraversion +  "; " + "Н: " + neuroticism + "; " + "Л: " + deceit;
    }

    private static int compareReplies(int[] matrix, String reply) {
        int counter = 0;
        for(int i : matrix){
            if(results[i].equals(reply)) counter++;
        }
        return counter;
    }
}
