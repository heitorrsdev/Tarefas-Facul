import controller

opt = True
while opt != 0:
    opt = int(input('[0] Sair\n[1] Continuar\n'))
    if opt == 0: break
    controller.runStore()

