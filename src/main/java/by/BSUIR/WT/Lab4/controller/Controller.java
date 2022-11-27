package by.BSUIR.WT.Lab4.controller;

import java.io.*;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class Controller extends HttpServlet {
	
	private static final String command = "command";
	private static final String path = "/hotel?";
	private static final String mainCommand = "command=main";
	
	@Override
	public void init() throws ServletException{
		super.init();
		try {
			ConnectionProtocol.getInstance().initialize();
		}catch(ConnectionException e) {
			throw new RuntimeErrorException(e);
		}
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponce responce) throws ServletException, IOException{
		process(request, responce);
	}
	
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponce responce) throws ServletException, IOException){
		process(request, responce);
	}
	
	@Override
	public void destroy() {}
	
	public void process(HttpServletRequest request, HttpServletResponce responce) throws ServletException, IOException{
		String commandName = request.getParameter(command);
		
		if (commandName == null || "".equals(commandName)) {
			responce.sendRedirect(path+mainCommand);
		}else {
			Command command = CommandFactory.getInstace().getCommand(commandName);
		}
	}
}