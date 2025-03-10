package com.example.quest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestStateTest {

    @Test
    void testInitialState() {
        QuestState state = new QuestState();

        assertEquals("start", state.getCurrentStep());
        assertFalse(state.isGameOver());
    }

    @Test
    void testChoiceToForest() {
        QuestState state = new QuestState();

        state.processChoice("1");

        assertEquals("forest", state.getCurrentStep());
        assertFalse(state.isGameOver());
    }

    @Test
    void testChoiceToCave() {
        QuestState state = new QuestState();

        state.processChoice("2");

        assertEquals("cave", state.getCurrentStep());
        assertFalse(state.isGameOver());
    }

    @Test
    void testWinningPath() {
        QuestState state = new QuestState();
        state.setCurrentStep("right_cave");

        state.processChoice("2"); //Win

        assertTrue(state.isGameOver());
        assertEquals("\uD83C\uDFC6 Ви знайшли скарб! Перемога!", state.getResult());
    }

    @Test
    void testLosingPath() {
        QuestState state = new QuestState();
        state.setCurrentStep("right_cave");

        state.processChoice("1"); // Losses

        assertTrue(state.isGameOver());
        assertEquals("❌ Дракон охороняє ворота! Поразка!", state.getResult());
    }
}