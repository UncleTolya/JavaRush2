package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    String country = Country.UKRAINE;

    @Override
    int getCountOfEggsPerMonth() {
        return 3;
    }

    @Override
    String getDescription() {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %d яиц в месяц.", country, getCountOfEggsPerMonth());
    }
}