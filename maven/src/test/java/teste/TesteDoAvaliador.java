package br.com.caelum.leilao.teste;

import br.com.caelum.leilao.dominio.Leilao;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import junit.framework.Assert;

public class TesteDoAvaliador {
@Test
public  void deveEntenderLancesEmOrdemCrescente() {

	Usuario joao = new Usuario("João");
	Usuario jose = new Usuario("José");
	Usuario maria = new Usuario("Maria");
	
	Leilao leilao = new Leilao("Iphone X");
	leilao.propoe(new Lance(joao,250.0));
	leilao.propoe(new Lance(jose,300.0));
	leilao.propoe(new Lance(maria,400.0));
	
	Avaliador leiloeiro = new Avaliador();
	leiloeiro.avalia(leilao);
	double maiorEsperado = 400;
	double menorEsperado = 250;
	
	System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
	Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(),0.0001);
	System.out.println(menorEsperado == leiloeiro.getMenorLance());
	Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(),0.0001);
}
}
