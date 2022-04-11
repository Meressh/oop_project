# OOP

##### **Marek Smetanka**

Java Project || Anglicka E-Aukcia zabudnutých skladov || FIIT STU || Streda 16:00 || Skupina 5

V projekte je použitý MVC model -> Model, View, Controller. Na vytvorenie grafického rozhrania GUI využívame Scene builder. 
Tymto sposobom sme oddelili aplikacnu logiku od pouzivatelskeho rozhrania.
Z pociatku som tuto aukciu robil ako terminalovú aplikáciu, ale nakoniec som to prerobil do GUI pomocou javaFx a scene buildera, čo mi zabralo veľa času :).

##### Agregácia Address je použítá pri Classe Being, konkrétne to je súbor Being.java.
##### Dedenie je využité pri Classoch s názvom User, a Garage a taktiež od týchto Classov dedíme VIPUser a SpecialGarage. Toto dedenie je až trojstupňové.
##### Polymorfizmus je vyuźitý v suboroch Caller, a VIPuser. Sú to metódy getName() a getID().
#####
##### Aplikácia sa spúśťa ./GUI/App.java.
##### Aplikácia začína s prihlásením Callera (ten, ktorý všetko riadi, niečo ako Admin). Spravené je pridavanie Userov s chybovimi hláškami ak Caller zadal nesprávne hodnoty napríklad zabudol naísať meno poúživateľa. Takto podobne je vytvorený Aj VIPUser, Garages, SpecialGarages. Taktiez tieto data sú zobrazené v zozname pre lepšiu orientáciu. Je vytovorená aj možnosť Aukcie, Caller napíše ID poúživateľa a názov Garages a cenu, za ktorú chce tento produkt zaplatiť. Ak poúźivateľ neexistuje alebo Hľadaný Garage neexistuje alebo cena je menšia ako je minimálna cena Garage, tak vráti chybovú hlášku Bid was not added.

##### Nestihol som spravit zobrazenie detailov produktu v aukcii a taktiež štatistiky a cele ukončenie aukcie (ukončenie neukláda dáta do štatistík a ani do histórie použivateľov.).
