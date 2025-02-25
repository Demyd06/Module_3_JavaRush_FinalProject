package com.example.quest;

import java.io.Serializable;

public class QuestState implements Serializable {
    private String currentStep;
    private boolean gameOver;
    private String result;
    private String resultHistory;

    public QuestState() {
        this.currentStep = "start"; // STARTER //
        this.gameOver = false;
        this.result = "";
        this.resultHistory = "";
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

    public boolean isWin() {
        return "Win".equalsIgnoreCase(resultHistory);
    }

    // Метод для обробки вибору гравця
    public void processChoice(String choice) {
        if (gameOver) return; // IF GAME OVER, DON'T UP

        switch (currentStep) {
            case "start":
                if ("1".equals(choice)) {
                    currentStep = "forest";
                } else if ("2".equals(choice)) {
                    currentStep = "cave";
                }
                break;

            case "forest":
                if ("1".equals(choice)) {
                    currentStep = "river";
                } else if ("2".equals(choice)) {
                    currentStep = "trap";
                    gameOver = true;
                    result = "Поразка: Ви потрапили в пастку!";
                    resultHistory = "Def";
                }
                break;

            case "cave":
                if ("1".equals(choice)) {
                    currentStep = "treasure";
                    gameOver = true;
                    result = "Перемога! Ви знайшли скарб!";
                    resultHistory = "Win";
                } else if ("2".equals(choice)) {
                    currentStep = "monster";
                    gameOver = true;
                    result = "Поразка: Вас з'їв монстр!";
                    resultHistory = "Def";
                }
                break;

            case "river":
                gameOver = true;
                result = "Перемога! Ви перетнули річку і знайшли вихід!";
                resultHistory = "Win";
                break;

            default:
                gameOver = true;
                result = "Гра завершена!";
                break;
        }
    }

    // METHOD FOR TEXT //
    public String getCurrentText() {
        switch (currentStep) {
            case "start":
                return "Ви стоїте на роздоріжжі. Куди йдете?\n1. У ліс\n2. У печеру";
            case "forest":
                return "Ви зайшли в ліс. Перед вами річка і підозріла стежка.\n1. Перейти річку\n2. Йти по стежці";
            case "cave":
                return "Ви зайшли в печеру. Бачите два проходи.\n1. Йти ліворуч\n2. Йти праворуч";
            case "river":
                return "Ви успішно перетнули річку! Вітаємо!";
            case "trap":
                return "Ви потрапили в пастку. Гра закінчена.";
            case "treasure":
                return "Ви знайшли скарб! Вітаємо!";
            case "monster":
                return "Монстр з'їв вас! Гра закінчена.";
            default:
                return "Гра завершена!";
        }
    }
}
