package org.eclipse.wtp.tutorial;

import java.io.File;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VipEventPojo {

	private long vipEventId, eventStartTime, eventEndTime;
	private String catalogProviderEventId="", ebayUserId="", rppcurationId="",
			rppEventId="", rppEventGroupId="", catalogProviderEventGroupId="",
			eventTitle="", properties="", city="", state="", country="", postalcode="", status="";
	private String creationDate, lastModifiedDate;
	
	public long getVipEventId() {
		return vipEventId;
	}
	public void setVipEventId(long vipEventId) {
		this.vipEventId = vipEventId;
	}
	public long getEventStartTime() {
		return eventStartTime;
	}
	public void setEventStartTime(long eventStartTime) {
		this.eventStartTime = eventStartTime;
	}
	public long getEventEndTime() {
		return eventEndTime;
	}
	public void setEventEndTime(long eventEndTime) {
		this.eventEndTime = eventEndTime;
	}
	public String getCatalogProviderEventId() {
		return catalogProviderEventId;
	}
	public void setCatalogProviderEventId(String catalogProviderEventId) {
		this.catalogProviderEventId = StringUtilsVIP.nullSafeGet(catalogProviderEventId);
	}
	public String getEbayUserId() {
		return ebayUserId;
	}
	public void setEbayUserId(String ebayUserId) {
		this.ebayUserId = StringUtilsVIP.nullSafeGet(ebayUserId);
	}
	public String getRppcurationId() {
		return rppcurationId;
	}
	public void setRppcurationId(String rppcurationId) {
		this.rppcurationId = StringUtilsVIP.nullSafeGet(rppcurationId);
	}
	public String getRppEventId() {
		return rppEventId;
	}
	public void setRppEventId(String rppEventId) {
		this.rppEventId = StringUtilsVIP.nullSafeGet(rppEventId);
	}
	public String getRppEventGroupId() {
		return rppEventGroupId;
	}
	public void setRppEventGroupId(String rppEventGroupId) {
		this.rppEventGroupId = StringUtilsVIP.nullSafeGet(rppEventGroupId);
	}
	public String getCatalogProviderEventGroupId() {
		return catalogProviderEventGroupId;
	}
	public void setCatalogProviderEventGroupId(String catalogProviderEventGroupId) {
		this.catalogProviderEventGroupId = StringUtilsVIP.nullSafeGet(catalogProviderEventGroupId);
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = StringUtilsVIP.nullSafeGet(eventTitle);
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = StringUtilsVIP.nullSafeGet(properties);
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = StringUtilsVIP.nullSafeGet(city);
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = StringUtilsVIP.nullSafeGet(state);
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = StringUtilsVIP.nullSafeGet(country);
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = StringUtilsVIP.nullSafeGet(postalcode);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = StringUtilsVIP.nullSafeGet(status);
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = StringUtilsVIP.nullSafeGet(creationDate);
	}
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = StringUtilsVIP.nullSafeGet(lastModifiedDate);
	}
	
	public static String getCatalogProviderNameFromFile(String fileName) {
		String catalogProviderName = "InvalidCatalogProvider";
		if (fileName != null && fileName.indexOf("_") != -1) {
			int endIndex = fileName.indexOf("_");
			catalogProviderName = fileName.substring(0, endIndex);
		}
		
		return catalogProviderName;
	}
	
	public static void main(String[] args) {
		String req="c:\\tempdf\\partscenter\\lms\\request\\invaluable_sachin_tilloo_AddItem_08262014-141956761_1.xml";
		File f = new File(req);
		System.out.println(getCatalogProviderNameFromFile(f.getName()));
	}
}
