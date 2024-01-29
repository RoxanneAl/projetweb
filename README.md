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
Front-end : Thymeleaf pour l'intégration des donnée dans le frontend et materialize pour le visuel et la fonctionnalité des bouton et bar de navigation.\
API météo : Visual Crossing Weather pour les donnée météo.\
API Google Maps :  Pour le chargement de la carte. intégration de markers et infowindows pour l'affichage des villes et des donnée météo.
## Fonctionnalités
Utilisateur\
Affichage dynamique : Voir la météo actuelle des grandes villes sur la carte de France.\
Recherche de ville : Ajouter la météo d'une ville spécifique sur la carte.
## Administrateur
Gestion des données : Visualiser, modifier ou supprimer les données météorologiques dans la base de données.\
Affichage des données brutes : Accéder aux informations météorologiques au format JSON.
## Techniques
Controllers Spring : Gestion des URL et logique métier.\
JPA : Interactions avec la base de données.\
RestTemplate : Appels API pour récupérer les données météorologiques.

# Développement
## Équipe
### Répartition des tâches.
Roxanne Al-Ali: validation du code, appel de l'API weather, architecture du back.   
Elie Devriendt: création de la base de donnée, Controllers Spring, JPA.   
Malo Beuchée : visuel du site, thymeleaf. 
## Solutions Techniques
### Visuel du site
**visualisation des données(temp, vitesse du vent, humiditée):** affichage dans un graphique pour chaque heure. *pas finis, difficulté d'importation des donnée*  
**fenêtre pour la visualisation des données:** le graphique est placer dans une infowindows. Cette infowindows est issue de l'API google maps pour la propretés du visuel.  
**élément pour affiché la fenêtre:** utilisation des markers, pour la supperposition sur la map, la simplicité d'utilisation et la propreté du visuel.  

**Connexion vers la page admin:** utilisation d'une fenêtre de type Pop UP.  
**La Pop UP:** est affichable par un bouton.  
**le bouton de la Pop UP:** est situé dans une bar de navigation.  
**Ajouté une ville:** Dans la bar de navigation, il y a un onglet de recherche qui permet d'ajouter une ville. *le visuel est la mais la fonctionnalité est pour la v2*

**page admin:** dans la page administrateur nous avons la visualisation des 