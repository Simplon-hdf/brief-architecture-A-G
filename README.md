# Application de Gestion de Panier d'Achats

## Description
Cette application est un système de gestion de panier d'achats développé avec Spring Boot, suivant une architecture en couches N-tier. 
Elle permet la gestion des produits et des paniers d'achats.

## Lancer le projet
- Cloner le dépôt git
```
git clone git@github.com:Simplon-hdf/brief-architecture-A-G.git
```

- Ajouter les secret properties donné à part dans le dossier des applications properties de chacun des modules enfant:
```
brief-architecture-A-G/brief-architecture/brief-presentation/src/main/resources/
```
```
brief-architecture-A-G/brief-architecture/brief-business/src/main/resources/
```
```
brief-architecture-A-G/brief-architecture/brief-persistence/src/main/resources/
```

- Récupérer et installer le script dans votre base de donnée:
```
brief-architecture-A-G/script.sql
```

- Dans le dossier brief-architecture, lancer ces deux commandes à la suite:
```
mvn clean install
```

```
java -jar brief-presentation/target/brief-presentation-0.0.1-SNAPSHOT.jar
```

- Pour aller sur le swagger, l'adresse est la suivante:
http://localhost:8080/swagger-ui/index.html

## Architecture
Le projet est structuré en trois modules principaux :

### 1. Module Présentation (`brief-presentation`)
- Gestion des contrôleurs
- Gestion des requêtes HTTP

### 2. Module Business (`brief-business`)
- Logique métier de l'application
- Services et DTOs

### 3. Module Persistence (`brief-persistence`)
- Gestion de la persistance des données
- Entités et repositories
- Configuration de la base de données

## Prérequis
- Java 17 ou supérieur
- Maven 3.8+
- PostgreSQL 15+

## Auteurs
- Aurore
- Gabriel
