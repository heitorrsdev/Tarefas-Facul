# Gerenciar a interação com o usuário:
# O Controller pode lidar com a entrada do terminal,
# interpretar os comandos do usuário e passar os dados para
# o Model para realizar as operações CRUD.
# chama o service

import service

userType = service.getUserType()
produtos = {}

def runStore():
    if userType == 'Caixa':
        service.showProductsMenu()
