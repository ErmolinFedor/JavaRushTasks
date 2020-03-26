package com.javarush.task.task27.task2712.ad;

public class Advertisement {

    //видео
    private Object content;
    //имя/название
    private String name;
    //начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private long initialAmount;
    //количество оплаченных показов
    private int hits;
    //продолжительность в секундах
    private int duration;
    //стоимость просмотренного ролика
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = (hits > 0) ? initialAmount / hits : 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getHits() {
        return hits;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate(){
        if (hits <= 0 ){
            throw new UnsupportedOperationException();
        }else {
            hits--;
        }
    }

    @Override
    public String toString() {
        return name + " is displaying... " + getAmountPerOneDisplaying() + ", " + getAmountPerOneDisplaying()/duration*1000;
    }
}
