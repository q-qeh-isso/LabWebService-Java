package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.GeradorDeNumerosAleatoriosStub;
import webservice.GeradorDeNumerosAleatoriosStub.Gerar;
import webservice.GeradorDeNumerosAleatoriosStub.GerarResponse;

/**
 * Servlet implementation class ChamaAleatorio
 */
public class ChamaAleatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChamaAleatorio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maximo = Integer.parseInt( request.getParameter("max") );
		int quantidade = Integer.parseInt( request.getParameter("quant") );
		PrintWriter out = response.getWriter();
		
		//chamada do webservice
		GeradorDeNumerosAleatoriosStub gerador = new GeradorDeNumerosAleatoriosStub();
		Gerar chamada = new GeradorDeNumerosAleatoriosStub.Gerar();
		chamada.setMaximo(maximo);
		chamada.setQuantidade(quantidade);
		
		GerarResponse resposta = gerador.gerar(chamada);
		
		int[] numeros = resposta.get_return();
		
		String resultado = "";
		
		out.println("<html><head><title>Numeros gerados</title></head>");
		out.println("<body>");
		out.println("<h2>Numeros gerados: </h2>");
		for(int i : numeros){
			out.println("<p>"+i+"</p>");
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
