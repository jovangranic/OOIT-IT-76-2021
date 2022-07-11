package geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Test {

	//main metoda - ulazna tacka programa
	public static void main(String[] args) {
		// promenljiva(varijabla) - imenovana memorijska lokacija koja omogucava skladistenje odredjenog podatka
		int i; //deklaracija promenljive, definisanje tipa podatka
		i = 0; //inicijalizacija promenljive, dodavanje vrednosti 
		
		// implicitna konverzija je moguca sa kompatibilnim tipovima podataka
		// kada se vrednost manjeg tipa podatka smesta u promenljivu veceg tipa podatka
		//jer u ovom slucaju ne dolazi do gubitka informacija
		int a = 6;
		double b = a;
		System.out.println(b);
		
		//eksplicitna konverzija
		int c = (int)b;
		System.out.println(c);
		
		//logicki operatori
		boolean firstBool = true;
		boolean secondBool = false;
		//&& || ! ^
		System.out.println(firstBool ^ secondBool);
		
		//konkatenacija stringova
		String string1 = "ime ";
		String string2 = "prezime";
		System.out.println(string1+string2);
				
 		//3. zadatak 
		/*for(i=1; i<10; i++) {
			if(i % 2 == 1) {
				System.out.println(i);
			}
		}*/
		
		//Vezbe 2:
		
		//objekat je instanca klase i ima sve osnobine i ponasanja koja su definisana u klasi
		//modeluje objekat (entitet) realnog sistema
		//predstavlja pojavu klase cijim je konstruktorom kreiran 
		//objekat se instancira pozivom konstruktora klase (oprator new + poziv konstruktora)
		Point point = new Point(); 
		//promenljiva point ukazuje na kreiran objekat, odnosno predstavlja referencu na objekat klase Point
		//kada metodi za ispis prosledimo referencu dobijamo ispis:
		//<nazivPaketa>.<nazivKlase>@<hexAdresa>
		System.out.println(point); 
		
		//direktan pristup atributu x promenljive point koja je tipa Point nije moguc jer atribut 
		//x ove klase Point ima private specifikator pristupa
		//System.out.println(point.x);
		
		//nakon instanciranja objekta, atributi primarnih tipova podataka kojima nije eksplicitno dodeljena vrednost
		//implicitno dobijaju podrazumevane vrednosti za odgovarajuci tip podatka
		System.out.println(point.getX()); //podrazumevana vrednost za int je 0
		System.out.println(point.isSelected()); //za boolean je false
		
		//get i set metode omogucavaju pristup privatnim atributima klase
		point.setX(10);
		System.out.println(point.getX());
		Point point2 = new Point(10,10); 
		System.out.println(point2.getY());
		
		Point point3 = new Point(50,50);
		//u metodi distance klase Point this.x se odnosi
		//na atribut x objekta this - objekta p1 nad kojim je pozvana metoda
		double distance = point3.distance(100, 100);
		System.out.println(distance);
		
		//Vezbe 3:
		Line line = new Line();
		//atributi koji su slozenog tipa podatka se moraju eksplicitno inicijalizovati
		//u suprotnom imaju null vrednost
		System.out.println(line.getEndPoint());//null
		
		// 1. Inicijalizovati x koordinatu tacke p
		// na vrednost y koordinate tacke p1
		Point p = new Point(10,10);
		Point p1 = new Point(20,20);
		p.setX(p1.getY());
		System.out.println(p.getX());//20
		
		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a
		// za krajnju tacku linije l1 tacku p1
		Line l1 = new Line();
		l1.setStartPoint(p);
		l1.setEndPoint(p1);
		
		// 3. Postaviti y koordinatu krajnje tacke l1 na 23
		Point endPoint = l1.getEndPoint();
		endPoint.setX(23);
		//l1.getEndPoint().setX(23);
		
		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		
		//Uraditi:
		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y
		// koordinate pocetne tacke linije l1
		l1.getEndPoint().setX((int)l1.length() - (l1.getStartPoint().getX() + l1.getStartPoint().getY()));

		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15
		Rectangle r1 = new Rectangle(new Point(20,20),10,10);
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		
		// 7. Postaviti centar kruga c1 na koordinate tacke
		// gore levo od r1
		Circle c1 = new Circle(new Point(30,30),10);
		c1.setCenter(r1.getUpperLeftPoint());

		// 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
		// povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1
		c1.getCenter().setX((int)r1.area() - l1.getStartPoint().getY());

		//Vezbe 4
		Point p_1 = new Point(10, 30);
		Point p_2 = new Point(10, 30);
		Point p_3 = p_1;
		
		//== poredi reference 
		if(p_1 == p_2) {
			System.out.println("p_1 i p_2 referenciraju isti objekat");
		}else {
			System.out.println("p_1 i p_2 ne referenciraju isti objekat");
		}
		if(p_1 == p_3) {
			System.out.println("p_1 i p_3 referenciraju isti objekat");
		}else {
			System.out.println("p_1 i p_3 ne referenciraju isti objekat");
		}
		
		//equals metoda je definisana u Object klasi tako da poredi reference
		//da bismo imali logiku uporedjivanja vrednosti koordinata tacaka, moramo da redefinisemo metodu u klasi Point
		//kada se equals metoda pozove, implementacija metode se najpre trazi u Point klasi, zatim u Object ukoliko ne postoji u Point klasi
		if(p_1.equals(p_2)) {
			System.out.println("p_1 i p_2 su isti");
		}else {
			System.out.println("p_1 i p_2 nisu isti");
		}
		if(p_1.equals(p_3)) {
			System.out.println("p_1 i p_3 su isti");
		}else {
			System.out.println("p_1 i p_3 nisu isti");
		}
		
		//instanceof operator proverava da li je objekat instanca odredjenog tipa
		//klasa Object iz java.lang paketa je roditeljska (natklasa) svih klasa 
		if(p_1 instanceof Point) { //true
			System.out.println("p_1 je instanca klase Point");
		}
		if(p_1 instanceof Object){ //true
			System.out.println("p_1 je instanca klase Object");
		}
		
		int k = 5;
		int j = 5;
		System.out.println(j == k); //true
		
		//String je klasa
		String e = "abc"; //kreira se objekat
		String f = "abc"; //referencira se postojeci objekat
		System.out.println(e == f);//true

		String s1 = new String("Hello World");
		String s2 = new String("Hello World"); // kreira se novi objekat 
		System.out.println(s1 == s2); //false -> poredjenje referenci
		System.out.println(s1.equals(s2)); // true -> poredjenje po vrednosti jer je equals metoda redefinisana u klasi String
		
		//kljucna rec static - vrsi povezivanje na nivou klase
		//staticki atributi ili metode mogu se direktno pozvati nad klasom, tj. nije potrebno instancirati objekat klase
		Point.staticMethod();
		
		//Vezbe 5
		Donut donut = new Donut(new Point(10,10), 5, 10);
		Donut dounut2 = new Donut(new Point(10,10), 3, 10);
		/*prilikom izvrsavanja programa, trazenje implementacije equals metode otpocinje u klasi kojom je objekat 
		inicijalizovan - u Donut klasi, zatim ukoliko u Donut klasi ne postoji implementirana metoda, 
		trazenje implementacije se nastavlja hijerarhijski u nadklasama,
		prvo u Circle klasi i na kraju Object klasi ako metoda nije implementirana ni u Circle klasi*/
		System.out.println(donut.equals(dounut2));
		
		System.out.println(donut instanceof Object); //true
		System.out.println(donut instanceof Circle); //true
		System.out.println(donut instanceof Donut); //true
		
		//Vezbe 6
		/* POLIMORFIZAM 
		 - opsta karakteristika polimorfizma je da se ista promenljiva, objekat ili metoda 
		 ponasa razlicito u zavisnosti od uslova u kojima se referencira  
		 - u kontekstu o-o prog. predstavlja koncept koji omogucava da se ista operacija
		 (ponasanje/metoda) realizuje na drugaciji nacin (poly-vise, morf-oblika)
		 1. primer -> sposobnost objekata koji pripadaju razlicitim potklasama iste klase objekata da
		 da realizuju ista svojstva i operacije na razlicite nacine
		 2. primer -> sposobnost da se jedna promenljiva moze koristiti kao referenca na objekte razlicitog
		 tipa, sto ce uticati na izbor implementacije metode koja se poziva
		 */		
		
		/*DINAMICKO (KASNO) POVEZIVANJE 
		- odnosi se na povezivanje naziva metode sa implementacijom (desava se tek prilikom izvrsenja programa)
		- omogucava da se u vreme pisanja programa neka promenljiva deklarise jednim tipom
		dok se inicijalizacija vrsi pozivom konstruktora nekog drugog tipa (neke klase koja je izvedena):
		*/
		Circle donut_impl = new Donut(new Point(10,10),10,15);
		donut_impl.toString();
		/*
		 - kompajler posmatra kojim tipom je promenljiva deklarisana (Circle) i dozvoljava poziv metoda koje postoje u toj klasi
		 (iz primera - u klasi Circle postoji metoda toString)
		 - interpreter prilikom izvrsenja programa posmatra kako je promenljiva inicijalizovana i izvrsice se 
		 implementacija metode one klase kojom je promenljiva inicijalizovana 
		 (iz primera - toString metoda klase Donut)
		 */
		
		/*APSTRAKTNA KLASA 
		 - pred interfejsa, predstavlja kocept za postizanje apstrakcije (proces skrivanja detalja implementacije)
		 - u apstraktnu klasu treba izdvojiti sve atribute i metode koje su zajednicke za sve klase koje nasleduju tu klasu
		 - nije moguce instancirati objekat apstraktne klase, cak i ako postoje definisani konstruktori
		 - moze posedovati konstruktore, koji konstruisu delove objekata njenih potklasa
		 - promenljiva moze biti deklarisana tipom apstraktne klase
		 - moze sadrzati apstraktne i neapstraktne metode
		 - ako poseduje abstract metodu, mora biti deklarisana kao apstraktna
		  - klase koje nasledjuju apstraktnu klasu moraju napisati implementaciju za sve metode koje su apstraktne 
		  (ako ih ne implementiraju, moraju biti definisane kao apstraktne)
		 */
		
		//Shape shape = new Shape();
		Shape lin = new Line(new Point(10,10), new Point(20,20));
		
		//Vezbe 7
		/*INTERFEJS
		 - mehanizam za postizanje potpune apstrakcije i visestrukog nasledjivanja
		 - ugovor o ponasanju objekata klase koja ga implementira (kako komunicirati sa objektom) 
		 - nemaju konstruktore i ne mogu se instancirati, ali se mogu deklarisati
		 promenljive tipa interfejsa
		*/
		
		/*deklaracija promenljive tipom interfejsa (za instanciranje se koristi konstruktor
		klase koja implementira interfejs):*/
		Moveable moveLin = new Line();
		
		/*KOLEKCIJE 
		- skladistenje vise podataka istog tipa u memoriji
		- mogu biti:
		STATICKE -> njihova velicina je fiksna i unapred poznata
		DINAMICKE -> dinamicki se alocira memorija, promenljiva velicina kolekcije
		*/
		
		/*NIZOVI
		- staticke kolekcije -> prilikom inicijalizacije potrebno je definisati duzinu niza
		i jednom definisana duzina se ne moze promeniti
		*/
		Point[] points = new Point[4];
		points[0] = new Point(100,100);
		points[1] = new Point(30,30);
		points[2] = new Point(70,70);
		points[3] = new Point(0,0);
		
		System.out.println("Ispis nesortiranog niza:");
		for(int ind=0; ind<points.length; ind++) {
			System.out.println(points[ind]);
		}
		
		/*SORTIRANJE KOLEKCIJE
		- Arrays klasa je Java klasa util paketa i poseduje STATICKU metodu sort koja sortira kolekciju
		- u kolekciji koja se sortira MORAJU da se nalaze podaci tipa koji MORA da implementira
		java Comparable interfejs, odnosno compareTo metodu
		- poziv sort metode u pozadini poziva compareTo metodu
		*/
		
		Arrays.sort(points);
		System.out.println("Ispis sortiranog niza:");
		for(int ind=0; ind<points.length; ind++) {
			System.out.println(points[ind]);
		}
		
		/*REFERENTI TIPOVI I RAD SA REFERENCAMA
		- point_p i centar kruga circle_c su dve reference koje ukazuju na isti objekat u memoriji
		- promena vrednosti objekta na koji ukazuje referenca point_p menja vrednosti objekta
		na koji ukazuje circle_c (vazi i obrnuto), jer je u pitanju isti objekat 
		*/
		Point point_p = new Point(10,10);
		Circle circle_c = new Circle(point_p, 10);
		System.out.println(circle_c); //center = (10,10), radius = 10
		point_p.moveTo(20, 20);
		System.out.println(circle_c); //center = (20,20), radius = 10
		circle_c.moveBy(10, 10);
		System.out.println(circle_c); //center = (30,30), radius = 10
		System.out.println(point_p); //(30,30)
		
		//Vezbe 9
		//LISTE - DINAMICKE KOLEKCIJE
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Point(10,10));
		shapes.add(new Line(new Point(20,30), new Point(20,30)));
		
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//HASH MAPE
		//Dinamicka kolekcija koja omogucava cuvanje uredjenih key-value parova
		HashMap<String, Shape> hmShapes = new HashMap<String, Shape>();
		hmShapes.put("point", p);
		hmShapes.put("line", l1);
		System.out.println(hmShapes.get("line"));

		/*IZUZECI
		IZUZETAK - mehanizam za upravljanje nepredvidjenim situacijama u vreme izvrsavanja
		programa 
		*/
		//Bez obrade izuzetaka:
		Shape[] shapesArray = new Shape[2];
		/*System.out.println(shapesArray[2]);
		System.out.println("Ispis nakon izuzetka");*/
			
		/*Obrada izuzetaka:
		TRY - kod koji potencijalno moze dovesti do izuzetka
		CATCH - "hvatanje" i obrada izuzetka ukoliko dodje do njega
		FINALLY - blok koda koji se uvek izvrsava
		*/
		try {
			Integer.parseInt("pet");
			System.out.println(shapesArray[2]);
		}catch(ArrayIndexOutOfBoundsException exc){
			//exc.printStackTrace();
			System.out.println("Ne postoji element sa indeksom 2");
		}catch(NumberFormatException exc) {
			System.out.println("Ne mogu da pretvorim u int");
		}finally{
			System.out.println("Ja se uvek izvrsavam");
		}
		
		System.out.println("Ispis nakon izuzetka");
		
		Circle circle_exc = new Circle(new Point(50,50), 10);
		try {
			circle_exc.setRadius(-10);
		}catch(Exception ec) {
			System.out.println(ec.getMessage());
		}
		
	}
}
