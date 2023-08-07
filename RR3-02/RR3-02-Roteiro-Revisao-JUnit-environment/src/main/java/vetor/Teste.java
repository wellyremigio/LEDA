package vetor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Teste {
	
	private Vetor<Aluno> vetor;
	private Vetor<Aluno> vetorVazio;
	private Aluno aluno;
	private Aluno aluno2;

	@Before
	public void setUp() throws Exception {
		this.vetor =  new Vetor(2);
		this.vetorVazio = new Vetor(0);
		this.aluno = new Aluno("William", 8.6);
		this.aluno2 = new Aluno("Renata", 9.6);
		ComparadorMaximo compMax = new ComparadorMaximo();
		vetor.setComparadorMaximo(compMax);
		ComparadorMinimo compMin = new ComparadorMinimo();
		vetor.setComparadorMinimo(compMin);

	}

	@Test
	public void testInserirTC01() {
		assertTrue(vetor.inserir(aluno));
		assertFalse(vetor.inserir(null));
	}
	
	@Test
	public void testRemover() {
		vetor.inserir(aluno);
		assertEquals(aluno, vetor.remover(aluno));
	}

	@Test
	public void testProcurar() {
		vetor.inserir(aluno2);
		assertEquals(aluno2, vetor.procurar(aluno2));
		assertNull(vetor.procurar(aluno));
	}

	@Test
	public void testIsVazioTC01() {
		assertTrue(vetorVazio.isVazio());
	}
	
	@Test
	public void testIsVazioTC02() {
		vetor.inserir(aluno);
		assertFalse(vetor.isVazio());
	}
	

	@Test
	public void testIsCheioTC01() {
		vetor.inserir(aluno);
		vetor.inserir(aluno2);
		assertTrue(vetor.isCheio());
	}
	
	@Test
	public void testIsCheioTC02() {
		vetor.inserir(aluno);
		assertFalse(vetor.isCheio());
	}

	@Test
	public void testMaximoTC01() {
		vetor.inserir(aluno);
		vetor.inserir(aluno2);
		assertEquals(aluno2, vetor.maximo());
	}
	
	@Test
	public void testMaximoTC02() {
		vetor.inserir(aluno);
		vetor.inserir(aluno2);
		assertNotEquals(aluno, vetor.maximo());
	}

	@Test
	public void testMinimoTC01() {
		vetor.inserir(aluno);
		vetor.inserir(aluno2);
		assertEquals(aluno, vetor.minimo());
	}
	
	@Test
	public void testMinimoTC02() {
		vetor.inserir(aluno);
		vetor.inserir(aluno2);
		assertNotEquals(aluno2, vetor.minimo());
	}
}
