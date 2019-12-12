package bddControl.dao;

import java.util.Collection;

import org.hibernate.engine.profile.Association;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bddControl.Entity.Commentaire;
import bddControl.Entity.IpConnue;
import bddControl.Entity.MonumentBdd;
import bddControl.metier.IbddMetiers; class test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IbddMetiers metier = (IbddMetiers) context.getBean("metier");
		
		IpConnue ip1 = new IpConnue("1.21.3.5");
		System.out.println("ip = " + ip1.getIP() );
		IpConnue ip2 = new IpConnue("1.21.3.6");
		System.out.println("ip = " + ip2.getIP() );
		IpConnue ip3 = new IpConnue("1.21.3.7");
		System.out.println("ip = " + ip3.getIP() );
//		
		MonumentBdd m1 = new MonumentBdd("Q22953925");
		System.out.println("Monument Code  = " + m1.getCodeRDF());
		MonumentBdd m2 = new MonumentBdd("Q22953974");
		System.out.println("Monument Code  = " + m2.getCodeRDF());
		MonumentBdd m3 = new MonumentBdd("Q20127550");
		System.out.println("Monument Code  = " + m2.getCodeRDF());
//		
		Commentaire c1 = new Commentaire("1 commentairetext car ce n'est pas une option");
		System.out.println("Commentaire text = " + c1.getCommentairetext());
		Commentaire c2 = new Commentaire("2 commentairetext car ce n'est pas une option");
		System.out.println("Commentaire text = " + c2.getCommentairetext());
		Commentaire c3 = new Commentaire("3 commentairetext car ce n'est pas une option");
		System.out.println("Commentaire text = " + c3.getCommentairetext());
		Commentaire c4 = new Commentaire("4 commentairetext car ce n'est pas une option");
		System.out.println("Commentaire text = " + c4.getCommentairetext());
		Commentaire c5 = new Commentaire("4 commentairetext car ce n'est pas une option");
		System.out.println("Commentaire text = " + c5.getCommentairetext());
		
//		metier.addVisite(m1.getCodeRDF(), ip1.getIP());
//		//System.out.println("Commentaire text = " + c1.getCommentairetext());
//		metier.addVisite(m2.getCodeRDF(), ip1.getIP());
//		//System.out.println("Commentaire text = " + c1.getCommentairetext());
//		metier.addVisite(m3.getCodeRDF(), ip1.getIP());
		
//		Collection<Commentaire> coms = metier.getCommentairesbyIP(ip1);
//		for (Commentaire c : coms) {
//			System.out.println("Commentaire text ip= " + c.getCommentairetext());
//		}
		
//		Collection<Commentaire> comm = metier.getListCommentairesByMonument(m1);
//		for (Commentaire c : comm) {
//			System.out.println("Commentaire text m= " + c.getCommentairetext());
//		}
		
		
		
		
		/*
		 drop table AssocieA; drop table Celebrite; drop table Monument; drop table Lieu; drop table Departement;

		 select * from Departement; select * from Lieu; select * from Monument; select * from Celebrite; select * from AssocieA;
		*/
	}
}
