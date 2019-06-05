package it.polito.tdp.model;


import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.db.EventsDao;

public class Model {
	
	private List<Event> eventi=new LinkedList<Event>();
	private List<Anno> anni= new LinkedList<Anno>();
	private EventsDao dao;
	private Graph<Centro,DefaultWeightedEdge> grafo;
	private List<Centro> centri;
	private List<Vicini> vicini;
	
	
	public Model() {
		dao=new EventsDao();		
		
	}
	
	public List<Anno> getAnni(){
		return this.dao.getAnni();
	}
	
	public List<Centro> getCentri(Year anno){
		return this.dao.getCentri(anno);
	}
	
	
	public void creaGrafo(Year anno) {
		this.grafo=new SimpleWeightedGraph<Centro,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		this.centri=this.dao.getCentri(anno);
		Graphs.addAllVertices(this.grafo, this.centri);
		
		for(Centro c:this.centri) {
			for(Centro d:this.centri) {
				if(!c.equals(d)) {
					//CREA FUNZIONE
					LatLng a=new LatLng(c.getLatitudine(),c.getLongitudine());
					LatLng b=new LatLng(d.getLatitudine(),d.getLongitudine());
					double distance=LatLngTool.distance(a, b, LengthUnit.KILOMETER);
					DefaultWeightedEdge edge=grafo.getEdge(c, d);
					
					if(edge==null) {
					Graphs.addEdge(grafo,c, d, distance);
					
				
					
					Vicini vi=new Vicini(c,d,distance);
					vicini.add(vi);
					
					
					}
					
				}
			}
		}
	}
	
	public String ordinati(Year anno){
	
		String s="";
			
		
		for(Centro c:this.centri) {
			
			List<Centro> cc=Graphs.neighborListOf(grafo, c);
			List<Vicini> vv=new ArrayList<>();
			
			for(Centro centr:cc) {
				vv.add(new Vicini(c,centr,))
			}
			Collections.sort(cc, new ComparatoreDistanza());
			
			
		}
		
		return s;
	}
	
}
