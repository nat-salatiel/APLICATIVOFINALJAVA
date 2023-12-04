package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import util.Conexao;

public class AdvogadoDao {
	Connection con;
	ResultSet rs;
	
	
	public void Salvar(Advogado adv) {
		 try {
	    	 con = new Conexao().conectar();
	    	 
	    	 String sql = "insert into Advogado(oab,nome,telefone)values(?,?,?)";
	    	 
	    	 PreparedStatement stmt = con.prepareStatement(sql);
	    	 stmt.setString(1, adv.getOab());
	    	 stmt.setString(2,adv.getNome());
	    	 stmt.setString(3,adv.getTelefone());
	    	 stmt.executeUpdate();
	    	 
	    	 stmt.close();
    	 
    	 } catch(Exception erro) {
    		 
    	 }
	}

    public ArrayList<Advogado>Listar(){
   	 try {
   		 con = new Conexao().conectar();
   		 ArrayList<Advogado> advogado = new ArrayList<>();
   		 String sql = "select * from advogado  WHERE statusadv = 'on'";
   		 PreparedStatement stmt = con.prepareStatement(sql);
   		 rs = stmt.executeQuery();
   		 
   		 while(rs.next()){
   			 String oab = rs.getString("oab");
   			 int idadv = rs.getInt("idadv");
   			 String nome = rs.getString("nome");
   			 Date data = rs.getDate("dataadv");
   			 String telefone = rs.getString("telefone");
   			 String status= rs.getString("statusadv");
   			 advogado.add(new Advogado(oab, idadv, nome, data, telefone, status));
   		 }
   		 
   		 return advogado;
   		 
   	 } catch(Exception erro) {
   		 System.out.println(erro);
   		 return (null);
   	 }
    }
		
    public void Apagar(String id) {
		 try {
			 con = new Conexao().conectar();
			 String sql = "update advogado set statusadv = 'off' where idadv =?";
			 PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
			 stmt.executeUpdate();
            stmt.close();
            con.close();
            
		 } catch(Exception erro) {
			 erro.printStackTrace();
		 }
	 }
    
    public List<Advogado> Editar(String id) {

		List<Advogado> advogado = new ArrayList<>();

		try {
			con = new Conexao().conectar();
			String sql = "SELECT * FROM advogado WHERE idadv = ? AND statusadv = 'on'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int idadv = rs.getInt("idadv");
			Date data = rs.getDate("dataadv");
			String nome = rs.getString("nome");
			String telefone = rs.getString("telefone");
			String oab = rs.getString("oab");
			System.out.println("OAB: " + oab);
			advogado.add(new Advogado( idadv,  nome,  data,  telefone,  oab));
			return advogado;

		} catch (Exception erro) {
			erro.printStackTrace();
			return null;
		}

	}
    
    public void Atualizar(Advogado adv) {
   	 try {
	    	 con = new Conexao().conectar();
	    	 
	    	 String sql = "update advogado set nome = ?, telefone = ?, oab = ?  where idadv = ?";
	    	 
	    	 PreparedStatement stmt = con.prepareStatement(sql);	    	 
	    	 stmt.setString(1,adv.getNome());
	    	 stmt.setString(2,adv.getTelefone());
	    	 stmt.setString(3,adv.getOab());
	    	 stmt.setInt(4,adv.getIdadv());
	    	 stmt.executeUpdate();
	    	 
	    	 stmt.close();
	    	 con.close();
   	 
   	 } catch(Exception erro) {
   		 
   	 }
   	 
    }
    
	
    public ArrayList<Advogado> Pesquisar(String q) {
 		try {
 			con = new Conexao().conectar();
 			ArrayList<Advogado> advogado = new ArrayList<>();
 			String sql = "select * from advogado WHERE statusadv = 'on' AND (nome LIKE CONCAT('%', ?, '%') OR telefone LIKE CONCAT('%', ?, '%') OR oab LIKE CONCAT('%', ?, '%'));";

 			System.out.println("Query: " + q);
 			
 			PreparedStatement stmt = con.prepareStatement(sql);
 			stmt.setString(1, q);
 			stmt.setString(2, q);
 			stmt.setString(3, q);
 			rs = stmt.executeQuery();

 			while (rs.next()) {
 			    String oab = rs.getString("oab");
 				int idadv = rs.getInt("idadv");
 				Date data = rs.getDate("dataadv");
 				String nome = rs.getString("nome");
 				String telefone = rs.getString("telefone");
 				String status = rs.getString("statusadv");
 				advogado.add(new Advogado(oab, idadv, nome, data, telefone, status));
 			}
 			return advogado;

 		} catch (Exception erro) {
 			System.out.println(erro);
 			return null;
 		}

 	}
}


