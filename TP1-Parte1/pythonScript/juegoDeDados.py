from multiprocessing import Process
import random
import time
import sys

PLAYER = 5
THROWS = 10

def player(id):
    sys.stdout.write(f"Jugador {id} entra al juego.\n")
    points = 0
    for i in range(THROWS):
        dice = random.randint(1, 6)
        points += dice
        sys.stdout.write(f"Jugador {id} - Lanzamiento {i+1}: {dice}\n")
        time.sleep(random.uniform(0.1, 0.3))
    sys.stdout.write(f"Jugador {id} finaliza con {points} puntos.\n")

def main():
    procesos = []
    for i in range(PLAYER):
        p = Process(target=player, args=(i+1,))
        procesos.append(p)
        p.start()

    for p in procesos:
        p.join()

    print("Todos los jugadores han terminado.")

if __name__ == "__main__":
    main()
