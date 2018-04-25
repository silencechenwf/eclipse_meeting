package com.chinasofti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.bean.MeetingRoom;
import com.chinasofti.service.MeetingRoomService;
public class SearchMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchMeetingRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomIdStr = request.getParameter("roomId");
		MeetingRoomService service = new MeetingRoomService();
		HttpSession session = request.getSession();
		session.setAttribute("roomId",roomIdStr);
		MeetingRoom room = service.searchMeetingRoom(roomIdStr);
		request.setAttribute("room", room);
		request.getRequestDispatcher("updateMeetingRoom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
