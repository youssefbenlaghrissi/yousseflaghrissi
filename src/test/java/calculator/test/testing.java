package calculator.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.entities.Calculator;

//CONVENTION D'utiliser nomClassTest
class testing {

	public static Instant instance ;
	public Calculator calculator ;
	
	@Test
	void assertTrue()
	{
		int a = 3 ;
		Assert.assertTrue(a>0 && a>1);
		assertThat(a).isEqualTo(3);
		assertThat("youssef").hasSizeBetween(4, 12).startsWith("you").endsWith("f");
		//assertThat("benlaghrissi").contains("ben") != null;
		assertThat("youssef").hasSize(7).startsWith("lagh").endsWith("ef");
	}
	
	@BeforeAll
	static void avantTout()
	{
		instance = Instant.now();
		System.out.println("demmarage de test");
	}
	
	@AfterAll
	static void apresTout()
	{
		System.out.println("apres tous les tests");
		Instant now = Instant.now();
		long duration = Duration.between(instance, now).toMillis();
		System.out.println("votre test durée de "+duration+" ms");
		
	}
	
	@BeforeEach
	void avantChaqueTest()
	{
		System.out.println("avant chaque test");
		calculator = new Calculator();
	}
	@AfterEach
	void apresChaqueTest() {
		System.out.println("apres chaque test");
		calculator = null ;
	}
	@Test
	// le nome de la methode doit indiquer ce qui doit faire ce test
	void sommeDeuxEntier() {
		//arrange arranger tartib
		int a = 3;
		int b = 2;
		Calculator calculator = new Calculator();
		//act action 
		int somme = calculator.add(a, b);
		// resultat attendu est 5
		//assert verification 
		assertEquals(5, somme); //(ce qui attendu , sortie )
		
	}
	@Test
	void produitDeuxEntier()
	{
		//arrange
		int c = 4 ;
		int d = 5 ; 
		Calculator calculator = new Calculator();
		// act
		int multiple = calculator.produit(c , d );
		//assert
		assertEquals(20, multiple);
	}

	@ParameterizedTest(name = " {0} * 0 doit etre egal à 0 ")
	@ValueSource(ints = { 1 , 3 ,  7 , 20 })
	void testerEntrants(int arg)
	{
		int out = calculator.produit(arg, 0);
		assertEquals(0, out);// c'st pour cela on dit que tous les resultats attendus doivent etre egaux
	}
	@ParameterizedTest(name = " {0} + {1} = {2} ")
	@CsvSource({"1 , 1 , 2 " , " 3 , 5  , 8 ", " 4 , 5 , 9" })
	void testerEntrants2( int arg1 , int arg2 , int resultat)
	{
		int out = calculator.add(arg1, arg2);
		assertEquals(resultat, out);
	}
}