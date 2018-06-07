package com.walid.mobi.metier.Impl;

import com.walid.mobi.dao.ClientRepository;
import com.walid.mobi.entities.Client;
import com.walid.mobi.metier.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ClientImpl implements IClient {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client create(Client client){
        Client newClient= client;
       return clientRepository.save(newClient);
    }

    @Override
    public Client consulterClient(Long cin) {
        Client client = clientRepository.findOne(cin);
        if(client == null) throw new RuntimeException("Client introuvable");
        return client;
    }

    @Override
    public Client update(Client client){
        Client newClient= client;
        return clientRepository.save(newClient);
    }

    @Override

    public Client findById(Long cin){
        return clientRepository.findOne(cin);
    }

    @Override

    public List<Client> findAll(){
        List<Client> clients= clientRepository.findAll();
        return clients;
    }

    @Override

    public Client delete(Long idCl) {
        Client deletedClient = clientRepository.findOne(idCl);
        if (deletedClient == null)
        throw new RuntimeException("Client not found");
        clientRepository.delete(deletedClient);

        return deletedClient;

    }



}
