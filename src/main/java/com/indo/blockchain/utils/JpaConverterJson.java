package com.indo.blockchain.utils;

import java.io.IOException;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.indo.blockchain.json.WalletJson;

public class JpaConverterJson implements AttributeConverter<WalletJson, String>{
	
	private final static ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(WalletJson walletJson) {
		String value = null;
		try {
			value = objectMapper.writeValueAsString(walletJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public WalletJson convertToEntityAttribute(String entity) {
		WalletJson json = null;
	    try {
			json = objectMapper.readValue(entity, WalletJson.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return json;
	}
}
