package com.walid.mobi.web;

import com.walid.mobi.entities.Article;
import com.walid.mobi.entities.Client;
import com.walid.mobi.metier.IArticle;
import com.walid.mobi.metier.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class articleController {


    @Autowired
    private IArticle articleimp;
    @Autowired
    private IClient clientimp;

    public List<Client> clients;


    @RequestMapping("/listArticles")
    public String listArticles(Model model){

        model.addAttribute("articles",articleimp.findAll());
        return "articles";
    }
    @ModelAttribute("allClients")
    public List<Client> populateClients(Model model) {
        clients = this.clientimp.findAll();
        model.addAttribute("clients",clients);
        return clients;
    }
    @RequestMapping(value="/deleteArticle/{idArt}", method = RequestMethod.GET)
    public String deleteArticle(Model model, @PathVariable(required = true, name = "idArt") Long idArt) {
        articleimp.delete(idArt);
        model.addAttribute("articles", articleimp.findAll());
        return "articles";
    }

    @RequestMapping(value={"/editArticle","/editArticle/{idArt}"}, method = RequestMethod.GET)
    public String editform(Model model, @PathVariable(required = false, name = "idArt") Long idArt) {
        if (null != idArt) {
            model.addAttribute("articles", articleimp.findById(idArt));
        } else {
            model.addAttribute("articles", new Article());
        }
        return "editArticle";
    }

    @RequestMapping(value="/editArticle", method = RequestMethod.POST)
    public String edit(Model model, Article article) {
        articleimp.create(article);
        model.addAttribute("articles", articleimp.findAll());
        return "articles";
    }

    @RequestMapping("/consulterArticle")
    public String consulter(Model model, Long cin){
        try {
            Article art = articleimp.consulterArticle(cin);
            model.addAttribute("article",art);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }

        return "articles";
    }

    @RequestMapping(value="/formCreateArticle", method= RequestMethod.GET)
    public String formArticle(Model model){
        model.addAttribute("article",new Article());
        return "addArticle";
    }

    @RequestMapping(value="/createArticle", method= RequestMethod.POST)
    public String saveArticle(Model model,Article article){
        try{
            articleimp.create(article);

        } catch(Exception e) {
            model.addAttribute("error", e);
            return "redirect:/consulterClient"+e.getMessage();
        }

        return "redirect:/listArticles";
    }
}
