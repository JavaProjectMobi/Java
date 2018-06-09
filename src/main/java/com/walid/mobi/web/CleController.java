package com.walid.mobi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.walid.mobi.entities.Cle;
import com.walid.mobi.metier.ICle;

@Controller
public class CleController {
	
	@Autowired
	private ICle cleimpl;
	
	
	@RequestMapping("/listCle")
    public String listArticles(Model model){

        model.addAttribute("cles",cleimpl.findAll());
        return "cles";
    }
    
    @RequestMapping(value="/deleteCle/{idArt}", method = RequestMethod.GET)
    public String deleteArticle(Model model, @PathVariable(required = true, name = "idArt") Long idArt) {
        cleimpl.delete(idArt);
        model.addAttribute("cles", cleimpl.findAll());
        return "cles";
    }

    @RequestMapping(value={"/editCle","/editCle/{idArt}"}, method = RequestMethod.GET)
    public String editform(Model model, @PathVariable(required = false, name = "idArt") Long idArt) {
        if (null != idArt) {
            model.addAttribute("cles", cleimpl.findById(idArt));
        } else {
            model.addAttribute("cles", new Cle());
        }
        return "editCle";
    }

    @RequestMapping(value="/editCle", method = RequestMethod.POST)
    public String edit(Model model, Cle article) {
        cleimpl.create(article);
        model.addAttribute("cles", cleimpl.findAll());
        return "cles";
    }

    @RequestMapping("/consulterCle")
    public String consulter(Model model, Long cin){
        try {
            Cle art = cleimpl.consulterCle(cin);
            model.addAttribute("article",art);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }

        return "cles";
    }

    @RequestMapping(value="/formCreateCle", method= RequestMethod.GET)
    public String formArticle(Model model){
        model.addAttribute("cle",new Cle());
        return "addCle";
    }

    @RequestMapping(value="/createCle", method= RequestMethod.POST)
    public String saveArticle(Model model,Cle article){
        try{
            cleimpl.create(article);

        } catch(Exception e) {
            model.addAttribute("error", e);
            return "redirect:/consulterCles"+e.getMessage();
        }

        return "redirect:/listCles";
    }

}
