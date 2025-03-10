package com.example.quest;

import static org.mockito.Mockito.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class QuestServletTest {

    @Test
    void testDoPost_ProcessesChoiceAndUpdatesSession() throws IOException, ServletException {
        // Http
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        QuestState state = mock(QuestState.class);

        // Imitation choice
        when(request.getParameter("choice")).thenReturn("attack");
        // Imitation getSession
        when(request.getSession()).thenReturn(session);
        // Imitation save game stats
        when(session.getAttribute("questState")).thenReturn(state);
        // Imitation gameOver
        when(state.isGameOver()).thenReturn(true);
        when(state.getResult()).thenReturn("You won!");
        when(state.isWin()).thenReturn(true);
        // Imitation stats
        when(session.getAttribute("wins")).thenReturn(2);
        when(session.getAttribute("losses")).thenReturn(1);
        // Imitation history
        List<String> history = new ArrayList<>();
        when(session.getAttribute("gameHistory")).thenReturn(history);

        //  doPost()
        new QuestServlet().doPost(request, response);

        // Check processChoice() be use
        verify(state).processChoice("attack");
        // Check update stats game
        verify(session).setAttribute("questState", state);
        // Check update history
        verify(session).setAttribute("gameHistory", history);
        // Check update wins++
        verify(session).setAttribute("wins", 3);
        // Check redirect "game.jsp" be
        verify(response).sendRedirect("game.jsp");
    }
}
