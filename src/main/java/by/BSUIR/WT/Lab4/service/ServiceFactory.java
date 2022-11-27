package by.BSUIR.WT.Lab4.service;

public class ServiceFactory {
	
	private static final ServiceFacotory instance = new ServiceFactory();
	
	private final UserOrderService userOrderService = new UserOderServiceImpl();
	private final UserInformationService userInformationService = new UserInformationServiceImpl();
	private final ApartmentService apartmentService = new ApartmentServiceImpl();
	private final UserService userService = new UserServiceImpl();
 	private final RoleService roleService = new RoleServiceImpl();
	private final 
	
	private ServiceFactory() {}

}
