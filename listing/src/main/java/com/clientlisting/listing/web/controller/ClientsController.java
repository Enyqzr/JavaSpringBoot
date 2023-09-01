package com.clientlisting.listing.web.controller;


import com.clientlisting.listing.dao.Dao;
import com.clientlisting.listing.model.Client;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientsController {

//    RestTemplate restTemplate = new RestTemplate();
//
//
    @Autowired
    private Dao clientsDao;


    @RequestMapping(value = "/Produits", method = RequestMethod.GET)

    public MappingJacksonValue listeProduits() {

        Iterable<Client> clients = clientsDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue clientsFiltres = new MappingJacksonValue(clients);

        clientsFiltres.setFilters(listDeNosFiltres);

        return clientsFiltres;
    }
//
//    public ClientsController(ClientsDao clientsDao) {
//        this.clientsDao = clientsDao;
//    }
//
    @ApiOperation(value = "Affiche la liste des clients.")
    @GetMapping("/Clients")
    public List<Client> clientArrayList() {
        return clientsDao.findAll();
    }
//
//
    @ApiOperation(value = "Récupère un client via son id, a condition qu'il soit en stock.")
    @GetMapping("/Clients/{id}")
    public Client findClientById(@PathVariable int id) {
        return clientsDao.findById(id);
    }
//
    @ApiOperation(value = "Ajoute un client a la liste.")
    @PostMapping("/Clients")
    public void addClients(@RequestBody Client client) {
        //isValidPermissionNb(client.getPermissionNb());
        clientsDao.save(client);
    }
//
    @ApiOperation(value = "Modifie un client déjà existant.")
    @PutMapping("/Clients")
    public Client modifyClientById( @RequestBody Client clients) {
//       isValidPermissionNb(clients.getPermissionNb());
       return  clientsDao.save(clients);
    }
//
    @ApiOperation(value = "Supprime un client déjà existant de la liste.")
    @DeleteMapping("/Clients/{id}")
    public Client deleteClientById(@PathVariable int id) {
         return  clientsDao.deleteById(id);
    }
//
//    public void isValidPermissionNb (String permissionNb){
//        Boolean isValid = restTemplate.getForObject("http://localhost:8081/licenses/" + permissionNb, Boolean.class);
//        if(isValid ==null ||!isValid){
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "Entity not found"
//            );
//
//        }
//    }
}


//    ArrayList<Client> listClients = new ArrayList<Client>() {
//        {
//            try {
//                add(new Client(1, "Pelletos", "Bastianos", new SimpleDateFormat("yyyy-MM-dd XXX").parse("1998-06-04 +00:00"), 42545 ));
//                add(new Client(2, "Wadyu", "Upgrade", new SimpleDateFormat("yyyy-MM-dd XXX").parse("1999-02-24 +00:00"), 000010));
//                add(new Client(3, "Kylion", "Lanister",new SimpleDateFormat("yyyy-MM-dd XXX").parse("2004-05-19 +00:00"),152525 ));
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//    };
//
//
//    @GetMapping("/Clients")
//    public ArrayList<Client> listeClients() {
//        return listClients;
//
//    }
//
//
////    @GetMapping("/Bonjour/{id}")
////    public Clients listeClients (@PathVariable int id){
////        Clients findClient =null;
////        for(Clients clients : listClients){
////            if (clients.getId() == id){
////                findClient =clients;
////                return findClient;
////            }
////
////
////        }
////        return  findClient;
////    }
//
//    @GetMapping("/Bonjour/{id}")
//    public Client listeClients (@PathVariable int id){
//        Client findClient =null;
//        for(int i = 0; i < listClients.size(); i++){
//            if (listClients.get(i).getId() == id){
//                findClient = listClients.get(i);
//                return findClient;
//            }
//
//
//        }
//        return  findClient;
//    }
