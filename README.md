# Fullstack Projet

- in cmd: docker compose up -d
- jenkins : 
  - user: admin
  - mdp: admin


Trois utilisateurs par défaut (username, password): 
- user, !Password1 (MEDECIN)
- admin, !Password1 (ADMIN)
- superAdmin, !Password1 (SUPERADMIN)

## PARTIE BACK : 

- Nous avons six chemins au total : 
  - ```localhost:8080/public/**```  qui correspond à la partie publique de notre API 
  - ```localhost:8080/api/**```  qui correspond aussi à la partie publique de notre API pour la gestion des centres
  - ```localhost:8080/medecin``` qui correspond à la partie de gestion pour les médecins
  - ```localhost:8080/admin``` qui correspond à la partie de gestion pour les admins
  - ```localhost:8080/superadmin``` qui correspond à la partie de gestion pour les superadmins

Pour se connecter sur les parties médecins, admin et superadmin il faut avoir les rôles correspondant. 

Un sixième chemin est disponible à l'adresse : ```localhost:8080/actuator/prometheus``` qui nécessite l'accès "SUPERADMIN" pour avoir accès aux métriques. 
La métrique que nous avons ajouté permet l'incrémentation de la variable "Nombre_de_rendez_vous" à chaque création d'un nouveau rendez-vous. 
```
# HELP Nombre_de_rendez_vous_:__total  
# TYPE Nombre_de_rendez_vous_:__total counter
Nombre_de_rendez_vous_:__total 10.0
```

## PARTIE FRONT : 

Pour pouvoir tester les différentes fonctionnalités, il est possible d'utiliser les trois utilisateurs par défaut. 

Un admin peut seulement créer un nouveau médecin alors qu'un superadmin peut créer un nouveau admin et le supprimer. Ceci se passe dans sur la page "inscrire un médecin" visible seulement pour un admin ou un superadmin. 

De même, par défaut n'importe quel utilisateur peut créer un rendez-vous cependant si un admin est connecté, il pourra supprimer les rendez-vous en fonction d'un centre. Un superadmin aura une page vide à la place. 

Les superadmin ont accès à une interface qui leur est propre qui leur permet de chercher les centres et de les supprimer, de même avec les utilisateurs en utilisant leur ID. 

## LANCER LE PROJET :
Suite a des problème lié a docker, il n'y a pas d'image de l'application. Il faut donc lancer manuellement le projet.

ouvrir un terminal dans le dossier dev-fullstack/TD/covidfront et utiliser la commande ng serv pour lancer la partie Front

pour le back, lancer l'application dev fullstack/TD/covid-api/covid-api/src/main/java/org/polytech/covidapi/CovidApiApplication.java    

## Etudiants : 

Julian Gaillard (Galaxycorn) n°31806139

Mathis Coiraton (MCoiraton) n°31807014

