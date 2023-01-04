package kr.co.bit.pokemon.service;

import java.util.List;

import kr.co.bit.pokemon.dao.PokemonDAO;
import kr.co.bit.pokemon.vo.PokemonVO;
import kr.co.bit.pokemon.vo.UserInfoVO;
import kr.co.bit.pokemon.vo.UserPokemonVO;

public class PokemonService {
	
	private PokemonDAO dao;
	
	public PokemonService() {
		dao = new PokemonDAO();
	}
	
//	public List<UserInfoVO> selectUserInfo() throws Exception {
//
//		List<UserInfoVO> list = dao.selectUserInfo();
//		return list;
//	}
	
	public UserInfoVO selectUserInfo() throws Exception {
		return dao.selectUserInfo();
	}
	
	public List<PokemonVO> selectMonsterInfo() throws Exception {

		List<PokemonVO> list = dao.selectMonsterInfo();
		return list;
	}
	
	public int insertPokemon(UserPokemonVO userPokemon) {

		return dao.insertPokemon(userPokemon);
	}
	
	public PokemonVO selectUserPokemonList(String name)	{
		return dao.selectUserPokemonList(name);
	}
	
	public void sellPokemon(UserPokemonVO p) {

		dao.sellPokemon(p);
	}
	
	public int own1Pokemon(UserPokemonVO p) {

		 return dao.own1Pokemon(p);
	}
	
	public List<PokemonVO> selectAllPokemonList() throws Exception {

		List<PokemonVO> list = dao.selectAllPokemonList();
		return list;
	} 
	
	public List<PokemonVO> selectUserPokemonList() throws Exception {

		List<PokemonVO> list = dao.selectUserPokemonList();
		return list;
	} 
	
	public UserInfoVO money(){
		return dao.money();
	}
	public PokemonVO pmoney(String name) throws Exception {
		return dao.pmoney(name);
	}
	
	public void UpdateMoney(int money){
		dao.UpdateMoney(money);
	}

	public List<PokemonVO> selectPokemonBookList() throws Exception {
		return dao.selectPokemonBookList();
	}
	
}
