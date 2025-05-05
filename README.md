Étape 1 : Utilisation du Dépôt Partagé avec Git Localement

    Chaque membre de l'équipe doit cloner le dépôt sur sa machine locale pour commencer à travailler : 
        Ouvrez votre terminal.
        Naviguez jusqu'au répertoire où vous souhaitez enregistrer le projet sur votre machine en utilisant la commande cd.
        Sur la page du dépôt GitHub (dans l'onglet "Code"), cliquez sur le bouton vert "Code".
        Copiez l'URL du dépôt en choisissant HTTPS.
        Dans votre terminal, exécutez la commande suivante : 
        
        git clone https://github.com/VOTRE-NOM-D-UTILISATEUR/NOM-DU-DEPOT.git
        Git va télécharger le contenu du dépôt sur votre machine dans un nouveau dossier portant le nom du dépôt.

Les bonnes manières avant de travailler

    Il est toujours bon de rappeler les bases du workflow Git pour une collaboration efficace :
        Récupérer les dernières modif : Avant de commencer à travailler, exécutez git pull origin main (ou git pull origin <nom-de-la-branche-principale>) pour vous assurer d'avoir la version la plus récente du dépôt distant.
        Créer des branches pour les fonctionnalités/corrections : git branch nouvelle_branche et git checkout nouvelle_branche.
        Effectuer vos modifications, ajouter les fichiers (git add .), et commiter (git commit -m "Description de mes changements").
        Pousser votre branche vers le dépôt distant : git push origin nom_branche.
        Créer une Pull Request sur GitHub : Depuis l'interface web de GitHub, créez une Pull Request pour proposer vos changements à la branche principale. Cela permet la revue de code et la discussion.
        Fusionner la Pull Request : Une fois approuvée, la Pull Request est fusionnée dans la branche principale.
        Récupérer les modifications fusionnées : Les autres membres de l'équipe doivent exécuter git pull origin main pour intégrer les changements.
