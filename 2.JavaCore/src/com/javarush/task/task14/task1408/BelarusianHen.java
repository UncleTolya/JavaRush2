package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    String country = Country.BELARUS;

    @Override
    int getCountOfEggsPerMonth() {
        return 1;
    }

    @Override
    String getDescription() {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %d яиц в месяц.", country, getCountOfEggsPerMonth());
    }
}