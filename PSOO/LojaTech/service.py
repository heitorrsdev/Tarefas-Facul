def getUserType():
    while True:
        print('=' * 50)
        print('Selecione o tipo de usuário:')
        try:
            uType = int(input('[1] Cliente\n[2] Caixa\n[3] Gerente\nOpção: '))
            if uType == 1:
                return 'Cliente'
            elif uType == 2:
                return 'Caixa'
            elif uType == 3:
                return 'Gerente'
            else:
                print("Opção inválida! Tente novamente.")
        except ValueError:
            print("Entrada inválida! Por favor, digite um número.")


def showProductsMenu():
    produtos = []

    while True:
        print('=' * 50)
        try:
            opt = int(input('[1] Adicionar produto\n[2] Remover produto\n[3] Listar produtos\n[4] Sair\nOpção: '))
            if opt == 1:
                nome = input('Nome:\n')
                preco = float(input('Preço:\n'))
                qtd = int(input('Quantidade:\n'))
                produtos.append({'nome': nome, 'preco': preco, 'qtd': qtd})
                print(f"Produto '{nome}' adicionado com sucesso!")
            elif opt == 2:
                nome = input('Produto a deletar:\n')
                encontrado = False
                for prod in produtos:
                    if prod['nome'].lower() == nome.lower():
                        produtos.remove(prod)
                        print(f"Produto '{nome}' removido com sucesso!")
                        encontrado = True
                        break
                if not encontrado:
                    print(f"Produto '{nome}' não encontrado.")
            elif opt == 3:
                if produtos:
                    print("Lista de produtos:")
                    for i, prod in enumerate(produtos, start=1):
                        print(f"{i}. Nome: {prod['nome']}, Preço: R${prod['preco']:.2f}, Quantidade: {prod['qtd']}")
                else:
                    print("Nenhum produto cadastrado.")
            elif opt == 4:
                print("Encerrando o menu de produtos.")
                break
            else:
                print("Opção inválida! Tente novamente.")
        except ValueError:
            print("Entrada inválida! Por favor, digite um número válido.")
