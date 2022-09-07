# Déclaration liste type de lettre
LISTE_TYPE_LETTRE = ['verte', 'prioritaire', 'éco-pli']

# Dictionnaire des tarifs des différents types
TARIF_LETTRE_VERTE = {20: 1.16, 100: 2.32, 250: 4.00, 500: 6.00, 1000: 7.50, 3000: 10.50}
TARIF_LETTRE_PRIORITAIRE = {20: 1.43, 100: 2.86, 250: 5.26, 500: 7.89, 3000: 11.44}
TARIF_LETTRE_ECOPLI = {20: 1.14, 100: 2.28, 250: 3.92}


def saisie_verification_type() -> str:
    """
    Permet de demander et vérifier le type de la lettre
    :return: type_lettre (str) contient le type (valide) de la lettre
    """
    # Initialisation variables
    valide = False
    type_lettre = ""

    # Boucle jusqu'à ce que le type de lettre soit valide
    while not valide:
        type_lettre = input("Entrez un type de lettre {} ".format(LISTE_TYPE_LETTRE))
        if type_lettre in LISTE_TYPE_LETTRE:
            valide = True
        else:
            print("Choix non valide")
    return type_lettre

def saisie_verification_poids() -> int:
    """
    Permet de récupérer et vérifier si le poids entré est un entier
    :return: poids_lettre (int) correspond au poids de la lettre
    """
    # Initialisation variables
    valide = False
    poids_lettre = 0

    # Boucle jusqu'à ce que le poids soit validé
    while not valide:
        poids_lettre = input("Entrez le poids de la lettre en g ")

        # Vérification que le poids est valide (nombre positif)
        try:
            # Test si poids est un nombre > 0
            if int(poids_lettre) > 0:
                valide = True
            # Si poids est un nombre négatif
            else :
                print("Poids négatif. Entrez un poids valide")
        # Erreur si le poids n'est pas un nombre
        except:
            print("Format de poids non valide. Entrez des chiffres")

    return int(poids_lettre)

def trouver_prix(poids: int, tarif:dict) -> float:
    """
    permet de trouver le prix de l'affranchissement en fonction du poids et du type de la lettre
    :param poids: (int) poids de la lettre entré par l'utilisateur
    :param tarif: (dict) contient les correspondances poids-tarif d'un type de lettre
    :return: (float) correspond au prix final - 0 si lettre trop lourde
    """
    # Parcourir le dictionnaire des tarifs pour trouver le prix
    for i in tarif:
        # Comparaison poids lettre avec le poids max pour chaque tarif
        if poids < i:
            # Renvoie le premier tarif correspondant au poids de la lettre
            return tarif[i]

    return 0

def main():
    """
    boucle principale - demande les types, poids et prix de la lettre - fait appel aux fonctions correspondantes
    :return:
    Affiche un récapitulatif du type, poids et prix de la lettre
    """
    # Saisie + vérification du type de lettre
    type_lettre = saisie_verification_type()

    # Saisie + vérification du poids de la lettre
    poids_lettre = saisie_verification_poids()

    # Passage du dictionnaire des tarifs en fonction du type de lettre choisit (verte, prioritaire, éco-pli)
    if type_lettre == LISTE_TYPE_LETTRE[0]:
        tarif = TARIF_LETTRE_VERTE

    elif type_lettre == LISTE_TYPE_LETTRE[1]:
        tarif = TARIF_LETTRE_PRIORITAIRE

    elif type_lettre == LISTE_TYPE_LETTRE[2]:
        tarif = TARIF_LETTRE_ECOPLI

    # Récupération du prix
    prix_final = trouver_prix(poids_lettre, tarif)

    if prix_final > 0:
        print("L'affranchissement va vous coûter : {prix} € pour une lettre {type} pesant {poids} g.".format(prix=prix_final, type=type_lettre, poids=poids_lettre))
    else:
        print("Lettre trop lourde.")

# Lancement de la boucle
main()
