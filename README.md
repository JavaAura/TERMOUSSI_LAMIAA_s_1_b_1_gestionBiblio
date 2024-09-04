Application Java Console pour la Gestion de Bibliothèque

Ce projet est une application console en Java 8 développée pour automatiser les tâches de gestion d'une bibliothèque municipale, comme l'inventaire des livres et magazines, ainsi que la gestion des emprunts et retours.

Architecture

L'application suit une architecture en couches :

   1. Couche de présentation : ConsoleUI pour l'interface utilisateur interactive.
   2. Couche métier :
        Document : classe abstraite représentant un document.
        Livre et Magazine : classes qui héritent de Document.
        Bibliotheque : gestion de la collection de documents.
   3. Couche utilitaire : DateUtils pour la gestion des dates.

 Classes et Attributs

  Document (abstrait)
        Attributs : id, titre, auteur, datePublication, nombreDePages
        Méthodes abstraites : emprunter(), retourner(), afficherDetails()

  Livre (hérite de Document)
        Attribut supplémentaire : isbn

  Magazine (hérite de Document)
        Attribut supplémentaire : numero

  Fonctionnalités Principales

  Ajouter un document (livre ou magazine)
  Emprunter un document
  Retourner un document
  Afficher tous les documents
  Rechercher un document

  Spécifications Techniques

  Utilisation de ArrayList pour stocker les documents.
  Recherche rapide implémentée avec HashMap<String, Document>.
  Gestion des dates avec l'API Java Time.
  Utilisation d'expressions lambda pour des opérations fonctionnelles.
