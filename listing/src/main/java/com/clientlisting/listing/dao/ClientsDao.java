package com.clientlisting.listing.dao;

import com.clientlisting.listing.model.Client;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


@Repository
public class ClientsDao implements Dao {

    public static ArrayList<Client> clientsArrayList = new ArrayList<>();

    static {
        try {
        clientsArrayList.add(new Client(6, "Zaky", "Chan", new SimpleDateFormat("yyyy-MM-dd XXX").parse("2002-10-23 +00:00"),"aaa1421"));
            clientsArrayList.add(new Client(7, "Lucavava", "HoangMinSon", new SimpleDateFormat("yyyy-MM-dd XXX").parse("2002-02-10 +00:00"),"aaa14251"));
            clientsArrayList.add(new Client(8, "Hichamus", "Maximus Platipus", new SimpleDateFormat("yyy-MM-dd XXX").parse("867-04-10 +00:00"),"aaa74578" ));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public ArrayList<Client> findAll() {
        return clientsArrayList;
    }

    @Override
    public Client findById(int id) {
        for(Client client : clientsArrayList){
            if(client.getId() == id){
                return client;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Client not exist with id : " + id
        );
    }

   @Override
    public Client save (Client clients){
       clientsArrayList.add(clients);
       return clients;
   }

   @Override
    public Client modifyClients(int id, Client clients){
    Client modifyClients = findById(id);

    modifyClients.setName(clients.getName());
    modifyClients.setFirstName(clients.getFirstName());
    modifyClients.setDateOfBirth(clients.getDateOfBirth());
    modifyClients.setPermissionNb(clients.getPermissionNb());

    return modifyClients;
   }
   @Override
   public Client deleteClients (int id){
        Client deleteCustomer = findById(id);
        clientsArrayList.remove(deleteCustomer);
        return deleteCustomer;
   }
}
