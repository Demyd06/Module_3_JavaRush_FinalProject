package com.example.quest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/quest")
public class QuestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        QuestState state = (QuestState) session.getAttribute("questState");

        if (state == null) {
            state = new QuestState();
        }

        String choice = request.getParameter("choice");
        if (choice != null) {
            String nextStep = QuestLogic.getNextStep(state.getCurrentStep(), choice);
            state.setCurrentStep(nextStep);

            if (nextStep.equals("escape")) {
                state.setGameOver(true);
                state.setResult("Ти втік!");
            } else if (nextStep.equals("lost") || nextStep.equals("caught")) {
                state.setGameOver(true);
                state.setResult("Ти програв...");
            }
        }

        session.setAttribute("questState", state);
        request.getRequestDispatcher(state.isGameOver() ? "result.jsp" : "game.jsp").forward(request, response);
    }
}
