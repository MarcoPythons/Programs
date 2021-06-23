import os
import random

POS_X = 0
POS_Y = 1

MAP_WIDTH = 20
MAP_HEIGHT = 15

my_potition = [0, 0]
map_objects = []
tail_length = 0

game_over =  False
end_game = False
tail = []
# Objects in the map


position = [random.randint(1, (MAP_WIDTH-1)), random.randint(1, (MAP_HEIGHT-1))]

if position not in map_objects and my_potition != position:
   map_objects.append(position)

# main loop
while not end_game:

    print("+" + "-" * MAP_WIDTH * 3 + "+")
    for y in range(MAP_HEIGHT):
        print("|", end="")

        for x in range(MAP_WIDTH):

            chart_to_draw = " "
            object_in_cell = None
            tail_in_cell = None

            for map_object in map_objects:
                if map_object[POS_X] == x and map_object[POS_Y] == y:
                    chart_to_draw = "*"
                    object_in_cell = map_object

            for tail_piece in tail:
                if tail_piece[POS_X] == x and tail_piece[POS_Y] == y:
                    chart_to_draw = "="
                    tail_in_cell = tail_piece

            if my_potition[POS_X] == x and my_potition[POS_Y] == y:
                chart_to_draw = "+"

                if object_in_cell:
                    map_objects.remove(object_in_cell)
                    position = [random.randint(1, (MAP_WIDTH-1)), random.randint(1, (MAP_HEIGHT-1))]

                    if position not in map_objects and my_potition != position:
                        map_objects.append(position)
                    tail_length += 1

                if tail_in_cell:
                    game_over = True
                    

            print(" {} ".format(chart_to_draw), end="")
        print("|")

    print("+" + "-" * MAP_WIDTH * 3 + "+")

    if len(map_objects) == 0:
        print("Has ganado! Gracias por jugar")
        end_game = True
    if game_over:
        print("Has perdido")
        end_game = True
    # ask user where to move

    import readchar

    direction = readchar.readchar().decode()

    if direction == "w":
        tail.insert(0, my_potition.copy())
        tail = tail[:tail_length]
        my_potition[POS_Y] -= 1
        my_potition[POS_Y] %= MAP_HEIGHT

    elif direction == "s":
        tail.insert(0, my_potition.copy())
        tail = tail[:tail_length]
        my_potition[POS_Y] += 1
        my_potition[POS_Y] %= MAP_HEIGHT

    elif direction == "a":
        tail.insert(0, my_potition.copy())
        tail = tail[:tail_length]
        my_potition[POS_X] -= 1
        my_potition[POS_X] %= MAP_WIDTH

    elif direction == "d":
        tail.insert(0, my_potition.copy())
        tail = tail[:tail_length]
        my_potition[POS_X] += 1
        my_potition[POS_X] %= MAP_WIDTH

    elif direction == "q":
        end_game = True
    os.system('cls')
