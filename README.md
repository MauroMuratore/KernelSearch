# Come usarlo:
1. Scaricare il file zip da github 
2. Estrarlo in una cartella
3. Assicurarsi di aver installato correttamente gurobi sul proprio computer
4. Per lanciare il programma:
4.1. Aprire powershell
4.2. Spostarsi all'interno della cartella KernelSearch (cd $PERCORSO_KERNEL_SEARCH)
4.3. Usare il comando "java -cp $PERCORSO_GUROBI kernel.StartAllOriginal $MPS $RISULTATI $CONFIG N" dove:
$PERCORSO_GUROBI il percorso per raggiungere la libreria gurobi.jar, è dentro la cartella gurobi/lib
$MPS il percorso dove sono salvati i vari modelli, ho caricato anche un zip con all'interno i diversi modelli
$RISULTATI dove andare a salvare i risultati
$CONFIG il percorso del file di configurazione
N numero intero che indica quante configurazioni usare

#CONFIG
Il file di configurazione può esprimere più configurazioni da usare. Nell'esempio caricato ci sono alcuni parametri (SORTER, KERNEL_BUILDER, KERNEL_SIZE, 
BUCKET_BUILDER, BUCKET_NUMBER, BUCKET_SIZE) che hanno una lista di 4 elementi, questo per poter eseguire il kernel search su tutti i modelli con 4 configurazioni
diverse. Se ne possono aggiungere altri, ma è importante che tutti questi parametri abbiano lo stesso numero di elementi. L'ultimo parametro del comando 4.3.
indica quante configurazioni usarne, quindi se nel config.txt ci sono 5 elementi dopo i parametri N deve essere compreso tra 1 e 5 per poter lanciare il comando.

#SORTER
Ci sono due tipi di ordinamento:
0 in ordine decrescente di Xr e poi di Rc
1 come il precedente ma Xr viene moltiplicato per 0.05*(valore/peso)
#KERNEL-BUILDER
Ce ne sono due di builder:
0 in cui nel kernel entrano tutti gli items con Xr>0 (builderPositive)
1 in cui i primi X items entrano nel kernel (builderPercentage)
#KERNEL-SIZE
numero decimale compreso tra 0 e 1 esclusi, specifica la dimensione del kernel in caso si usi il builderPercentage
#BUCKET_BUILDER
Ce ne sono 3 di builder:
0 defaultBucketBuilder, specificata la dimensione crea tutti i bucket possibili con quella dimensione, quindi vengono 
usati tutti gli item
1 numericBucketBuilder, speficati dimensione e numero di bucket, crea n bucket di dimensione fissata
2 noBucketBuilder, non vengono costruiti bucket
#BUCKET_NUMBER
numero di intero di bucket da costruire
#BUCKET_SIZE
numero decimale compreso tra 0 e 1 esclusi, specifica la dimensione dei bucket 

Anche se qualche parametro non viene usato è necessario scriverli comunque nel file di configurazione
