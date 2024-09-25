/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author Felippe
 */

public class CadastroPOO2 {
    
     /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	String option = "";
	PessoaFisicaRepo fisRepo = new PessoaFisicaRepo();
	PessoaJuridicaRepo jurRepo = new PessoaJuridicaRepo();

        while (!option.equals("0")) {
		optionMenu();
		try {
			option = reader.readLine();
			switch (option) {
				case "1" ->  {
					System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
					String pessoaType = reader.readLine();
					switch (pessoaType) {
						case "F" ->  {
							PessoaFisica pF = fisEnter(reader);
							fisRepo.inserir(pF);
							System.out.println("Pessoa Fisica cadastrada com sucesso.");
						}
						case "J" ->  {
							PessoaJuridica pJ = jurEnter(reader);
							jurRepo.inserir(pJ);
							System.out.println("Pessoa Juridica cadastrada com sucesso.");
						}
						default -> {
							System.out.println("Tipo invalido de cadastro.");
						}
						
					}
				}
				case "2" ->  {
					System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
					String pessoaType = reader.readLine();
					switch (pessoaType) {
					case "F" ->  {
                        			pessoaAlter(fisRepo, reader);
						System.out.println("Cadastro de Pessoa Fisica alterado.");
					}
					case "J" ->  {
						pessoaAlter(jurRepo, reader);
						System.out.println("Cadastro de Pessoa Juridica alterado.");
					}
					default -> {
						System.out.println("Tipo invalido de cadastro.");
					}
                                	}
				}
				case "3" ->  {
					System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
					String pessoaType = reader.readLine();
					switch (pessoaType) {
						case "F" ->  {
                                        		pessoaDelete(fisRepo, reader);
							System.out.println("Cadastro de Pessoa Fisica excluido.");
						}
						case "J" ->  {
							pessoaDelete(jurRepo, reader);
							System.out.println("Cadastro de Pessoa Juridica excluido.");
						}
						default -> {
							System.out.println("Tipo invalido de cadastro.");
						}
					}
				}
				case "4" ->  {
					System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
					String pessoaType = reader.readLine();
					switch (pessoaType) {
						case "F" ->  {
							pessoaSearch(fisRepo, reader);
							System.out.println("Pessoa Fisica encontrada.");
						}
						case "J" ->  {
							pessoaSearch(jurRepo, reader);
							System.out.println("Pessoa Juridica encontrada.");
						}
						default -> {
							System.out.println("Tipo invalido de cadastro.");
						}
					}
				}
				case "5" ->  {
					System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
					String pessoaType = reader.readLine();
					switch (pessoaType) {
						case "F" ->  {
						pessoaShow(fisRepo);
							System.out.println("Todas as Pessoa Fisicas foram listadas.");
						}
						case "J" ->  {
							pessoaShow(jurRepo);
							System.out.println("Todas as Pessoas Juridicas foram listadas.");
						}
						default -> {
							System.out.println("Tipo invalido de cadastro.");
						}
					}
				}
				case "6" ->  {
					System.out.println("Digite o nome dos arquivos:");
					String filePersist = reader.readLine();
					try {
                                        	fisRepo.persistir(filePersist + ".fisica.bin");
						jurRepo.persistir(filePersist + ".juridica.bin");
						System.out.println("Dados salvos com sucesso.");
					}
					catch (IOException e) {
						System.out.println("Ocorreu um erro ao salvar os dados: " + e.getMessage());
					}
				}
				case "7" ->  {
					System.out.println("Digite o nome dos aqruivos:");
					String fileRestore = reader.readLine();
					try {
						fisRepo.recuperar(fileRestore + ".fisica.bin");
						jurRepo.recuperar(fileRestore + ".juridica.bin");
						System.out.println("Dados recuperados com sucesso.");
					}
					catch (IOException | ClassNotFoundException e) {
						System.out.println("Ocorreu um erro ao recuperar os dados: " + e.getMessage());
					}
				}
				case "0" ->  {
					System.out.println("Programa finalizado.");
				}
				default ->  {
					System.out.println("Opção invalida.");
				}
			}
		}
		catch (IOException e) {
			System.out.println("Ocorreu um erro no processo: " + e.getMessage());
		}
	}
    }
		
	private static PessoaFisica fisEnter(BufferedReader reader) throws IOException {
		System.out.println("Digite o ID da Pessoa Fisica: ");
		int id = Integer.parseInt(reader.readLine());
		System.out.println("Digite o Nome da Pessoa Fisica: ");
		String nome = reader.readLine();
		System.out.println("Digite o CPF da Pessoa Fisica: ");
		String cpf = reader.readLine();
		System.out.println("Digite a Idade da Pessoa Fisica: ");
		int idade = Integer.parseInt(reader.readLine());
		return new PessoaFisica(id, nome, cpf, idade);
	}
	
	private static PessoaJuridica jurEnter(BufferedReader reader) throws IOException {
		System.out.println("Digite o ID da Pessoa Juridica: ");
		int id = Integer.parseInt(reader.readLine());
		System.out.println("Digite o Nome da Pessoa Juridica: ");
		String nome = reader.readLine();
		System.out.println("Digite o CNPJ da Pessoa Juridica: ");
		String cnpj = reader.readLine();
		return new PessoaJuridica(id, nome, cnpj);
	}
	
	private static void pessoaAlter(Object repo, BufferedReader reader) throws IOException {
		System.out.println("Digite o ID da Pessoa a alterar: ");
		int id = Integer.parseInt(reader.readLine());
        switch (repo) {
            case PessoaFisicaRepo pessoaFisicaRepo -> {
                PessoaFisica pF = pessoaFisicaRepo.obter(id);
                if (pF != null) {
                    System.out.println("Nome atual: " + pF.getNome());
                    System.out.print("Novo nome: ");
                    pF.setNome(reader.readLine());
                    System.out.println("CPF atual: " + pF.getCPF());
                    System.out.print("Novo CPF: ");
                    pF.setCPF(reader.readLine());
                    System.out.println("Idade atual: " + pF.getIdade());
                    System.out.print("Nova idade: ");
                    pF.setIdade(Integer.parseInt(reader.readLine()));
                    pessoaFisicaRepo.alterar(pF);
                } else {
                    System.out.println("Pessoa Física não encontrada.");
                }
            }           case PessoaJuridicaRepo pessoaJuridicaRepo -> {
                PessoaJuridica pJ = pessoaJuridicaRepo.obter(id);
                if (pJ != null) {
                    System.out.println("Nome atual: " + pJ.getNome());
                    System.out.print("Novo nome: ");
                    pJ.setNome(reader.readLine());
                    System.out.println("CNPJ atual: " + pJ.getCNPJ());
                    System.out.print("Novo CNPJ: ");
                    pJ.setCNPJ(reader.readLine());
                    pessoaJuridicaRepo.alterar(pJ);
                } else {
                    System.out.println("Pessoa Jurídica não encontrada.");
                }
            }
            default -> {
            }
        }
        }
	
	private static void pessoaDelete(Object repo, BufferedReader reader) throws IOException {
		System.out.println("Digite o ID da Pessoa a deletar: ");
		int id = Integer.parseInt(reader.readLine());
        switch (repo) {
            case PessoaFisicaRepo pessoaFisicaRepo -> pessoaFisicaRepo.excluir(id);
            case PessoaJuridicaRepo pessoaJuridicaRepo -> pessoaJuridicaRepo.excluir(id);
            default -> {
            }
        }
	}
	
	private static void pessoaSearch(Object repo, BufferedReader reader) throws IOException {
		System.out.println("Digite o ID da Pessoa a buscar: ");
		int id = Integer.parseInt(reader.readLine());
        switch (repo) {
            case PessoaFisicaRepo pessoaFisicaRepo -> {
                PessoaFisica pF = pessoaFisicaRepo.obter(id);
                if (pF != null) {
                    System.out.println("ID: " + pF.getID());
                    System.out.println("Nome: " + pF.getNome());
                    System.out.println("CPF: " + pF.getCPF());
                    System.out.println("Idade: " + pF.getIdade());
                } else {
                    System.out.println("Pessoa Fisica não encontrada.");
                }
            }
            case PessoaJuridicaRepo pessoaJuridicaRepo -> {
                PessoaJuridica pJ = pessoaJuridicaRepo.obter(id);
                if (pJ != null) {
                    System.out.println("ID: " + pJ.getID());
                    System.out.println("Nome: " + pJ.getNome());
                    System.out.println("CNPJ: " + pJ.getCNPJ());
                } else {
                    System.out.println("Pessoa Juridica não encontrada.");
                }
            }
            default -> {
            }
        }
	}
	
	private static void pessoaShow(Object repo) {
        switch (repo) {
            case PessoaFisicaRepo pessoaFisicaRepo -> {
                for (PessoaFisica pF : pessoaFisicaRepo.obterTodos()) {
                    System.out.println("ID: " + pF.getID());
                    System.out.println("Nome: " + pF.getNome());
                    System.out.println("CPF: " + pF.getCPF());
                    System.out.println("Idade: " + pF.getIdade());
                }
            }
            case PessoaJuridicaRepo pessoaJuridicaRepo -> {
                for (PessoaJuridica pJ : pessoaJuridicaRepo.obterTodos()) {
                    System.out.println("ID: " + pJ.getID());
                    System.out.println("Nome: " + pJ.getNome());
                    System.out.println("CNPJ: " + pJ.getCNPJ());
                }
            }
            default -> {
            }
        }
	}
	
	private static void optionMenu() {
		System.out.println("=========================");
		System.out.println("1 - Incluir Pessoa");
		System.out.println("2 - Alterar Pessoa");
		System.out.println("3 - Excluir Pessoa");
		System.out.println("4 - Buscar pelo ID");
		System.out.println("5 - Exibir Todos");
		System.out.println("6 - Persistir Dados");
		System.out.println("7 - Recuperar Todos");
		System.out.println("0 - Finalizar Programa");
		System.out.println("=========================");
	}
	
}

