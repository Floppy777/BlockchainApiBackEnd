package com.indo.blockchain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indo.blockchain.model.GameType;
import com.indo.blockchain.repository.IGameTypeDao;

@Service
public class GameTypeService {
	
	@Autowired private IGameTypeDao gameTypeDao;

	public List<GameType> getAllGameType(){
		return gameTypeDao.findAll();
	}

	
}
