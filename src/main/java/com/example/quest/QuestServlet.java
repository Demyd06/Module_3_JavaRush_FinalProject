package com.example.quest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/QuestServlet")
public class QuestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String choice = request.getParameter("choice");

        QuestState state = (QuestState) session.getAttribute("questState");
        if (state == null) {
            state = new QuestState();
        }

        // UPDATE GAME STATUS //
        state.processChoice(choice);
        session.setAttribute("questState", state);

        // ADD IN doPost()
        if (state.isGameOver()) {
            String result;
            if (state.isWin()) result = "Win";
            else result = "Def";

            // Зберігаємо результат у cookies
            Cookie historyCookie = new Cookie("gameHistory", result);
            historyCookie.setMaxAge(60 * 60 * 24 * 7); // 7 днів
            response.addCookie(historyCookie);
        }


        // SAVE PROGRESS //
        Cookie progressCookie = new Cookie("questProgress", state.getCurrentStep());
        progressCookie.setMaxAge(60 * 60 * 24); // 1 день
        response.addCookie(progressCookie);

        response.sendRedirect("game.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // READ PROGRESS //
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("questProgress")) {
                    QuestState state = new QuestState();
                    state.setCurrentStep(cookie.getValue());
                    session.setAttribute("questState", state);
                    break;
                }
            }
        }

        response.sendRedirect("game.jsp");
    }

}
