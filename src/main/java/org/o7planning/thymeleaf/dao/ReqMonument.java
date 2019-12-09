package org.o7planning.thymeleaf.dao;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
//https://github.com/BorderCloud/SPARQL-JAVA
//import org.apache.jena.query.Quer;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.reasoner.rulesys.builtins.Equal;
import org.apache.jena.graph.Node_Variable;
import org.o7planning.thymeleaf.model.Monument;
import org.openrdf.query.algebra.IsNumeric;
import org.springframework.stereotype.Repository;
import org.apache.jena.sparql.core.Var;
import org.apache.jena.sparql.core.Vars;

//import com.bordercloud.sparql.Endpoint;
//import com.bordercloud.sparql.EndpointException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Repository
public class ReqMonument {
	private String Point = "3.876716 43.610769";
	
    

    public List<Monument> calculerAutour(String point){
    	List<Monument> ListMonument = new ArrayList<Monument>();
    	String queryString = "PREFIX wd: <http://www.wikidata.org/entity/>\n" +
        		"PREFIX geo: <http://www.opengis.net/ont/geosparql#>" +
                "PREFIX wdt: <http://www.wikidata.org/prop/direct/>\n" +
                "PREFIX wikibase: <http://wikiba.se/ontology#>\n" +
                "PREFIX p: <http://www.wikidata.org/prop/>\n" +
                "PREFIX ps: <http://www.wikidata.org/prop/statement/>\n" +
                "PREFIX pq: <http://www.wikidata.org/prop/qualifier/>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX bd: <http://www.bigdata.com/rdf#>\n" +
                "\n" +
                "#Monuments et autre éléments d'héritage situés dans un rayon de 1 km autour de la zone de localisation des utilisateurs\n" +
                "#defaultView:Map\n" +
                "SELECT DISTINCT ?monument ?monumentLabel ?heritageLabel ?image ?location WHERE {\n" +
                "  ?monument wdt:P1435 ?heritage.\n" +
                "  SERVICE wikibase:around {\n" +
                "    ?monument wdt:P625 ?location.\n" +
                "    bd:serviceParam wikibase:center \"Point(" + Point + ")\"^^geo:wktLiteral;\n" +
                "      wikibase:radius \"5\";\n" +
                "      wikibase:distance ?distance.\n" +
                "  }\n" +
                "  OPTIONAL { ?monument wdt:P18 ?image. }\n" +
                "  SERVICE wikibase:label { bd:serviceParam wikibase:language \"fr\". }\n" +
                "}\n" +
                "GROUP BY ?monument ?monumentLabel ?heritageLabel ?image ?location\n" +
                "\n" +
                "LIMIT 10";                     
        Query query = QueryFactory.create(queryString) ;

//        System.out.println(queryString);

        QueryExecution qexec = QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", query);        
        ResultSet results = qexec.execSelect();
//        ResultSetFormatter.out(System.out, results, query) ;
    	
        while (results.hasNext()) {
        	QuerySolution s = results.next();
        	
        	int turn = s.get("location").toString().indexOf("(");
        	int turnof = s.get("location").toString().indexOf(")");
        	String cod = s.get("location").toString().substring(turn+1, turnof-1);
        	String lon = cod.split(" ")[0];
        	String lat = cod.split(" ")[1];
        	
        	 	
        	if (s.get("image") != null){
        		Monument m = new Monument(s.get("monument").toString().split("/")[4], s.get("monumentLabel").asLiteral().getString(), s.get("heritageLabel").asLiteral().getString(), s.get("image").toString(),lon, lat);
        		System.out.println(m.toString());
        		ListMonument.add(m);
        	}else {
        		Monument m = new Monument(s.get("monument").toString().split("/")[4], s.get("monumentLabel").asLiteral().getString(), s.get("heritageLabel").asLiteral().getString(), lon, lat);
        		System.out.println(m.toString());
        		ListMonument.add(m);
        	}
        }	
    	return ListMonument;
    
    
//	public static ArrayList<Monument> main(String[] args) {
//
//        String queryString = "PREFIX wd: <http://www.wikidata.org/entity/>\n" +
//        		"PREFIX geo: <http://www.opengis.net/ont/geosparql#>" +
//                "PREFIX wdt: <http://www.wikidata.org/prop/direct/>\n" +
//                "PREFIX wikibase: <http://wikiba.se/ontology#>\n" +
//                "PREFIX p: <http://www.wikidata.org/prop/>\n" +
//                "PREFIX ps: <http://www.wikidata.org/prop/statement/>\n" +
//                "PREFIX pq: <http://www.wikidata.org/prop/qualifier/>\n" +
//                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
//                "PREFIX bd: <http://www.bigdata.com/rdf#>\n" +
//                "\n" +
//                "#Monuments et autre éléments d'héritage situés dans un rayon de 1 km autour de la zone de localisation des utilisateurs\n" +
//                "#defaultView:Map\n" +
//                "SELECT DISTINCT ?monument ?monumentLabel ?heritageLabel ?image ?location WHERE {\n" +
//                "  ?monument wdt:P1435 ?heritage.\n" +
//                "  SERVICE wikibase:around {\n" +
//                "    ?monument wdt:P625 ?location.\n" +
//                "    bd:serviceParam wikibase:center \"Point(" + Point + ")\"^^geo:wktLiteral;\n" +
//                "      wikibase:radius \"5\";\n" +
//                "      wikibase:distance ?distance.\n" +
//                "  }\n" +
//                "  OPTIONAL { ?monument wdt:P18 ?image. }\n" +
//                "  SERVICE wikibase:label { bd:serviceParam wikibase:language \"fr\". }\n" +
//                "}\n" +
//                "GROUP BY ?monument ?monumentLabel ?heritageLabel ?image ?location\n" +
//                "\n" +
//                "LIMIT 100";                     
//        Query query = QueryFactory.create(queryString) ;
//
////        System.out.println(queryString);
//
//        QueryExecution qexec = QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", query);        
//        ResultSet results = qexec.execSelect();
////        ResultSetFormatter.out(System.out, results, query) ;
//    	
//        while (results.hasNext()) {
//        	QuerySolution s = results.next();
//        	
//        	int turn = s.get("location").toString().indexOf("(");
//        	int turnof = s.get("location").toString().indexOf(")");
//        	String cod = s.get("location").toString().substring(turn+1, turnof-1);
//        	String lon = cod.split(" ")[0];
//        	String lat = cod.split(" ")[1];
//        	
//        	//System.out.println(cod);		
////        	System.out.println(s.get("monument").toString());
////        	System.out.println(s.get("monumentLabel").asLiteral().getString());
////        	System.out.println(s.get("heritageLabel").asLiteral().getString());
////        	System.out.println(s.varNames().);
//        	
////        	while (s.varNames() != null) {
////        		Monument m = new Monument();
////        		String Attribute = s.toString();
////        		System.out.println(s.varNames());
////        		m.setProperty(s.varNames(), );
////        	}
//        	
//        	
//        	if (s.get("image") != null){
//        		Monument m = new Monument(s.get("monument").toString().split("/")[4], s.get("monumentLabel").asLiteral().getString(), s.get("heritageLabel").asLiteral().getString(), s.get("image").toString(),lon, lat);
//        		System.out.println(m.toString());
//        		ListMonument.add(m);
//        	}else {
//        		Monument m = new Monument(s.get("monument").toString().split("/")[4], s.get("monumentLabel").asLiteral().getString(), s.get("heritageLabel").asLiteral().getString(), lon, lat);
//        		System.out.println(m.toString());
//        		ListMonument.add(m);
//        	}
//        	
//        	
//        }
//        
//        for (Monument e : ListMonument) {
//        	System.out.println(e.getLat()+ " / " + e.getLong());
////        	Req1Monument r = new Req1Monument(e.getMonument().split("/")[4]);
//        	System.out.println(e.getMonument());
//		} 
//        return ListMonument;	
//        
//
//    }


}
}
