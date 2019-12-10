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
import org.apache.jena.graph.Node_Variable;
import org.o7planning.thymeleaf.model.Monument;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Multiset.Entry;

import org.apache.jena.sparql.core.Var;
import org.apache.jena.sparql.core.Vars;

//import com.bordercloud.sparql.Endpoint;
//import com.bordercloud.sparql.EndpointException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class Req1Monument {
	public static String code = "Q1736197";	
	
	public Map<String, String> getMonumentRDF(String code){
		Map<String, String> properties = new HashMap<String, String>();
        String queryString = "PREFIX hint: <http://www.bigdata.com/queryHints#>\n" +
                "PREFIX wd: <http://www.wikidata.org/entity/>\n" +
                "PREFIX wdt: <http://www.wikidata.org/prop/direct/>\n" +
                "PREFIX wikibase: <http://wikiba.se/ontology#>\n" +
                "PREFIX p: <http://www.wikidata.org/prop/>\n" +
                "PREFIX ps: <http://www.wikidata.org/prop/statement/>\n" +
                "PREFIX pq: <http://www.wikidata.org/prop/qualifier/>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX bd: <http://www.bigdata.com/rdf#>\n" +
                "\n" +
                "SELECT distinct ?wdLabel ?ps_Label ?wdpqLabel ?pq_Label {\n" +
                "  VALUES (?monument) {(wd:" + code + ")}\n" +
                "  \n" +
                "  ?monument ?p ?statement .\n" +
                "  ?statement ?ps ?ps_ .\n" +
                "  \n" +
                "  ?wd wikibase:claim ?p.\n" +
                "  ?wd wikibase:statementProperty ?ps.\n" +
                "  \n" +
                "  OPTIONAL {\n" +
                "  ?statement ?pq ?pq_ .\n" +
                "  ?wdpq wikibase:qualifier ?pq .\n" +
                "  }\n" +
                "  \n" +
                "  SERVICE wikibase:label { bd:serviceParam wikibase:language \"fr\" }\n" +
                "} ORDER BY ?wd ?statement ?ps_";                     
        Query query = QueryFactory.create(queryString) ;

//        System.out.println(queryString);

        QueryExecution qexec = QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", query);        
        ResultSet results = qexec.execSelect();
//        ResultSetFormatter.out(System.out, results, query) ;
    	
        while (results.hasNext()) {
        	QuerySolution s = results.next();
        	
        	properties.put(s.get("wdLabel").toString().replace("@fr", ""), s.get("ps_Label").toString().replace("@fr", ""));		
//        	
        	System.out.println(s.get("wdLabel").toString() + " / " + properties.get(s.get("wdLabel").toString()));
        }
        return properties;
	}

	public static void main(String[] args) {
		Map<String, String> properti; 
		properti = new Req1Monument().getMonumentRDF("Q1736197");
		for (java.util.Map.Entry<String, String> entry : properti.entrySet()){
			System.out.println(entry.getKey() + "=" + entry.getValue());
			
		}
	}


}

