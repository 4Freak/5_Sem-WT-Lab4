package by.BSUIR.WT.Lab4.controller.command.impl;

import javax.servlet.http.HttpServletResponse;

import by.BSUIR.WT.Lab4.controller.command.Command;
import by.BSUIR.WT.Lab4.controller.command.CommandResult;
import by.BSUIR.WT.Lab4.controller.command.CommandResultType;
import by.BSUIR.WT.Lab4.controller.context.RequestContext;
import by.BSUIR.WT.Lab4.controller.context.RequestContextHelper;
import by.BSUIR.WT.Lab4.service.ServiceFactory;
import by.BSUIR.WT.Lab4.service.exception.ServiceException;
import by.BSUIR.WT.Lab4.service.intrfc.UserOrderService;

public class CompleteOrder implements Command{

	private static final String page = "command=viewOrders";
	private static final String userOdrerId = "userOrderId";
	private static final String errorPage = "WEB-INF/view/error.jsp";
	private static final String confirmed = "confirmed";
	
	@Override
	public CommandResult execute(RequestContextHelper helper, HttpServerResponse response) {
		RequestContext requestContext = helper.createContext();
		try {
			int userOrderId = Integer.parseInt(requestContext.getRequestParameter(userOrderId));
			UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
			userOrderService.updateStatusAtUserOrderById(userOrderId, confirmed);
		}catch (ServiceException e) {
			return new CommandResult(errorPage, CommandResultType.FORWARD);
		}
		helper.updateRequest(requestContext);
		return new CommandResult(page, CommandResultType.REDIRECT);
	}
	
}
