package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu{

	/* CONSTRUCTOR */
	public ModifierPizzaOptionMenu() {
		super();
	}
	
	/* METHODS */
	
	/**
	 * Method Execute
	 */
	public void execute() {
		displayMenu3();
	}
	
	/**
	 * Get Libelle of option
	 * @return
	 */
	public String getLibelle() {
		return "Mettre � jour une pizza";
	}
	
	
	/**
	 * Display menu 3 to update pizza
	 */
	public void displayMenu3() {
		System.out.println("\nMise � jour d'une pizza");
		System.out.println("\nPizzas size: "+ this.getPizzas().length);
		displayPizzaList();
		System.out.println("99 pour abandonner");
		System.out.println("Veuillez choisir la pizza � modifier (saisir le code) : ");
		String choice = scanner.nextLine();
		if(choice != "99") {
			System.out.println("Veuillez saisir le code: ");
			String code = scanner.nextLine();
			System.out.println("Veuillez saisir le nom: ");
			String nom = scanner.nextLine();
			System.out.println("Veuillez saisir le prix: ");
			String prixStr = scanner.nextLine(); 
			
			
			if(code != null && code.length() == 3 ) {
				/* Code has to be to upperCase */
				code = code.toUpperCase();
				if(nom != null && prixStr != null) {
					double prix = Double.parseDouble(prixStr);
					if(prix > 0) {
						Pizza pizza = new Pizza(code,nom,prix);
						this.getDao().updatePizza(choice, pizza);
					} else {
						System.out.println("Erreur de saisie: ");
						System.out.println(" Le prix doit �tre positif");
					}
				} else {
					System.out.println("Erreur de saisie: ");
					System.out.println(" - le nom doit �tre saisi");
					System.out.println(" Le prix doit �tre saisi");
					
				}
				
			} else {
				System.out.println("Erreur de saisie : ");
				System.out.println("le code doit comporter 3 lettres");
			}
		}
		
	}
}
