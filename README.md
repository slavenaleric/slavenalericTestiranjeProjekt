# Reqres.in API Testing Framework

Ovaj projekt je okvir za automatsko testiranje REST API-ja korištenjem Java i REST Assured biblioteke.

## Testirana aplikacija

- [Reqres.in](https://reqres.in/)
- REST API: `https://reqres.in/api`

## Kako pokrenuti testove

1. Kloniraj ovaj repozitorij
2. U root folderu pokreni mvn test

## Korišteni alati

- Java
- Maven
- REST Assured
- JUnit

## Testni slučajevi

1. Dohvat liste korisnika (GET /users)
2. Kreiranje novog korisnika (POST /users)
3. Dohvat korisnika po ID-u (GET /users/{id})
4. Ažuriranje korisnika (PUT /users/{id})
5. Brisanje korisnika (DELETE /users/{id})

- Svi testovi nalaze se u datoteci `ReqresApiTest.java` u folderu `src/test/java/`.

GET /users?page=2: provjeravamo da API vraća popis korisnika na drugoj stranici, da su podaci ispravni i da lista nije prazna.

POST /users: šaljemo zahtjev za kreiranje novog korisnika i provjeravamo da odgovor sadrži točne podatke.

GET /users/{id}: dohvaćamo korisnika s poznatim ID-om i provjeravamo podatke.

PUT /users/{id}: ažuriramo podatke korisnika i provjeravamo odgovor.

DELETE /users/{id}: brišemo korisnika i očekujemo status 204 (bez sadržaja), što je potvrda uspješnog brisanja.