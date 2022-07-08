# OOP

##### **Marek Smetanka**

Java Project || Anglicka E-Aukcia zabudnutých skladov || FIIT STU || Streda 16:00 || Skupina 5

V projekte je použitý MVC model -> Model, View, Controller. Na vytvorenie grafického rozhrania GUI využívame Scene builder.
Tymto spôsobom sme oddelili aplikačnú logiku od pouźivateľśkého rozhrania.

##### Agregácia Address je použítá pri Classe Being, konkrétne to je súbor Being.java.

##### Dedenie je využité pri Classoch s názvom User, a Garage a taktiež od týchto Classov dedíme VIPUser a SpecialGarage. Toto dedenie je až trojstupňové.

##### Polymorfizmus je využtý v suboroch Caller, a VIPuser. Sú to metódy getName() a getID(). Taktiež v Každom Controlleri a v Špeciálnych garážoch

##### Aplikácia sa spúšťa ./GUI/App.java.

Štruktúra programu je rozdelená do viacerých priečinkov.

**Aplikácia začína s prihlásením Callera (ten, ktorý všetko riadi, niečo ako Admin). Spravené je pridavanie Userov s chybovými hláškami ak Caller zadal nesprávne hodnoty napríklad zabudol napísať meno poúživateľa. Takto podobne je vytvorený Aj VIPUser, Garages, SpecialGarages. Taktiež tieto data sú zobrazené v zozname pre lepšiu orientáciu. Je vytovorená aj možnosť Aukcie, Caller napíše ID poúživateľa a názov Garages a cenu, za ktorú chce tento produkt zaplatiť. Ak poúživateľ neexistuje alebo Hľadaný Garage neexistuje alebo cena je menšia ako je minimálna cena Garage, tak vráti chybovú hlášku Bid was not added. Aukcia taktiež obsahuje Timer, ktorý ukončí aukciu.**

##### Ďalšie kritéria

Ošetrenie mimoriadných stavov -> AddUserController.java -> PrintError metóda

RTTI -> V každom kontroleri mapr. AuctionController.java

Vhniezdenie tiredy -> Storage.java

MultiThreading -> Časovač pri aukcií -> AuctionController.java

Lambda -> AuctionController.java

Grafické rozhranie -> ./GUI

```console
git log --pretty=format:"%h - %an, %ar : %s"
```

#### COMMITS

9eae468 - Marek Smetanka, 57 minutes ago : Documentation
8c9b7c1 - Marek Smetanka, 3 days ago : Lambda
f5f4913 - Marek Smetanka, 3 days ago : Data
33c8344 - Marek Smetanka, 3 days ago : RTTI fix
c65256f - Marek Smetanka, 4 days ago : Aukcia upravena
e5a1f5a - Marek Smetanka, 5 days ago : Remove useless imports
0503119 - Marek Smetanka, 5 days ago : RTTI
a937fae - Marek Smetanka, 5 days ago : Vhniezdenie Lambda
59463c3 - Marek Smetanka, 5 days ago : Comments
1e317fb - Marek Smetanka, 8 days ago : Thread
a6803b7 - Marek Smetanka, 11 days ago : DetailsDone
36ed05a - Marek Smetanka, 12 days ago : Auction done
2a50835 - Marek Smetanka, 4 weeks ago : Update README.md
7b7dbb7 - Marek Smetanka, 4 weeks ago : Bid aukcia funkcna + Prerobenie tlacidiel
87ad038 - Marek Smetanka, 4 weeks ago : Prerabanie
65f16ba - Marek Smetanka, 4 weeks ago : Update README.md
20180d7 - Marek Smetanka, 4 weeks ago : Vymazanie zbytocneho controllera
f0d0386 - Marek Smetanka, 4 weeks ago : Refactor kodu, Vytovrenie MVC modelu, Listovanie v dashboarde a pridavanie otestovane a funkcne s chyb hlaskami
e4ba233 - Marek Smetanka, 4 weeks ago : Zmena struktury projektu
d596e2f - Marek Smetanka, 4 weeks ago : Vytvorenie pridavana pre vsetky typy a vsetky hodnoty
78bac2b - Marek Smetanka, 4 weeks ago : Garaze, User, VIPUser pridavanie hotove
58d4b34 - Marek Smetanka, 4 weeks ago : Agregation Done
6d50b65 - Marek Smetanka, 4 weeks ago : Pridanie VIP Usera a Usera hotove
1f8d55e - Marek Smetanka, 4 weeks ago : Pridavane Userov
06de9ae - Marek Smetanka, 4 weeks ago : Dizajn GUI prepinanie
92bdaeb - Marek Smetanka, 4 weeks ago : Premenne vytvorene pre garaz a sklad plus GUI
48b4535 - Marek Smetanka, 4 weeks ago : Pridane dalsie pridavanie zatial len GUI
16a6306 - Marek Smetanka, 4 weeks ago : Prerabanie terminal aplikacie na GUI javaFX
b4735cd - Marek Smetanka, 4 weeks ago : Commit fix
e00c3a6 - Marek Smetanka, 4 weeks ago : GUI
bbee848 - Marek Smetanka, 5 weeks ago : List active presentation
8b3a497 - Marek Smetanka, 5 weeks ago : While not working
d813086 - Marek Smetanka, 5 weeks ago : Push agregation and changes from school
eb0c025 - Marek Smetanka, 5 weeks ago : Agragation
aea08a8 - Marek Smetanka, 5 weeks ago : CallerFix
32d188e - Marek Smetanka, 5 weeks ago : Overiding
5399100 - Marek Smetanka, 5 weeks ago : SeparatedGui
97fed7e - Marek Smetanka, 6 weeks ago : FormatText
50dcfea - Marek Smetanka, 6 weeks ago : AddAllElementsDone
3c781e7 - Marek Smetanka, 6 weeks ago : StorageAddingAndGettingDone
a5cf8df - Marek Smetanka, 6 weeks ago : ASCIIAdded
395f1da - Marek Smetanka, 6 weeks ago : ReadMeUpdate
cf870f4 - Marek Smetanka, 6 weeks ago : Beginning
