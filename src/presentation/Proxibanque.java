package presentation;

import java.util.List;
import java.util.Scanner;

//import java.util.ArrayList;
//import model.Agency;
//import model.AgencyManager;
//import model.CustomerAdvisor;

import model.BankCard;
import model.CurrentAccount;
import model.Customer;
import model.ElectronVisaCard;
import model.SavingAccount;
import service.IService;
import service.ServiceCustomer;

/**
 * @author Clothilde & Jean-Michel
 *
 */
public class Proxibanque {

	/**
	 * Ce programme sert à réaliser les tâches du conseiller bancaire Gestion des
	 * clients et opérations bancaires courantes
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Initialization
		IService<Customer> service = new ServiceCustomer();

		// Création d'une base de données initiale

		CurrentAccount cA1 = new CurrentAccount(503.28, "01/09/17");
		CurrentAccount cA2 = new CurrentAccount(1500.62, "26/03/14");
		CurrentAccount cA3 = new CurrentAccount(3672.17, "17/06/12");

		SavingAccount sA1 = new SavingAccount(5000, "24/12/13");
		SavingAccount sA2 = new SavingAccount(2456, "24/12/13");
		SavingAccount sA3 = new SavingAccount(1325, "24/12/13");

		Customer c1 = new Customer("Chirac", "Jacques", "2 rue des Capucines", "75002", "Paris", "0164870275", cA1,
				sA1);
		Customer c2 = new Customer("César", "Jules", "66 avenue des Brutes", "75011", "Paris", "0164456223", cA2, sA2);
		Customer c3 = new Customer("Le Hibou", "Boubou", "87 rue de la forêt", "66002", "Perpignan", "0164145047", cA3,
				sA3);

		service.create(c1);
		service.create(c2);
		service.create(c3);

		// Création d'agences

		// AgencyManager manager1 = new AgencyManager("Dark", "Vador");
		// AgencyManager manager2 = new AgencyManager("Dalton", "Ma");
		//
		// CustomerAdvisor advisor1 = new CustomerAdvisor("Dalton", "Joe");
		// CustomerAdvisor advisor2 = new CustomerAdvisor("Dalton", "Jack");
		// CustomerAdvisor advisor3 = new CustomerAdvisor("Dalton", "William");
		// CustomerAdvisor advisor4 = new CustomerAdvisor("Dalton", "Averell");
		// CustomerAdvisor advisor5 = new CustomerAdvisor("Comte", "Dooku");
		// CustomerAdvisor advisor6 = new CustomerAdvisor("Empereur", "Palpatine");
		//
		// List<CustomerAdvisor> staff1 = new ArrayList<>();
		// staff1.add(advisor1);
		// staff1.add(advisor2);
		// staff1.add(advisor3);
		// staff1.add(advisor4);
		// staff1.add(manager1);
		// List<CustomerAdvisor> staff2 = new ArrayList<>();
		// staff2.add(advisor5);
		// staff2.add(advisor6);
		//
		// Agency agency1 = new Agency("01", "02/04/02", manager1, staff1);
		// Agency agency2 = new Agency("02", "14/10/05", manager2, staff2);

		System.out.println(service.readAll());

		// Scénario
		Scanner scan = new Scanner(System.in);
		int choiceTask;
		do {

			System.out.println(
					"-----------------------\nQue voulez-vous faire ? \n1 - Gestion des clients \n2 - Opération bancaire \n3 - Quitter le logiciel\n-----------------------");
			choiceTask = scan.nextInt();

			switch (choiceTask) {
			case 1:
				int choiceCustomerManagement;
				do {
					System.out.println(
							"--------------------------------\nQue voulez-vous faire ? \n1 - Créer un client \n2 - Lire les données d'un client \n3 - Modifier un client \n4 - Supprimer un client \n5 - Quitter\n--------------------------------");
					choiceCustomerManagement = scan.nextInt();
					scan.nextLine();

					switch (choiceCustomerManagement) {
					case 1: // Client, Account & Card creation
						Customer c = new Customer(null, null, null, "00000", null, "0000000000");
						System.out.print("Entrez le nom : ");
						String lastName = scan.nextLine();
						c.setLastName(lastName);
						System.out.print("Entrez le prénom : ");
						String firstName = scan.nextLine();
						c.setFirstName(firstName);
						System.out.print("Entrez l'adresse : ");
						String address = scan.nextLine();
						c.setAddress(address);
						String postalCode;
						do {
							System.out.print("Entrez le code Postal (5 chiffres) : ");
							postalCode = scan.nextLine();
						} while (postalCode.length() != 5);
						c.setPostalCode(postalCode);
						System.out.print("Entrez la ville : ");
						String city = scan.nextLine();
						c.setCity(city);
						String phoneNumber;
						do {
							System.out.print("Entrez le numéro de téléphone (10 chiffres) : ");
							phoneNumber = scan.nextLine();
						} while (phoneNumber.length() != 10);
						c.setPhoneNumber(phoneNumber);
						service.create(c);

						int i = 0;
						do {
							c.setNumberOfAccounts(i);
							int choiceAccountCreation = 0;
							String choiceAccountAdding;

							if (c.getNumberOfAccounts() == 0) {
								System.out.println("Quel compte voulez-vous créer : \n1 - Courant \n2 - Epargne ");
								choiceAccountCreation = scan.nextInt();
								scan.nextLine();
							} else if (c.getCustomerSaving() == null) {
								scan.nextLine();
								System.out.print("Voulez vous ajoutez un compte épargne ? Oui/Non : ");
								choiceAccountAdding = scan.nextLine();
								if (choiceAccountAdding.equals("Oui")) {
									choiceAccountCreation = 2;
								} else {
									i = 3;
								}

							} else if (c.getCustomerAccount() == null) {
								System.out.print("Voulez vous ajoutez un compte courant ? Oui/Non : ");
								choiceAccountAdding = scan.nextLine();
								if (choiceAccountAdding.equals("Oui")) {
									choiceAccountCreation = 1;
								} else {
									i = 3;
								}
							}

							switch (choiceAccountCreation) {
							case 1:
								System.out.print("Saisissez la date d'aujourd'hui : ");
								String date1 = scan.nextLine();
								System.out.print("Quel montant voulez-vous déposer sur le compte (0,0) : ");
								double deposite1 = scan.nextDouble();
								CurrentAccount cA = new CurrentAccount(deposite1, date1);
								c.setCustomerAccount(cA);
								scan.nextLine();
								System.out.print("Voulez-vous ajouter une carte bleue ? Oui/Non : ");
								String answer = scan.nextLine();

								if (answer.equals("Oui")) {
									System.out.println(
											"Quelle carte voulez-vous ajouter ? \n1 - Visa Electron \n2 - Visa Premier");
									int choiceBankCard = scan.nextInt();
									switch (choiceBankCard) {
									case 1:
										BankCard bC1 = new ElectronVisaCard();
										cA.addCard(bC1);
										break;
									case 2:
										BankCard bC2 = new ElectronVisaCard();
										cA.addCard(bC2);
										break;
									}
								} else {
									System.out.println("PB!");
								}
								break;
							case 2:
								System.out.print("Saisissez la date d'aujourd'hui : ");
								String date2 = scan.nextLine();
								System.out.print("Quel montant voulez-vous déposer sur le compte (0,0) : ");
								double deposite2 = scan.nextDouble();
								scan.nextLine();
								SavingAccount sA = new SavingAccount(deposite2, date2);
								c.setCustomerSaving(sA);
								break;
							}

							i++;
						} while (i < 2);
						System.out.println("\nL'identifiant de ce client est : " + c.getCustomerId() + "\n");

						break;
					case 2: // Reading Client Informations (Id + Accounts + Card)
						System.out.print("Entrez l'identifiant du client dont vous voulez les informations : ");
						int readCustomerId = scan.nextInt();
						System.out.println("\n" + service.read(readCustomerId));
						break;
					case 3: // Modification des données du client
						System.out
								.print("Entrez l'identifiant du client dont vous voulez modifier les informations : ");
						int modifiedCustomerId = scan.nextInt();
						Customer modifiedCustomer = service.read(modifiedCustomerId);
						System.out.print("Voici les informations existantes : \n \n" + modifiedCustomer + "\n");

						int choiceDataCustomer;
						do {
							System.out.println(
									"-----------------------------------\nQue voulez-vous faire : \n1 - modifier l'adresse \n2 - modifier le code Postal \n3 - modifier la ville \n4 - modifier le numéro de téléphone \n5 - Sortir du menu \n-----------------------------------");
							choiceDataCustomer = scan.nextInt();
							scan.nextLine();
							switch (choiceDataCustomer) {
							case 1:
								System.out.print("Entrez la nouvelle adresse :");
								String newAddress = scan.nextLine();
								modifiedCustomer.setAddress(newAddress);
								break;
							case 2:
								String newPostalCode;
								do {
									System.out.print("Entrez le nouveau code postal (5 chiffres): ");
									newPostalCode = scan.nextLine();

								} while (newPostalCode.length() != 5);

								modifiedCustomer.setPostalCode(newPostalCode);
								break;
							case 3:
								System.out.print("Entrez la nouvelle ville : ");
								String newCity = scan.nextLine();
								modifiedCustomer.setCity(newCity);
								break;
							case 4:
								String newPhoneNumber;
								do {
									System.out.print("Entrez le nouveau numéro de téléphone (10 chiffres) : ");
									newPhoneNumber = scan.nextLine();
								} while (newPhoneNumber.length() != 10);
								modifiedCustomer.setPhoneNumber(newPhoneNumber);
								break;
							case 5:
								break;
							default:
								System.out.print("Veuillez entrer un choix de 1 à 5 : \n");
								break;
							}
						} while (choiceDataCustomer != 5);
						System.out.println("Voici les nouvelles informations : \n" + modifiedCustomer);
						break;
					case 4: // Deleting Client (Accounts & card)
						System.out.print("Quel client voulez-vous supprimer : ");
						int deletedCustomerId = scan.nextInt();
						Customer deletedCustomer = service.read(deletedCustomerId);
						scan.nextLine();

						System.out.print(
								"Êtes-vous sûr de vouloir supprimer : \n \n" + deletedCustomer + "\n \nOui/Non : ");
						String answer = scan.nextLine();

						if (answer.equals("Oui")) {
							service.delete(deletedCustomer);
						}
						break;
					case 5:
						break;
					default:
						System.out.print("Veuillez entrer un choix de 1 à 5 : \n");
						break;
					}
				} while (choiceCustomerManagement != 5);
				break;
			case 2:
				int choiceBankOperation;
				do {
					System.out.println(
							"-----------------------\nQue voulez-vous faire ? \n1 - Effectuer un virement \n2 - Simuler un crédit \n3 - Réaliser un audit \n4 - Retour au menu précédent\n-----------------------");
					choiceBankOperation = scan.nextInt();
					switch (choiceBankOperation) {
					case 1:
						System.out
								.print("Entrez l'identifiant du client dont vous voulez débiter le compte courant : ");
						int readDebitedCustomerId = scan.nextInt();
						System.out.println("\n" + service.read(readDebitedCustomerId));

						System.out
								.print("Entrez l'identifiant du client dont vous voulez créditer le compte courant : ");
						int readCreditedCustomerId = scan.nextInt();
						System.out.println("\n" + service.read(readCreditedCustomerId));

						System.out.println("Indiquez le montant de la transaction : ");
						double transactionAmount = scan.nextDouble();

						service.transferMoney(readDebitedCustomerId, readCreditedCustomerId, transactionAmount);

						System.out.println("\n" + service.read(readDebitedCustomerId));
						System.out.println("\n" + service.read(readCreditedCustomerId));

						break;
					case 2:
						System.out.print("Entrez le montant à emprunter souhaité : ");
						double amountToBorrow = scan.nextDouble();

						System.out.println("Sur combien de mois voulez-vous étaler le crédit : ");
						int durationCredit = scan.nextInt();

						System.out.println("Quel est le taux d'intérêt en ce moment : (0 à 100)");
						double interestRate = scan.nextDouble();

						System.out.println(service.simulateCredit(amountToBorrow, durationCredit, interestRate) + "\n");
						break;
					case 3:
						List<Customer> customerBase = service.readAll();
						service.realizeAudit(customerBase);
						break;
					case 4:
						break;
					default:
						System.out.print("Veuillez entrer un choix de 1 à 4 : \n");
						break;
					}
				} while (choiceBankOperation != 4);

				break;
			case 3:
				break;
			default:
				System.out.print("Veuillez entrer un choix de 1 à 3 : \n");
				break;
			}
		} while (choiceTask != 3);

		scan.close();
	}
}
