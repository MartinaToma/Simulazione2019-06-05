package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.model.Anno;
import it.polito.tdp.model.Centro;
import it.polito.tdp.model.Event;


public class EventsDao {
	
	public List<Event> listAllEvents(){
		String sql = "SELECT * FROM events" ;
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			List<Event> list = new ArrayList<>() ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				try {
					list.add(new Event(res.getLong("incident_id"),
							res.getInt("offense_code"),
							res.getInt("offense_code_extension"), 
							res.getString("offense_type_id"), 
							res.getString("offense_category_id"),
							res.getTimestamp("reported_date").toLocalDateTime(),
							res.getString("incident_address"),
							res.getDouble("geo_lon"),
							res.getDouble("geo_lat"),
							res.getInt("district_id"),
							res.getInt("precinct_id"), 
							res.getString("neighborhood_id"),
							res.getInt("is_crime"),
							res.getInt("is_traffic")));
				} catch (Throwable t) {
					t.printStackTrace();
					System.out.println(res.getInt("id"));
				}
			}
			
			conn.close();
			return list ;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}
	
	public List<Anno> getAnni(){
		
		String sql="SELECT DISTINCT YEAR(reported_date) AS anno " + 
				"FROM events ";
		
		
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			List<Anno> anni=new LinkedList<Anno>();
			
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				Anno a=new Anno(Year.of(res.getInt("anno")));
				anni.add(a);
					
			}
			
			conn.close();
			return anni ;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}
	
	public List<Centro> getCentri(Year anno){
		
		String sql=" SELECT district_id, AVG(geo_lon) as A1, AVG(geo_lat) as A2 " + 
				"FROM EVENTS " + 
				"WHERE YEAR(reported_date)=?  " + 
				"GROUP BY district_id ";
		
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, anno.getValue());
			
			List<Centro> centri=new LinkedList<Centro>();
			
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				Centro a=new Centro(res.getInt("district_id"),res.getDouble("A1"),res.getDouble("A2"));
				centri.add(a);
					
			}
			
			conn.close();
			return centri ;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
		
	}

}
