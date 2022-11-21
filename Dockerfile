# Uso come image base quella di maven, tag 3-amazoncorretto-11;
# poi trasferisco il contenuto della cartella app del filesystem
# host presso la cartella app del container, e attivo la working
# directory presso la medesima. Infine, buildo il progetto.
FROM maven:3-amazoncorretto-11 as buildstage
ADD /app /app
WORKDIR /app
RUN mvn clean install -Dmaven.test.skip=true

# Uso come image base quella di amazoncorretto, tag 11; poi, della
# vecchia immagine, mantengo solo il file .jar della webapp
# compilata, il resto non serve. Sottolineo poi la necessità di
# esporre la porta 3031 (anche se ciò non la espone), e quando
# l'utente avvia il container eseguo il comando che avvia la webapp.
FROM amazoncorretto:11
COPY --from=buildstage /app/target/SpringbootCrud-0.0.1-SNAPSHOT.jar /
EXPOSE 3031
ENTRYPOINT ["java", "-jar", "SpringbootCrud-0.0.1-SNAPSHOT.jar"]