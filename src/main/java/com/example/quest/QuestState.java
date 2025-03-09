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
        if (gameOver) return;

        switch (currentStep) {
            case "start":
                if ("1".equals(choice)) {
                    currentStep = "forest";
                } else if ("2".equals(choice)) {
                    currentStep = "cave";
                } else if ("3".equals(choice)) {
                    currentStep = "river";
                }
                break;

            case "forest":
                if ("1".equals(choice)) {
                    currentStep = "cabin";
                } else if ("2".equals(choice)) {
                    currentStep = "pass";
                    gameOver = true;
                    result = "❌ Вовки напали на вас. Поразка!";
                    resultHistory = "Def";
                }
                break;

            case "cave":
                if ("1".equals(choice)) {
                    currentStep = "left_cave";
                    gameOver = true;
                    result = "❌ Ви впали в яму з шипами. Поразка!";
                    resultHistory = "Def";
                } else if ("2".equals(choice)) {
                    currentStep = "right_cave";
                }
                break;

            case "river":
                if ("1".equals(choice)) {
                    currentStep = "boat";
                    gameOver = true;
                    result = "❌ Водяний монстр потопив човен! Поразка!";
                    resultHistory = "Def";
                } else if ("2".equals(choice)) {
                    currentStep = "dive";
                }
                break;

            case "right_cave":
                if ("1".equals(choice)) {
                    currentStep = "big_gate";
                    gameOver = true;
                    result = "❌ Дракон охороняє ворота! Поразка!";
                    resultHistory = "Def";
                } else if ("2".equals(choice)) {
                    currentStep = "hole";
                    gameOver = true;
                    result = "🏆 Ви знайшли скарб! Перемога!";
                    resultHistory = "Win";
                }
                break;

            case "dive":
                if ("1".equals(choice)) {
                    currentStep = "temple";
                    gameOver = true;
                    result = "🏆 Ви знайшли священний артефакт! Перемога!";
                    resultHistory = "Win";
                } else if ("2".equals(choice)) {
                    currentStep = "jungle";
                    gameOver = true;
                    result = "❌ Отруйні змії напали! Поразка!";
                    resultHistory = "Def";
                }
                break;

            default:
                gameOver = true;
                result = "Гра завершена!";
                break;
        }
    }

    // Метод для отримання поточного тексту
    public String getCurrentText() {
        switch (currentStep) {
            case "start":
                return "Перед вами три дороги:<br>" +
                        "1️⃣ Увійти в темний ліс 🌲<br>" +
                        "2️⃣ Спуститися в зловісну печеру ⛰️<br>" +
                        "3️⃣ Піти до загадкової річки 🌊";
            case "forest":
                return "🌲 Ви зайшли в темний ліс. Перед вами хатинка та перевал.<br>" +
                        "1️⃣ Зайти в хатинку 🏚️<br>" +
                        "2️⃣ Йти через перевал 🏔️";
            case "cave":
                return "⛰️ Ви зайшли в печеру. Два проходи ведуть углиб.<br>" +
                        "1️⃣ Йти ліворуч 🔄<br>" +
                        "2️⃣ Йти праворуч ➡️";
            case "river":
                return "🌊 Ви підійшли до річки. Є човен та підводна печера.<br>" +
                        "1️⃣ Переплисти човном ⛵<br>" +
                        "2️⃣ Пірнути під воду 🏊‍♂️";
            case "cabin":
                return "🏚️ Ви знайшли старого мудреця, він дав вам чарівний амулет! <br>" +
                        "1️⃣ Продовжити шлях через перевал 🏔️";
            case "pass":
                return "❌ Вовки напали на вас. Гра закінчена.";
            case "left_cave":
                return "❌ Ви впали в яму з шипами. Гра закінчена.";
            case "right_cave":
                return "💎 Ви знайшли сяючий камінь, який освітлює шлях! <br>" +
                        "1️⃣ Відкрити ворота 🚪<br>" +
                        "2️⃣ Пролізти через отвір 🕳️";
            case "big_gate":
                return "❌ Дракон охороняє ворота! Гра закінчена.";
            case "hole":
                return "🏆 Ви знайшли скарб! Вітаємо!";
            case "boat":
                return "❌ Водяний монстр потопив човен! Гра закінчена.";
            case "dive":
                return "🏝️ Ви знайшли підводний хід до острова! <br>" +
                        "1️⃣ Піти до храму 🏛️<br>" +
                        "2️⃣ Вглиб джунглів 🌴";
            case "temple":
                return "🏆 Ви знайшли священний артефакт! Вітаємо!";
            case "jungle":
                return "❌ Отруйні змії напали! Гра закінчена.";
        }
        return "Гра завершена!";
    }
}
