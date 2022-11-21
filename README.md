## Comandi

Per fare build e deploy della webapp è sufficiente eseguire il comando `docker-compose up -d` all'interno della directory in cui si è unzippato il file compresso .zip

Una volta avviata l'applicazione, è possibile accedere all'interfaccia dal seguente indirizzo:  
http://localhost:3031/employee/show
Attenzione: l'avvio del database richiede un po' di tempo; ovviamente, finchè non è completo, la webapp non sarà funzionante. Sulla macchina virtuale fornita per il laboratorio, il database impiega un tempo piuttosto lungo (30 secondi circa), dopo i quali in automatico la webapp si connette al DB. Infine, per terminare webapp e relativo db, è sufficiente eseguire il comando `docker-compose down`

## Introduzione alla WebApp

Per eseguire questo esercizio ho scaricato una semplice web-app SpringBoot da Internet (presso https://realnamehiddenn.blogspot.com/2022/07/spring-boot-crud-web-application.html), apportando qualche semplice modifica per utilizzare le ultime versioni di Maven e Java. Si tratta di un progetto molto semplice e con pochi controlli relativi agli inserimenti effettuati dall'utente da tastiera. Tuttavia, questo progetto consente di svolgere operazioni basilari CRUD su un database MySQL, perciò l'ho ritenuto adatto a questo esercizio.

Nella parte superiore vi sono i collegamenti DATA e REGISTER, che portano rispettivamente ad una pagina con una lista dei dipendenti registrati nel sistema (operazioni Read, Update e Delete) e al form che consente l'inserimento di nuovi dipendenti (operazioni Create). Prestare attenzione all'inserimento del campo Salary, che accetta solo valori numerici e senza virgola (questo perchè il sistema manca di controlli sugli input utente).

Per far in modo che il container relativo all'applicazione SpringBoot vedesse quello del database, oltre ad utilizzare una rete bridge, è stato necessario usare una variabile di ambiente nel docker-compose per sostituire il valore di spring.datasource.url, contenuto nel file app/src/main/resources/application.properties. Lo stesso procedimento, attuato mediante le variabili d'ambiente, è stato adottato anche per username e password del file application.proprerties; in questo maniera, l'applicazione può essere utilizzata in maniera indipendente dalla propria configurazione "statica" di connessione al database contenuta in application.properties.
