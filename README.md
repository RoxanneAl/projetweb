# Projet Devéloppement Web
## Description du Projet
Le Projet Supervision Web est une application web conçue pour recenser et afficher les informations météorologiques des villes de France. Utilisant des technologies de front-end et de back-end avec une base de données intégrée, le projet vise à offrir une expérience utilisateur interactive et informative.

## Objectifs
Afficher une carte de la France avec la météo des grandes villes comme Paris, Lille, Marseille, Bordeaux, etc.\
Permettre la recherche de la météo pour n'importe quelle ville française (ex : Arnac-la-Poste).\
Afficher des détails météorologiques comme la température, l'humidité et la vitesse du vent.\
Fournir un espace administrateur pour la gestion des données météorologiques.
## Technologie
Framework : Spring MVC avec serveur Tomcat intégré.\
Base de données : H2 Database.\
Front-end : HTML-CSS + Thymeleaf pour l'intégration des donnée dans le frontend et materialize pour le visuel et la fonctionnalité des bouton et bar de navigation.\
API météo : Visual Crossing Weather pour les donnée météo.\
API Google Maps :  Pour le chargement de la carte. intégration de markers et infowindows pour l'affichage des villes et des donnée météo.
## Fonctionnalités
Utilisateur : possibilité de se connecter en tant qu'administrateur afin d'éditer les données météorologiques sotckées dans H2.\
Affichage dynamique : Voir la météo actuelle des grandes villes sur la carte de France.\
Recherche de ville : Ajouter la météo d'une ville spécifique sur la carte.
## Administrateur
Gestion des données : Visualiser, modifier ou supprimer les données météorologiques dans la base de données.\
Affichage des données brutes : Accéder aux informations météorologiques au format JSON.\
Le manque de temps nous a empêché de finaliser la page d'administration.
## Technologies
Spring MVC : Modèles pour définir nos objets, annotations Spring pour signifier
qu'il s'agit d'objets JPA. Services pour définir les fonctions utilisées
par les objets. Repositories pour stocker nos objets.Controllers : gestion des URL (mapping).\
JPA : Interactions avec la base de données.\
RestTemplate : Appels API pour récupérer les données météorologiques.
Templates / Static : fichiers HTML-CSS , script javascript, gérant le front-end de notre application, utilisation de
Thymeleaf pour appeler les objets jpa dans le front. \
# Développement
## Équipe
### Répartition des tâches.
Roxanne Al-Ali: validation du code, appel de l'API weather, architecture du back, appui technique.   
Elie Devriendt: création de la base de données, implémentation des Models/Controllers/Services/Repo, JPA. Implémentation du Thymeleaf de la pop-up de connexion.  
Malo Beuchée : visuel du site (html-css, materialize), scripts js thymeleaf.
## Solutions Techniques
### Visuel du site
**visualisation des données(temp, vitesse du vent, humiditée):** affichage dans un graphique pour chaque heure. *pas fini, difficulté d'importation des données*  
**fenêtre pour la visualisation des données:** le graphique est placé dans une infowindows. Cette infowindows est issue de l'API google maps pour la propreté du visuel.  
**élément pour afficher la fenêtre:** utilisation des markers, pour la superposition sur la map, la simplicité d'utilisation et la propreté du visuel.

**Connexion vers la page admin:** utilisation d'une fenêtre de type Pop UP.  
**La Pop UP:** est affichable par un bouton.  
**le bouton de la Pop UP:** est situé dans une bar de navigation.  
**Ajouté une ville:** Dans la bar de navigation, il y a un onglet de recherche qui permet d'ajouter une ville. *le visuel est la mais la fonctionnalité est pour la v2*

**page admin:** dans la page administrateur nous avons la visualisation des donnée brute en json. *(pas finis + esaaie de le mettre sous forme de tableau)*

### Back-end du site

**Classe Users:** permet de créer l'utilisateur admin, injecté dans la base de données au lancement de l'application Springboot.\
**Classe Location:** renseigne les informations sur les villes : latitude, longitude, nom de la ville, pays.\
**Classe WeatherApiResponse:** récupère les données brutes de l'API, non utilisable directement, besoin de les traiter avant de les utiliser.\
**Classe WeatherData:** traite les données récupérées de l'API afin de garder uniquement les paramètres qui nous sont utiles. Classe non testée/implémentée.\
**contactAPI et useContactAPI:** fichiers utilisés pour tester la connexion à l'API Météo


## Problématiques

Nous avons eu des problèmes liés à la connexion entre le front et la base de données h2.

Un membre de l'équipe (Malo Beuchée) a eu une erreur lors du lancement de l'application. Cette erreur nous a mis en difficuté pour créer les différentes classe ainsi que de les tester.\

**Erreur:** Caused by: jakarta.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is org.hibernate.exception.JDBCConnectionException: Unable to open JDBC Connection for DDL execution [Mauvais nom d'utilisateur ou mot de passe \

Cette erreur a induit que nous devions tester de notre côté ce que Malo réalisait, puis corriger les erreurs. De ce fait, cela nous mobilisait tous les trois à cette tâche, nous empêchant d'avancer chacun de notre côté.

Côté back, Elie a longtemps été bloqué à l'ajout de l'utilisateur admin dans la base de données, condition nécessaire à l'implémentation du formulaire de connexion.
Une erreur de mapping(@Getmapping("/"), ainsi qu'une erreur SQL (informait que le champs ID était null, alors qu'il avait bien les attributs ID et généré automatiquement).\
La modification des champs thymeleaf de la pop-up de connexion a pris un certain temps, les modifier pour qu'ils correspondent à la classe Users.

Globalement, nous avons sous-estimé la charge de travail et le temps que l'implémentation, et l'imbrication du back avec le front prendrait.
Ce n'est que la semaine dernière que l'ajout de l'admin a pu être réalisé, débloquant la situation du back.
Chaque erreur débloquée nous amenait vers un nouveau problème plus loin dans le code. Nous avancions donc de manière ralentie.

**Ce qu'il nous reste à faire:** Terminer la classe WeatherData, l'implémentation de celle-ci : vérifier qu'on arrive bien à récupérer les données brutes et les transformer pour conserver les données utiles.
Une fois les données utiles sauvegardées, les afficher dans les pop-up du front. Via les services, les injecter dans le script js.\
Pour créer les marqueurs, il faut envoyer une requête API, l'idée pour conserver les marqueurs, est donc de sauvegarder ces requêtes dans notre BDD et les lancer à l'initialisation de l'application.
Ajouter un marqueur va donc venir sauvvegarder la requêtes API associée.\
Création de la page admin, en plus de visualiser les données via les services qui iront chercher les données depuis les repositories, il faudra avoir une interface web pour modifier ces données.
Cela implique du mapping côté back pour réaliser les actions CRUD qui iront modifier les données.\
Implémentation de la barre de recherche pour pouvoir ajouter les villes. L'ajout de villes implique l'ajout d'un marqueur (requête API), la récupération des données météo de la ville(requête API),
la sauvegarde de ces données et  le traitement des données météo.\
Une fois le site complètement fonctionnel, amélioration du visuel du site.

**Lien du github:** https://github.com/RoxanneAl/projetweb




