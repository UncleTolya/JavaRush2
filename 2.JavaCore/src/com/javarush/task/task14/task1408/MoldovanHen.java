package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    String country = Country.MOLDOVA;

    @Override
    int getCountOfEggsPerMonth() {
        return 2;
    }

    @Override
    String getDescription() {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %d яиц в месяц.", country, getCountOfEggsPerMonth());
    }
}