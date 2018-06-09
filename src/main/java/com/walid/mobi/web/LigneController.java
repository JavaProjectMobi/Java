package com.walid.mobi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.walid.mobi.entities.Article;
import com.walid.mobi.entities.Ligne_Telep;
import com.walid.mobi.metier.ILigne;

@Controller
public class LigneController {

	@Autowired
	private ILigne ligneimpl;
	
	@RequestMapping("/listLignes")
    public String listArticles(Model model){

        model.addAttribute("lignes",ligneimpl.findAll());
        return "lignes";
    }
    
    @RequestMapping(value="/deleteLigne/{idArt}", method = RequestMethod.GET)
    public String deleteArticle(Model model, @PathVariable(required = true, name = "idArt") Long idArt) {
        ligneimpl.delete(idArt);
        model.addAttribute("lignes", ligneimpl.findAll());
        return "lignes";
    }

    @RequestMapping(value={"/editLigne","/editLigne/{idArt}"}, method = RequestMethod.GET)
    public String editform(Model model, @PathVariable(required = false, name = "idArt") Long idArt) {
        if (null != idArt) {
            model.addAttribute("lignes", ligneimpl.findById(idArt));
        } else {
            model.addAttribute("lignes", new Article());
        }
        return "editLigne";
    }

    @RequestMapping(value="/editLigne", method = RequestMethod.POST)
    public String edit(Model model, Ligne_Telep article) {
        ligneimpl.create(article);
        model.addAttribute("lignes", ligneimpl.findAll());
        return "lignes";
    }

    @RequestMapping("/consulterLigne")
    public String consulter(Model model, Long cin){
        try {
           Ligne_Telep art = ligneimpl.consulterLigne(cin);
            model.addAttribute("ligne",art);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }

        return "lignes";
    }

    @RequestMapping(value="/formCreateLigne", method= RequestMethod.GET)
    public String formArticle(Model model){
        model.addAttribute("ligne",new Ligne_Telep());
        return "addLigne";
    }

    @RequestMapping(value="/createLigne", method= RequestMethod.POST)
    public String saveArticle(Model model,Ligne_Telep article){
        try{
            ligneimpl.create(article);

        } catch(Exception e) {
            model.addAttribute("error", e);
            return "redirect:/consulterLignes"+e.getMessage();
        }

        return "redirect:/listLignes";
    }
}
