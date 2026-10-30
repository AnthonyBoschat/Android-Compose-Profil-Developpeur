## Titre
Profil Développeur Anthony

## Capture

<img width="1047" height="1068" alt="{1B99285B-54D5-4C74-AC6F-758CE4F8761C}" src="https://github.com/user-attachments/assets/c2806e50-4322-4b1b-8cc3-bdfbf8d3c80b" />


## Description courte
Affiche dans une card le profil d'un développeur, en l'occurence ici le mien.


Contient le nom du profil, une liste de compétence, des informations de contact, la disponibilité, et un bouton pour permettre à terme de contact le développeur.


## Notion utilisées

- Utilisation des composant réutilisable : Composable
- Utilisation des classe de style : Modifier
- Preview pour afficher en temp réel le composant
- Padding externe / interne
- Callbacks
- Paramètres de composants
- Accessibilité de base : Rôle Button (lecteur d'écrans)

## Explication courte

#### Quels composables avez-vous créés ?


> - Profil : Le composant de profil général
> - ProfilCard : La carte du profil
> - ProfilHeader : L'entête du profil
> - SectionTitle : Le titre d'une section
> - Skill : Une compétence en particulier
> - Action : Les call to Action (bouton) du profil
> - Information : Le titre d'une section (composant SectionTitle) et son contenu
> - ProfilPreview : La preview



#### Quel composable représente l’écran principal ?

> Profil() ( MainActivity en vrai qui appel le composant Profil() mais osef )

#### Où utilisez-vous un padding externe ?

> Dans la classe MainActivity, lors de l'appel au composant Profil

#### Où utilisez-vous un padding interne ?

> Dans le composant ProfilCard, le Column() a l'intérieur de la Surface a un padding de 20.dp -> espace le contenu avec le bord de la Card

#### Quel composant reçoit un callback ?

> Le composant Action (Bouton)

#### Quelle information d’accessibilité avez-vous ajoutée ?

> Le composant Button, qui indique à un lecteur d'écran que la zone est cliquable.

#### Pourquoi vos composants peuvent-ils être considérés comme réutilisables ?

> Ils sont réutilisables parceque ce sont les parent qui définisse le contenu, le style, le positionnement.
> Le composant peut être appeller plusieurs fois avec des paramètres différent, le composant s'adapte.

