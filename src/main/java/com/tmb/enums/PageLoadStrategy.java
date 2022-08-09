package com.tmb.enums;

public enum PageLoadStrategy {

    NORMAL("normal"),
    NONE("none"),
    EAGER("eager");

    private final String loadStrategy;

    PageLoadStrategy(String loadStrategy) {
        this.loadStrategy = loadStrategy;
    }

    public String getLoadStrategy(){
        return loadStrategy;
    }
}
