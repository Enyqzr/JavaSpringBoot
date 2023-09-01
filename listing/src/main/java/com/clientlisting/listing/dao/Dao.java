package com.clientlisting.listing.dao;

import com.clientlisting.listing.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Dao extends JpaRepository<Client, Integer> {



    List<Client> findAll();
    Client findById(int id);
    Client save(Client clients);
//    Client modifyClients(int id, Client clients);
    Client deleteById(int id);
//


}
