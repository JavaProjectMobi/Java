package com.walid.mobi;

import com.walid.mobi.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.walid.mobi.dao.ArticleRepository;
import com.walid.mobi.dao.ClientRepository;
import com.walid.mobi.dao.CommandeRepository;
import com.walid.mobi.dao.ReglementRepository;
import com.walid.mobi.dao.UserRepository;

@SpringBootApplication
public class MobiApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private ReglementRepository reglementRepository;
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MobiApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		//clientRepository.save(new Client(112L,"charfi","benmed","hbbjk","edsf"));
		
	}
}
