package com.indo.blockchain.json;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CryptoInfoJson {

		@JsonProperty("id")
		private String id;
		
		@JsonProperty("name")
		private String name;
		
		@JsonProperty("symbol")
		private String symbol;
		
		@JsonProperty("rank")
		private String rank;
		
		@JsonProperty("price_usd")
		private String priceUsd;
		
		@JsonProperty("price_btc")
		private String priceBtc;
		
		@JsonProperty("24h_volume_usd")
		private String dailyVolumUsd;
		
		@JsonProperty("market_cap_usd")
	    private String marketCapUsd;
		
		@JsonProperty("available_supply")
	    private String availableSupply;
		
		@JsonProperty("total_supply")
	    private String totalSupply;
		
		@JsonProperty("max_supply")
	    private String maxSuppply;
		
		@JsonProperty("percent_change_1h")
	    private String percentChangeHour;
		
		@JsonProperty("percent_change_24h")
	    private String percentChangeDay;
		
		@JsonProperty("percent_change_7d")
	    private String percentChangeWeek;
		
		@JsonProperty("last_updated")
	    private String lastUpdated;
		
		@JsonProperty("price_eur")
	    private String priceEur;
		
		@JsonProperty("24h_volume_eur")
	    private String dailyVolumEur;
		
		@JsonProperty("market_cap_eur")
	    private String marketCapEur;
			   
}

