package com.angelalfaro.kinalapp.controller;

import com.angelalfaro.kinalapp.entity.Client;
import com.angelalfaro.kinalapp.service.client.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RestController = @Controller + @RequestBody
@RequestMapping("/clients")
//All the endpoints of this controller will begin with "/clients"
public class ClientController {

    //Inject the Service no the Repository
    //The controller only have connection with the service
    private final ClientService clientService;

    //As a good tip the injection of dependecies is on the constructor
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //Response GET requests
    @GetMapping
    /// Response Entity allows control the http and the body
    public ResponseEntity<List<Client>> list(){

        List<Client> clients = clientService.listAll();
        //Delegate to service
        return ResponseEntity.ok(clients);
        // status 200 ok with the client list
    }

    //Response GET requests by State
    @GetMapping("/actives")
    /// Response Entity allows control the http and the body
    public ResponseEntity<List<Client>> listByState(){

        List<Client> clients = clientService.listAllByState();
        //Delegate to service
        return ResponseEntity.ok(clients);
        // status 200 ok with the client list
    }

    //{DPIClient} is a path variable (value to find)
    @GetMapping("/{DPIClient}")
    public ResponseEntity<Client> getByDPI(@PathVariable(name = "DPIClient") String dpi){
        //@PathVariable take the url value, and assign into dpi
        return clientService.findByDPI(dpi)
                //If Optional has a value, return status 200 ok with the client
                .map(ResponseEntity::ok)
                //if not, return status 404 not found
                .orElse(ResponseEntity.notFound().build());
    }

    //Post create a new Client
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Client c){
        //@RequestBody: take the JSON of the body and transform into a object of type Client
        //<?>: it's a generic type, can be a Client or String

        try {

            Client newClient = clientService.save(c);
            //Try save the client, but can throw an exception of IllegalArgumentException

            return new ResponseEntity<>(newClient, HttpStatus.CREATED);
            //return status 201 create (more specificly than status 200)

        } catch (IllegalArgumentException e) {
            //If have an error of validation, return status 400 badrequest
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{DPIClient}")
    public ResponseEntity<Void> delete(@PathVariable(name = "DPIClient") String dpi){
        //ResponseEntity<Void>: don't return body in the response
        try {

            if (!clientService.existByDPI(dpi)){
                return ResponseEntity.notFound().build();
                // return status 404 not found
            }

            clientService.delete(dpi);
            return ResponseEntity.noContent().build();
            // return status 204 no content (execute succesfuly and return nothing)

        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
            // return status 404 not found
        }
    }

    //Update client by the DPI
    @PutMapping("/{DPIClient}")
    public ResponseEntity<?> update(@PathVariable(name = "DPIClient") String dpi, @RequestBody Client c){

        try {
            if (!clientService.existByDPI(dpi)){
                //verify if exist before update
                return ResponseEntity.notFound().build();
                // return status 404 not found
            }
            //Update client but can throw an exception
            Client updClient = clientService.update(dpi,c);

            return ResponseEntity.ok(updClient);
            // return status 200 with the updated client

        } catch (IllegalArgumentException e) {
            //Error when the data are incorrect
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e){
            //Posibly amy error, like: client not found, etc
            return ResponseEntity.notFound().build();
        }

    }

}
