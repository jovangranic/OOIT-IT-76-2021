package geometry;

public interface Moveable {

	/* 
	- po default-u, sve NESTATICKE metode u interfejsu su public i abstract, pa se "public abstract" moze izostaviti (primer void MoveBy)
	- mogu postojati promenljive, ali moraju biti oznacene kao STATIC FINAL
	- mogu postojati staticke metode, ali moraju imati implementaciju
	- mogu postojati neapstraktne metode ali moraju biti oznacene kao DEFAULT
	- interfejs moze da prosiruje druge interfejse 
	*/
	
	/*
	public static final String attribute = "constant value";
	public default void defaultMethod() {
	}
	public static void staticMethod() {
	}*/
	
	/*NAPOMENA:
	- metode moveOn i moveBy su mogle biti deklarisane i u klasi Shape; definisanjem posebnog interfejsa
	omogucili smo visestruko koriscenje ovog interfejsa u nekoj drugoj klasi/aplikaciji, odnosno
	postigli VISOKU KOHEZIJU
	- VISOKA KOHEZIJA se postize kada komponente softverskog sistema imaju usku oblast odgovornosti
	- direktna posledica visoke kohezije je LABAVO SPREZANJE, tj. fleksibilnost koda 
	*/

	public abstract void moveTo(int x, int y);
	void moveBy(int x, int y);
}
