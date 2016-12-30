package com.dataflowdeveloper;

import java.io.Serializable;

/**
 * CREATE TABLE phillycrime (dc_dist varchar,
dc_key varchar not null primary key,dispatch_date varchar,dispatch_date_time varchar,dispatch_time varchar,hour varchar,
location_block varchar,psa varchar,
text_general_code varchar,ucr_general varchar);
 * @author tspann
 *
 */ 
public class PhillyCrime implements Serializable {

	private static final long serialVersionUID = -2549969191580450272L;

	private String dcDist;
	private String dcKey;
	private String dispatchDate;
	private String dispatchDateTime;
	private String dispatchTime;
	private String hour;
	private String locationBlock;
	private String psa;
	private String textGeneralCode;
	private String ucrGeneral;
	
	
	/**
	 * @param dcDist
	 * @param dcKey
	 * @param dispatchDate
	 * @param dispatchDateTime
	 * @param dispatchTime
	 * @param hour
	 * @param locationBlock
	 * @param psa
	 * @param textGeneralCode
	 * @param ucrGeneral
	 */
	public PhillyCrime(String dcDist, String dcKey, String dispatchDate, String dispatchDateTime, String dispatchTime,
			String hour, String locationBlock, String psa, String textGeneralCode, String ucrGeneral) {
		super();
		this.dcDist = dcDist;
		this.dcKey = dcKey;
		this.dispatchDate = dispatchDate;
		this.dispatchDateTime = dispatchDateTime;
		this.dispatchTime = dispatchTime;
		this.hour = hour;
		this.locationBlock = locationBlock;
		this.psa = psa;
		this.textGeneralCode = textGeneralCode;
		this.ucrGeneral = ucrGeneral;
	}
	public String getDcDist() {
		return dcDist;
	}
	public void setDcDist(String dcDist) {
		this.dcDist = dcDist;
	}
	public String getDcKey() {
		return dcKey;
	}
	public void setDcKey(String dcKey) {
		this.dcKey = dcKey;
	}
	public String getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public String getDispatchDateTime() {
		return dispatchDateTime;
	}
	public void setDispatchDateTime(String dispatchDateTime) {
		this.dispatchDateTime = dispatchDateTime;
	}
	public String getDispatchTime() {
		return dispatchTime;
	}
	public void setDispatchTime(String dispatchTime) {
		this.dispatchTime = dispatchTime;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getLocationBlock() {
		return locationBlock;
	}
	public void setLocationBlock(String locationBlock) {
		this.locationBlock = locationBlock;
	}
	public String getPsa() {
		return psa;
	}
	public void setPsa(String psa) {
		this.psa = psa;
	}
	public String getTextGeneralCode() {
		return textGeneralCode;
	}
	public void setTextGeneralCode(String textGeneralCode) {
		this.textGeneralCode = textGeneralCode;
	}
	public String getUcrGeneral() {
		return ucrGeneral;
	}
	public void setUcrGeneral(String ucrGeneral) {
		this.ucrGeneral = ucrGeneral;
	}
	/**
	 * @param dcKey
	 * @param dispatchDate
	 * @param dispatchDateTime
	 * @param dispatchTime
	 * @param hour
	 * @param locationBlock
	 * @param psa
	 * @param textGeneralCode
	 * @param ucrGeneral
	 */
	public PhillyCrime(String dcKey, String dispatchDate, String dispatchDateTime, String dispatchTime, String hour,
			String locationBlock, String psa, String textGeneralCode, String ucrGeneral) {
		super();
		this.dcKey = dcKey;
		this.dispatchDate = dispatchDate;
		this.dispatchDateTime = dispatchDateTime;
		this.dispatchTime = dispatchTime;
		this.hour = hour;
		this.locationBlock = locationBlock;
		this.psa = psa;
		this.textGeneralCode = textGeneralCode;
		this.ucrGeneral = ucrGeneral;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PhillyCrime [dcDist=");
		builder.append(dcDist);
		builder.append(", dcKey=");
		builder.append(dcKey);
		builder.append(", dispatchDate=");
		builder.append(dispatchDate);
		builder.append(", dispatchDateTime=");
		builder.append(dispatchDateTime);
		builder.append(", dispatchTime=");
		builder.append(dispatchTime);
		builder.append(", hour=");
		builder.append(hour);
		builder.append(", locationBlock=");
		builder.append(locationBlock);
		builder.append(", psa=");
		builder.append(psa);
		builder.append(", textGeneralCode=");
		builder.append(textGeneralCode);
		builder.append(", ucrGeneral=");
		builder.append(ucrGeneral);
		builder.append("]");
		return builder.toString();
	}
	/**
	 * 
	 */
	public PhillyCrime() {
		super();
	}	
}