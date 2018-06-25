package com.swedBank.controller;

import com.swedBank.business.ConsumptionBusiness;
import com.swedBank.exception.ApplicationBusinessException;
import com.swedBank.exception.BadRequestException;
import com.swedBank.exception.NotFoundException;
import com.swedBank.model.RegistrationRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
@RestController
@Api(value="FuelConsumption Controller", description="Fuel Consumpation registration and report generation")
public class FuelConsumptionController {

    @Autowired
    ConsumptionBusiness consumptionBusinessImpl;

    private static final Logger logger = LogManager.getLogger(FuelConsumptionController.class);


    /**
     *
     * @param registration
     * @return
     */
    @ApiOperation(value="Registration", response=String.class )
    @ApiResponses(value={@ApiResponse(code =201, message="Created Successfully"),
                        @ApiResponse(code =500, message="Internal server Error")
    })
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<String> registration(@RequestBody RegistrationRequest registrationRequest ) {
       logger.info("registration"+ registrationRequest.toString());
       consumptionBusinessImpl.registration(registrationRequest);
       return new ResponseEntity<>("Succesfully Added", HttpStatus.CREATED);
    }
    
    /**
    *
    * @param driverId
    * @return
    */
   @ApiOperation(value="Total spent amount of money grouped by month", response=String.class )
   @ApiResponses(value={@ApiResponse(code =201, message="Created Successfully"),
                       @ApiResponse(code =500, message="Internal server Error")
   })
   @RequestMapping(value = "/getAmountByMonth", method = RequestMethod.POST)
   public ResponseEntity<String> getAmountByMonth(@RequestBody String driverId ) {
      logger.info("driverId"+ driverId);
      consumptionBusinessImpl.getAmountByMonth(driverId);
      return new ResponseEntity<>("Succesfully Added", HttpStatus.CREATED);
   }
   
   /**
   *
   * @param driverId, month
   * @return
   */
  @ApiOperation(value="List fuel consumption records for specified month "
  		+ "(each row should contain: fuel type, volume, date, price, total price, driver ID)", response=String.class )
  @ApiResponses(value={@ApiResponse(code =201, message="Created Successfully"),
                      @ApiResponse(code =500, message="Internal server Error")
  })
  @RequestMapping(value = "/getConsumptionByMonth", method = RequestMethod.POST)
  public ResponseEntity<String> getConsumptionByMonth(@RequestBody String month ) {
     logger.info("driverId"+ month);
     consumptionBusinessImpl.findConsumpationByMonth(month);
     return new ResponseEntity<>("Succesfully Added", HttpStatus.CREATED);
  }

   /* *//**
     *
     * @param origin
     * @param destination
     * @return
     * @throws NotFoundException, BadRequestException
     *//*
    @ApiOperation(value="To get flight results", response=SearchResultsResponse.class )
    @ApiResponses(value={@ApiResponse(code =200, message="List retrived successfully"),
            @ApiResponse(code =500, message="Internal Server Error"),
            @ApiResponse(code =400, message="Input validations failed"),
            @ApiResponse(code =404, message="No Data Found")
    })
    @RequestMapping(value ="/getResults" , method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<SearchResultsResponse> getResults(@RequestParam("origin")
                                                 String origin, @RequestParam("destination")
            String destination) throws NotFoundException, BadRequestException {
        logger.info("info flight search executed" + origin +" " +destination);
        List<SearchResult>  searchResults= flightBusinessImpl.findFlights(origin, destination);
        if (searchResults != null && searchResults.size() >0 ){
            logger.info("flight results size : flightsResults.size()" );
            SearchResultsResponse searchResultsResponse = new SearchResultsResponse
                    (new Date(), "","", searchResults);
            return new ResponseEntity<>(searchResultsResponse, HttpStatus.OK);
        } else {
            throw new NotFoundException("No Data");
        }

    }

    *//**
     *
     * @param queryString
     * @return
     * @throws NotFoundException
     *//*
    @ApiOperation(value="To get airport & city list", response=SearchResultsResponse.class )
    @ApiResponses(value={@ApiResponse(code =200, message="List retrived successfully"),
            @ApiResponse(code =500, message="Internal Server Error"),
            @ApiResponse(code =404, message="No Data Found")
    })
    @RequestMapping(value ="/getAirportLists" , method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<AiportsResponse> getAirportLists(@RequestParam(name="query", required=true) String queryString) throws NotFoundException,
            ApplicationBusinessException {
        logger.info("info getAirportNames executed" +queryString);
        List<Airport> airportList= null;
            airportList = flightBusinessImpl.findAirports(queryString);
        AiportsResponse jsonResponse = new AiportsResponse(new Date (), "","", airportList);
        if (airportList!=null && airportList.size() >0 ){
            logger.info("info getAirportNames are more" );
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        } else {
            throw new NotFoundException("No Data");
        }
    }*/

}