package com.walid.mobi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.walid.mobi.entities.Carte;
import com.walid.mobi.metier.ICarte;

@Controller
public class CarteController {
	
	@Autowired
	private ICarte carteimpl;
	
	@RequestMapping("/listCarte")
    public String listCartes(Model model){
        model.addAttribute("cartes",carteimpl.findAll());
        return "cartes";
    }
    
    @RequestMapping(value="/deleteCarte/{idArt}", method = RequestMethod.GET)
    public String deleteCarte(Model model, @PathVariable(required = true, name = "idArt") Long idArt) {
        carteimpl.delete(idArt);
        model.addAttribute("cartes", carteimpl.findAll());
        return "cartes";
    }

    @RequestMapping(value={"/editCarte","/editCarte/{idArt}"}, method = RequestMethod.GET)
    public String editform(Model model, @PathVariable(required = false, name = "idArt") Long idArt) {
        if (null != idArt) {
            model.addAttribute("cartes", carteimpl.findById(idArt));
        } else {
            model.addAttribute("cartes", new Carte());
        }
        return "editCarte";
    }

    @RequestMapping(value="/editCarte", method = RequestMethod.POST)
    public String edit(Model model, Carte article) {
        carteimpl.create(article);
        model.addAttribute("cartes", carteimpl.findAll());
        return "cartes";
    }
    
    @RequestMapping("/consulterCarte")
    public String consulter(Model model, Long cin){
        try {
            Carte art = carteimpl.consulterCarte(cin);
            model.addAttribute("carte",art);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }

        return "cartes";
    }

    @RequestMapping(value="/formCreateCarte", method= RequestMethod.GET)
    public String formArticle(Model model){
        model.addAttribute("carte",new Carte());
        return "addCarte";
    }

    @RequestMapping(value="/createCarte", method= RequestMethod.POST)
    public String saveCarte(Model model,Carte carte){
        try{
            carteimpl.create(carte);

        } catch(Exception e) {
            model.addAttribute("error", e);
            return "redirect:/consulterCartes"+e.getMessage();
        }

        return "redirect:/listCartes";
    }

}
