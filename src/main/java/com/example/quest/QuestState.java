package com.example.quest;

import java.io.Serializable;

public class QuestState implements Serializable {
    private String currentStep;
    private boolean gameOver;
    private String result;

    public QuestState() {
        this.currentStep = "start";
        this.gameOver = false;
        this.result = "";
    }

    public String getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
