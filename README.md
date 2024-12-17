# Bird Observation Report

## À propos du projet

L'objectif de ce projet est de créer une API qui permettra de signaler une observation d'oiseaux. En indiquant l'espèce, le nombre ou même la ville où ils ont été observés.

Cette API est utilisé par une IHM web qui facilite l'accès aux resources pour récupèrer, poster ou même modifier des observations.

## Deployement du serveur

1. Lancez la commande `docker-compose up` pour lancer la base de donnée (lancez Docker Deskop précédement).

2. Lancez la commande `cd api` puis `mvn spring-boot:run` pour lancer l'API.

3. Lancez la commande `cd front-web` puis `npm start` sur un nouveau terminal. Navigez ensuite vers `http://localhost:4200/`.

## Création des branches et nommage des commits

**Langue à respecter pour le nommage** : `Français` -> Par exemple : `Ajout : Route pour signaler une observation`

- Ajout : ajout d'une nouvelle fonctionnalité.
- Modif : modification d'une fonctionnalité déjà implémentée en précisant la modification apportée.
- Refacto : refactoring de code, de nommage. Ce qui modifie le code sans ajouter de fonctionnalités ou corriger de bugs.
- Fix : correction de bug.

Les noms des branches devront être en lien avec les US définis sur le board [miro](https://miro.com/welcomeonboard/Wnl6SVQwY3ZHdGdtWlhHOVBPTm85eFBSYzJyczJLZlc2TUI4U1ZKZ0pqSTRwOFBDTmx2YWNheGhmREE0YUduZ0IrWm90cDFhcFo1ajFpcG1EUTNpaW9DQWU3aW5lTjFlVk9DcWZEd2pTNTlWQzN4K05GRTNpNlVOcjRFZ013bmYhZQ==?share_link_id=315813660092):

(us1)

Pour le nommage des commits, il faut respecter ce nommage afin que ce soit homogène :

[Ajout, Modif, Refacto, Fix] : [message explicite court]

Exemple, si je veux ajouter un commit car j'ai développé un nouveau composant -> 
`Ajout : Composant liste robot pour afficher tout les robots de l'api`

---

## Nommage des composants et des fichiers Java

**Langue à respecter pour le nommage** : `Anglais` -> par exemple : ObservationController

- Le nom des fichiers devra avoir un nommage de type Pascal Case : NomFichier


- Le nom des classes devra avoir un nommage de type Pascal Case: NomDeMaClasse


- Le nom des fonctions devra avoir un nommage de type Camel Case : nomDeMaFonction


- Le nom des constantes devra avoir un nommage de type Snake Upper Case : NOM_DE_CONSTANTE


- Le nom des variables devra avoir un nommage de type Camel Case : nomVariable

## Nommage des composants et des fichiers Angular (typescript, html, scss)

**Langue à respecter pour le nommage** : `Anglais` -> par exemple : page-list-reports

- Le nom des fichiers devra avoir un nommage de type Kebab Case : nom-fichier


- Le nom des classes devra avoir un nommage de type Pascal Case: NomDeMaClasse


- Le nom des fonctions devra avoir un nommage de type Camel Case : nomDeMaFonction


- Le nom des constantes devra avoir un nommage de type Snake Upper Case : NOM_DE_CONSTANTE


- Le nom des variables devra avoir un nommage de type Camel Case : nomVariable