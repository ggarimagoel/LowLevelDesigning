package ParkingLot.Controller;

import ParkingLot.DTO.ResponseStatus;
import ParkingLot.DTO.generateTicketRequestDTO;
import ParkingLot.DTO.generateTicketResponseDTO;
import ParkingLot.Exception.NoParkingSlotAvailableException;
import ParkingLot.Services.TicketService;
import ParkingLot.models.Ticket;

public class TicketController {
    private TicketService ticketService;
    //DTO - Data Transfer Object
    //problems with directly involving Models in the Controller API's :-
    //1. If we add/remove models from the input, current clients will start failing.
    //2. We should not expose the Model details to client because of privacy.
    //The solution to this : Data Transfer Objects (DTO).

    public  TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public generateTicketResponseDTO generateTicket(generateTicketRequestDTO GenerateTicketRequestDTO){

//        task to be performed by Ticket Controller(only task of TC is to route the info from client to services and vice versa)
//        get gate, either get vehicle or register new vehicle if its coming for the first time,assigning parking slot
//
//        there are 2 ways of doing this,
//        1)ticket service, vehicle service , gate service called by ticket controller
//        2)ticket controller calls ticket service which in turns calls vehicle service , gate service.
//         second option is better bec function of controller is to take info from client and hand it over to service.
//         Between client ang controllers we interact via DTO's


        try {
            // validation for criminal lisc No.
            Ticket ticket = ticketService.generateTicket(GenerateTicketRequestDTO.getVehicleNumber(),
                    GenerateTicketRequestDTO.getVehicleType(),
                    GenerateTicketRequestDTO.getGateID());

            generateTicketResponseDTO generateTicketResponseDto = new generateTicketResponseDTO();
            generateTicketResponseDto.setTicket(ticket);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

            return generateTicketResponseDto;



        }
//
        catch(NoParkingSlotAvailableException e){
            generateTicketResponseDTO generateTicketResponseDto = new generateTicketResponseDTO();
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setFailureMessage(e.getMessage());
            return  generateTicketResponseDto;

        }
    }
      /* - CompleteProject
    4 service -
     */
}
