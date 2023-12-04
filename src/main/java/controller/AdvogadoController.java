package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Advogado;
import model.AdvogadoDao;
import model.Cliente;

/**
 * Servlet implementation class AdvogadoController
 */
@WebServlet({"/AdvogadoController","/novoadvogado","/buscaadvogado", "/apagaadvogado", "/editaadvogado", "/salvaadvogado", "/pesquisaadvogado"})
public class AdvogadoController extends HttpServlet {
	Advogado adv = new Advogado();
	
	AdvogadoDao daoadv = new AdvogadoDao();
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvogadoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String acao = request.getServletPath();
		 if(acao.equals("/novoadvogado")) {
			EnviaDados(request,response);
		}else if(acao.equals("/buscaadvogado")) {
			BuscaDados(request,response);
		}
		else if(acao.equals("/apagaadvogado")) {
			ApagaDados(request,response);
		}
		else if(acao.equals("/editaadvogado")) {
			EditaDados(request,response);
		} else if (acao.equals("/salvaadvogado")) {
			SalvaDados(request, response);
		} else if (acao.equals("/pesquisaadvogado")) {
			PesquisaDados(request, response);
		}
	}
	
	
	protected void EnviaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  adv.setOab(request.getParameter("oab"));
	      adv.setNome(request.getParameter("nome"));
	      adv.setTelefone(request.getParameter("telefone"));
	     // adv.setTipocausas(request.getParameter("tipocausas"));
	      
	       daoadv.Salvar(adv);
	       request.setAttribute("success", "Advogado cadastrado com sucesso!");
	       request.getRequestDispatcher("buscaadvogado").forward(request,response);
	
	}
	
	
	protected void BuscaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Advogado> lista = daoadv.Listar();
		String success = (String) request.getAttribute("success");
			
			if (success!= null)
				request.setAttribute("success", success);
		System.out.println(lista);
		request.setAttribute("advogados", lista);
		RequestDispatcher rd = request.getRequestDispatcher("RelAdvogado.jsp");
		rd.forward(request, response);
	}
	
	protected void ApagaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (request.getParameter("id"));
		daoadv.Apagar(id);
		request.setAttribute("success", "Advogado apagado com sucesso!");
	    request.getRequestDispatcher("buscaadvogado").forward(request,response);
	}
	

	protected void EditaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (request.getParameter("id"));
		List<Advogado> advogado = daoadv.Editar(id);
		request.setAttribute("advogado", advogado);
		// System.out.println(((Advogado) advogado).getOab());
		RequestDispatcher rd = request.getRequestDispatcher("EditAdvogado.jsp");
		rd.forward(request, response);
		request.setAttribute("success", "Advogado editado com sucesso!");
	}
	
	/*
	String id = request.getParameter("id");
	List<Cliente> cliente = daocli.Editar(id);
	request.setAttribute("cliente", cliente);
	RequestDispatcher rd = request.getRequestDispatcher("EditCliente.jsp");
	rd.forward(request, response);
	*/
	protected void SalvaDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		adv.setIdadv(Integer.parseInt(request.getParameter("id")));
		adv.setNome(request.getParameter("nome"));
		adv.setTelefone(request.getParameter("telefone"));
		adv.setOab(request.getParameter("oab"));
		daoadv.Atualizar(adv);
		request.setAttribute("success", "Advogado atualizado com sucesso!");
		request.getRequestDispatcher("buscaadvogado").forward(request, response);

	}
	
	protected void PesquisaDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String q = request.getParameter("q");
	
		ArrayList<Advogado> lista = daoadv.Pesquisar(q);
		String success = (String) request.getAttribute("success");

		if (success != null)
		request.setAttribute("success", success);
		request.setAttribute("advogados", lista);
		request.setAttribute("q", q);
		RequestDispatcher rd = request.getRequestDispatcher("RelAdvogado.jsp");
		rd.forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
