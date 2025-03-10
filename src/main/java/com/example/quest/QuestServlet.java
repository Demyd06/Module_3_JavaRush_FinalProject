package com.example.quest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/QuestServlet")
public class QuestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String choice = request.getParameter("choice");

        QuestState state = (QuestState) session.getAttribute("questState");
        if (state == null) {
            state = new QuestState();
        }

        state.processChoice(choice);
        session.setAttribute("questState", state);

        if (state.isGameOver()) {
            List<String> history = (List<String>) session.getAttribute("gameHistory");
            if (history == null) {
                history = new ArrayList<>();
            }

            // Додаємо результат у список історії
            history.add(state.getResult());
            session.setAttribute("gameHistory", history);

            // Оновлюємо статистику
            Integer wins = (Integer) session.getAttribute("wins");
            Integer losses = (Integer) session.getAttribute("losses");

            if (wins == null) wins = 0;
            if (losses == null) losses = 0;

            if (state.isWin()) {
                session.setAttribute("wins", wins + 1);
            } else {
                session.setAttribute("losses", losses + 1);
            }
        }

        response.sendRedirect("game.jsp");
    }




}
