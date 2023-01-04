package kr.co.bit.pokemon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.pokemon.vo.PokemonVO;
import kr.co.bit.pokemon.vo.UserInfoVO;
import kr.co.bit.pokemon.vo.UserPokemonVO;
import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.jdbc.JDBCClose;

public class PokemonDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	// 사냥

	public UserInfoVO selectUserInfo() throws Exception {
		UserInfoVO user = null;

		conn = new ConnectionFactory().getConnection();

		String sql = "select id, offensive, defensive, life, money ";
		sql += "from user_info ";

		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			String id = rs.getString("id");
			int offensive = rs.getInt("offensive");
			int defensive = rs.getInt("defensive");
			int life = rs.getInt("life");
			int money = rs.getInt("money");
			user = new UserInfoVO(id, offensive, defensive, life, money);
		}
		JDBCClose.close(conn, pstmt);

		return user;
	}

	// public List<UserInfoVO> selectUserInfo() throws Exception {
	//
	// List<UserInfoVO> userList = new ArrayList<>();
	//
	// conn = new ConnectionFactory().getConnection();
	//
	// String sql = "select id, offensive, defensive, life, money ";
	// sql += " from user_info ";
	//
	// pstmt = conn.prepareStatement(sql);
	// ResultSet rs = pstmt.executeQuery();
	//
	// while (rs.next()) {
	// String id = rs.getString("id");
	// int offensive = rs.getInt("offensive");
	// int defensive = rs.getInt("defensive");
	// int life = rs.getInt("life");
	// int money = rs.getInt("money");
	// UserInfoVO user = new UserInfoVO(id, offensive, defensive, life, money);
	// userList.add(user);
	// }
	// JDBCClose.close(conn, pstmt);
	//
	// return userList;
	// }

	public int insertPokemon(UserPokemonVO p) {

		int num = 1;

		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("insert into user_pokemon(id, name) ");
			sql.append(" values(?, ?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, p.getId());
			pstmt.setString(2, p.getName());

			pstmt.executeUpdate();

		} catch (Exception e) {
			// System.out.println("이미 가지고 있는 포켓몬입니다.");
			num = 0;
			// System.exit(0);
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return num;
	}

	public List<PokemonVO> selectMonsterInfo() throws Exception {

		List<PokemonVO> monList = new ArrayList<>();

		conn = new ConnectionFactory().getConnection();

		String sql = "select name, offensive, defensive, price, rarity, life  ";
		sql += "  from pokemon_list ";
		sql += "  order by rarity desc";

		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			String name = rs.getString("name");
			int offensive = rs.getInt("offensive");
			int defensive = rs.getInt("defensive");
			int price = rs.getInt("price");
			int rarity = rs.getInt("rarity");
			int life = rs.getInt("life");
			PokemonVO monster = new PokemonVO(name, offensive, defensive, price, rarity, life);
			monList.add(monster);
		}
		JDBCClose.close(conn, pstmt);

		return monList;
	}

	// user 소유 포켓몬 정보 select
	public PokemonVO selectUserPokemonList(String _name) {
		PokemonVO pokemon = null;

		conn = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM pokemon_list ";
		sql += "WHERE name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _name);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int offensive = rs.getInt("offensive");
				int defensive = rs.getInt("defensive");
				int price = rs.getInt("price");
				int rarity = rs.getInt("rarity");
				int life = rs.getInt("life");

				pokemon = new PokemonVO(name, offensive, defensive, price, rarity, life);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pokemon;
	}

	// 마켓, 정보
	public void sellPokemon(UserPokemonVO p) {

		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE user_pokemon SET own = 0 ");
			sql.append(" where name = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, p.getName());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

	}

	public int own1Pokemon(UserPokemonVO p) {
		int num = 0;
		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE user_pokemon SET own =  1 ");
			sql.append(" where name = ? and own = 0 ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, p.getName());

			 num = pstmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return num;
	}

	public UserInfoVO money() {
		UserInfoVO result = null;

		StringBuffer sql = new StringBuffer();
		sql.append("select money ");
		sql.append(" from user_info");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new UserInfoVO();

				int no = rs.getInt("money");
				result.setMoney(no);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<PokemonVO> selectAllPokemonList() throws Exception {
		List<PokemonVO> list = new ArrayList<>();

		conn = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM pokemon_list order by price";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				int offensive = rs.getInt("offensive");
				int defensive = rs.getInt("defensive");
				int price = rs.getInt("price");
				int rarity = rs.getInt("rarity");
				int life = rs.getInt("life");

				PokemonVO board = new PokemonVO(name, offensive, defensive, price, rarity, life);

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<PokemonVO> selectUserPokemonList() throws Exception {
		List<PokemonVO> list = new ArrayList<>();

		conn = ConnectionFactory.getConnection();

		String sql = "SELECT p.* FROM pokemon_list p, user_pokemon u ";
		sql += "WHERE p.name = u.name AND u.id = '량' AND u.own = 1 order by price";
		try {
			pstmt = conn.prepareStatement(sql);
			// pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int offensive = rs.getInt("offensive");
				int defensive = rs.getInt("defensive");
				int price = rs.getInt("price");
				int rarity = rs.getInt("rarity");
				int life = rs.getInt("life");

				PokemonVO board = new PokemonVO(name, offensive, defensive, price, rarity, life);

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<PokemonVO> selectPokemonBookList() throws Exception {
		List<PokemonVO> list = new ArrayList<>();

		conn = ConnectionFactory.getConnection();

		String sql = "SELECT p.* FROM pokemon_list p, user_pokemon u ";
		sql += "WHERE p.name = u.name AND u.id = '량' order by price";
		try {
			pstmt = conn.prepareStatement(sql);
			// pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int offensive = rs.getInt("offensive");
				int defensive = rs.getInt("defensive");
				int price = rs.getInt("price");
				int rarity = rs.getInt("rarity");
				int life = rs.getInt("life");

				PokemonVO board = new PokemonVO(name, offensive, defensive, price, rarity, life);

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void UpdateMoney(int money) {

		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("update user_info ");
			sql.append(" set money = money - ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, money);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

	public PokemonVO pmoney(String name) throws Exception {
		PokemonVO result = null;

		conn = ConnectionFactory.getConnection();

		String sql = "SELECT price FROM pokemon_list";
		sql += " where name = ?";
		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new PokemonVO();

				int no = rs.getInt("price");
				result.setPrice(no);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
