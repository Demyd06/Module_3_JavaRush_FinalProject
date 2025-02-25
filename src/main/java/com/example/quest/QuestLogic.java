package com.example.quest;

import java.util.HashMap;
import java.util.Map;

public class QuestLogic {
    private static final Map<String, String[]> paths = new HashMap<>();

    static {
        paths.put("start", new String[]{"shop", "alley"});
        paths.put("shop", new String[]{"subway", "police"});
        paths.put("alley", new String[]{"run", "hide"});
        paths.put("subway", new String[]{"escape", "lost"});
        paths.put("police", new String[]{"documents", "fight"});
        paths.put("run", new String[]{"caught", "safe"});
    }

    public static String getNextStep(String currentStep, String choice) {
        if (!paths.containsKey(currentStep)) return "unknown";

        String[] options = paths.get(currentStep);
        return choice.equals("A") ? options[0] : options[1];
    }
}
