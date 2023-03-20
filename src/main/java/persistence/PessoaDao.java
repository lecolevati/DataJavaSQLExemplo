package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class PessoaDao implements ICRUDDao<Pessoa> {
	
	private GenericDao gDao;

	public PessoaDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public String insert(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO pessoa VALUES (?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pessoa.getId());
		ps.setString(2, pessoa.getNome());
		ps.setDate(3, Date.valueOf(pessoa.getDataNascimento()));
		ps.execute();
		ps.close();
		c.close();
		return "Pessoa inserida com sucesso!";
	}

	@Override
	public String update(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		return null;
	}

	@Override
	public String delete(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		return null;
	}
	
	@Override
	public Pessoa select(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		return null;
	}

	@Override
	public List<Pessoa> list() throws SQLException, ClassNotFoundException {
		List<Pessoa> pessoas = new ArrayList<>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT id, nome, data_nascimento FROM pessoa";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
			
			pessoas.add(pessoa);
		}
		rs.close();
		ps.close();
		c.close();		
		return pessoas;
	}


}
