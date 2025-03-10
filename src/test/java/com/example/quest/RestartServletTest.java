package com.example.quest;

import static org.mockito.Mockito.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class RestartServletTest {

    @Test
    void testDoPost_ResetsGameAndRedirects() throws IOException, ServletException {
        // Mock Http
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class); // Замокали сесію

        // Imitation GetSession
        when(request.getSession()).thenReturn(session);

        // Use method servlets
        new RestartServlet().doPost(request, response);

        // Check clears stats
        verify(session).removeAttribute("questState");
        // Check redirect
        verify(response).sendRedirect("index.jsp");
    }

}
