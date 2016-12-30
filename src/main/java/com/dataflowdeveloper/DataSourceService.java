package com.dataflowdeveloper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("DataSourceService")
public class DataSourceService {

	Logger logger = LoggerFactory.getLogger(DataSourceService.class);

	@Autowired
	public Connection connection;

	// default to empty
	public PhillyCrime defaultValue() {
		return new PhillyCrime();
	}

	// querylimit
	@Value("${querylimit}")
	private String querylimit;

	/**
	 * 
	 * @param query
	 *            - search msg
	 * @return List of Twitter2
	 */
	public List<PhillyCrime> search(String query) {

		List<PhillyCrime> crimes = new ArrayList<>();
		String sql = "";
		try {
			logger.error("Query: " + query);
			logger.error("Limit:" + querylimit);
			if ( connection == null ) { 
				logger.error("Null connection");
				return crimes;
			}
			if ( query == null || query.trim().length() <= 0 ) { 
				query = "";
				sql = "select * from phillycrime";
			}
			else {
				query = "%" + query.toUpperCase() + "%";
				sql = "select * from phillycrime WHERE upper(text_general_code) like ? LIMIT ?";
			}

			PreparedStatement ps = connection
					.prepareStatement(sql);
			if ( query.length() > 1 ) { 
				ps.setString(1, query);
				ps.setInt(2, Integer.parseInt(querylimit));
			}
			ResultSet res = ps.executeQuery();
			PhillyCrime crime = null;
			while (res.next()) {
				crime = new PhillyCrime();
				crime.setDcKey(res.getString("dc_key"));
				crime.setDcDist(res.getString("dc_dist"));
				crime.setDispatchDate(res.getString("dispatch_date"));
				crime.setDispatchDateTime(res.getString("dispatch_date_time"));
				crime.setDispatchTime(res.getString("dispatch_time"));
				crime.setHour(res.getString("hour"));
				crime.setLocationBlock(res.getString("location_block"));
				crime.setPsa(res.getString("psa"));
				crime.setTextGeneralCode(res.getString("text_general_code"));
				crime.setUcrGeneral(res.getString("ucr_general"));
				crimes.add(crime);
			}

			res.close();
			ps.close();
			connection.close();
			res = null;
			ps = null;
			connection = null;
			crime = null;

			logger.error("Size=" + crimes.size());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in search", e);
		}

		return crimes;
	}
}
