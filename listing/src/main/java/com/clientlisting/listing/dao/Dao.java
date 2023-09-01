package com.clientlisting.listing.dao;

import com.clientlisting.listing.model.Client;

import java.util.List;

public interface Dao {

    List<Client> findAll();
    Client findById(int id);
    Client save(Client clients);
    Client modifyClients(int id, Client clients);
    Client deleteClients(int id);



}
