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
import org.apache.jena.sparql.core.Var;
import org.apache.jena.sparql.core.Vars;

//import com.bordercloud.sparql.Endpoint;
//import com.bordercloud.sparql.EndpointException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Req1Monument {
	public static String code = "Q1736197";	
	public static ArrayList<String> Listattrib = new ArrayList<String>();
	public static Map<String, String> properties = new HashMap<String, String>();
//	private Map<String, Callable<Object>> callables = new HashMap<String, Callable<Object>>();
	
	public Req1Monument(String code) {
		Req1Monument.code = code;
	}
	
	public String getProperty(String key) {
      return properties.get(key);
	}

	public void setProperty(String key, String value) {
      properties.put(key, value);
	}
	
    

	public static void main(String[] args) {

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
        	
        	Req1Monument.properties.put(s.get("wdLabel").toString(), s.get("ps_Label").toString());		
//        	
        	System.out.println(s.get("wdLabel").toString() + " / " + properties.get(s.get("wdLabel").toString()));
//        	System.out.println(s.get("monumentLabel").asLiteral().getString());
//        	System.out.println(s.get("heritageLabel").asLiteral().getString());
//        	System.out.println(s.varNames().);
        	
//        	while (s.varNames() != null) {
//        		Monument m = new Monument();
//        		String Attribute = s.toString();
//        		System.out.println(s.varNames());
//        		m.setProperty(s.varNames(), );
//        	}
        	
        	
//        	if (s.get("image") != null){
//        		ument(s.get("monument").toString(), s.get("monumentLabel").asLiteral().getString(), s.get("heritageLabel").asLiteral().getString(), s.get("image").toString());
//        		System.out.println(m.toString());
//        		Listattrib.add(m);
//        	}else {
//        		Monument m = new Monument(s.get("monument").toString(), s.get("monumentLabel").asLiteral().getString(), s.get("heritageLabel").asLiteral().getString());
//        		System.out.println(m.toString());
//        		ListMonument.add(m);
//        	}
//        	
//        	Listattrib.
//        }
//        for (String e : Listattrib) {
//        	System.out.println(e.);
//		} 
        	
        

    }

//    public static HashMap<String, HashMap> retrieveData(String endpointUrl, String query) throws EndpointException {
//        Endpoint sp = new Endpoint(endpointUrl, false);
//        HashMap<String, HashMap> rs = sp.query(query);
//        return rs;
//    }

	/*
	 * public static void printResult(HashMap<String, HashMap> rs , int size) { for
	 * (String variable : (ArrayList<String>) rs.get("result").get("variables")) {
	 * System.out.print(String.format("%-"+size+"."+size+"s", variable ) + " | "); }
	 * System.out.print("\n"); for (HashMap value : (ArrayList<HashMap>)
	 * rs.get("result").get("rows")) { for (String variable : (ArrayList<String>)
	 * rs.get("result").get("variables")) {
	 * System.out.print(String.format("%-"+size+"."+size+"s", value.get(variable)) +
	 * " | "); } System.out.print("\n"); } }
	 */
}
}

