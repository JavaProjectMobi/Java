package com.walid.mobi.web;

import com.walid.mobi.entities.TelphoneMobile;
import com.walid.mobi.metier.ITelephone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TelphoneMobileController {

    @Autowired
    private ITelephone telephoneimp;

    @RequestMapping("/listTelphones")
    public String listTelphones(Model model){

        model.addAttribute("telphones",telephoneimp.findAll());
        return "telphones";
    }

    @RequestMapping(value="/deleteTelphone/{idArt}", method = RequestMethod.GET)
    public String deleteTelphone(Model model, @PathVariable(required = true, name = "idArt") Long idArt) {
        telephoneimp.delete(idArt);
        model.addAttribute("telphones", telephoneimp.findAll());
        return "telphones";
    }

    @RequestMapping(value={"/editTelphone","/editTelphone/{idArt}"}, method = RequestMethod.GET)
    public String editform(Model model, @PathVariable(required = false, name = "idArt") Long idArt) {
        if (null != idArt) {
            model.addAttribute("telphones", telephoneimp.findById(idArt));
        } else {
            model.addAttribute("telphones", new TelphoneMobile());
        }
        return "editTelphone";
    }

    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String edit(Model model, TelphoneMobile telphone) {
        telephoneimp.create(telphone);
        model.addAttribute("telphones", telephoneimp.findAll());
        return "telphones";
    }

    @RequestMapping("/consulterTelphone")
    public String consulter(Model model, Long idArt){
        try {
            TelphoneMobile Tel = telephoneimp.consulterTelphoneMobile(idArt);
            model.addAttribute("telphones",Tel);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }

        return "telphones";
    }

    @RequestMapping(value="/formCreateTelphone", method= RequestMethod.GET)
    public String formTelphone(Model model){
        model.addAttribute("telphones",new TelphoneMobile());
        return "addTelephone";
    }

    @RequestMapping(value="/createTelphone", method= RequestMethod.POST)
    public String saveTelphone(Model model,TelphoneMobile telphoneMobile){

        try{
            telephoneimp.create(telphoneMobile);

        } catch(Exception e) {
            model.addAttribute("error", e);
            return "redirect:/consulterTelphone"+e.getMessage();
        }

        return "redirect:/listTelphones";
    }
}
