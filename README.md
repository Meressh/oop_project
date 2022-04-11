# OOP

##### **Marek Smetanka**

Java Project || Anglicka E-Aukcia zabudnutých skladov || FIIT STU || Streda 16:00 || Skupina 5

V projekte je použitý MVC model -> Model, View, Controller. Na vytvorenie grafického rozhrania GUI využívame Scene builder. 
Tymto sposobom sme oddelili aplikacnu logiku od pouzivatelskeho rozhrania.
Z pociatku som tuto aukciu robil ako terminalovú aplikáciu, ale nakoniec som to prerobil do gui pomocou javaFx a scene buildera, čo mi zabralo veľa času :).

Agregácia Address je použítá pri Classe Being, konkrétne to je súbor Being.java
Dedenie je využité pri Classoch s názvom User, a Garage a taktiež od týchto Classov dedíme VIPUser a SpecialGarage. Toto dedenie je až trojstupňové.
Polymorfizmus je vyuzity v suboroch Caller, a VIPuser.
