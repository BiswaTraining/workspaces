package com.citiustech.HibernateAssignment5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(
		{
	@NamedQuery(
			name = "findAveragePriceOfAssetByLocation",  
			query ="SELECT AVG(a.assetPrice) from Asset a GROUP BY a.assetLocation"  

			)
		}
		)
@Entity
public class Asset {

	@Id
	@Column(name = "AssetId")
	private Integer assetId;
	
	@Column(name = "SerialNo")
	private Integer serialNo;

	@Column(name = "PrNo")
	private Integer prNo;

	@Column(name = "AssetType")
	private String assetType;

	@Column(name = "AssetPrice")
	private Integer assetPrice;

	@Column(name = "AssetLocation")
	private String assetLocation;

	public Asset(Integer assetId, Integer serialNo, Integer prNo, String assetType, Integer assetPrice,
			String assetLocation) {
		super();
		this.assetId = assetId;
		this.serialNo = serialNo;
		this.prNo = prNo;
		this.assetType = assetType;
		this.assetPrice = assetPrice;
		this.assetLocation = assetLocation;
	}

	public Asset() {
		super();
	}

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getPrNo() {
		return prNo;
	}

	public void setPrNo(Integer prNo) {
		this.prNo = prNo;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public Integer getAssetPrice() {
		return assetPrice;
	}

	public void setAssetPrice(Integer assetPrice) {
		this.assetPrice = assetPrice;
	}

	public String getAssetLocation() {
		return assetLocation;
	}

	public void setAssetLocation(String assetLocation) {
		this.assetLocation = assetLocation;
	}

	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", serialNo=" + serialNo + ", prNo=" + prNo + ", assetType=" + assetType
				+ ", assetPrice=" + assetPrice + ", assetLocation=" + assetLocation + "]";
	}
	
}
