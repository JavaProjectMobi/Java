package com.walid.mobi.web;

import com.walid.mobi.entities.Client;
import com.walid.mobi.metier.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {

    @Autowired
    private IClient clientimp;

    @RequestMapping("/listClients")
    public String listClients(Model model){

        model.addAttribute("clients",clientimp.findAll());
        return "clients";
    }

    @RequestMapping(value="/delete/{cin}", method = RequestMethod.GET)
    public String deleteClient(Model model, @PathVariable(required = true, name = "cin") Long cin) {
        clientimp.delete(cin);
        model.addAttribute("clients", clientimp.findAll());
        return "clients";
    }

    @RequestMapping(value={"/edit","/edit/{cin}"}, method = RequestMethod.GET)
    public String editform(Model model, @PathVariable(required = false, name = "cin") Long cin) {
        if (null != cin) {
            model.addAttribute("clients", clientimp.findById(cin));
        } else {
            model.addAttribute("clients", new Client());
        }
        return "editClient";
    }

    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String edit(Model model, Client client) {
        clientimp.create(client);
        model.addAttribute("clients", clientimp.findAll());
        return "clients";
    }

    @RequestMapping("/consulterClient")
    public String consulter(Model model, Long cin){
        try {
            Client ct = clientimp.consulterClient(cin);
            model.addAttribute("client",ct);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }

        return "clients";
    }

    @RequestMapping(value="/formCreate", method= RequestMethod.GET)
    public String formClient(Model model){
        model.addAttribute("client",new Client());
        return "addClient";
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String saveClient(Model model,Client client){

        try{
           clientimp.create(client);

        } catch(Exception e) {
            model.addAttribute("error", e);
            return "redirect:/consulterClient"+e.getMessage();
        }

        return "redirect:/listClients";
    }
}
