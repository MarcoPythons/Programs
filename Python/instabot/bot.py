from instabot import  Bot
import time 
import os


mi_bot = Bot()
mi_bot.login(username='_m4ku_', password=' ')



local_time = time.localtime()
time_in_seconds = time.strftime("%S", local_time)
contador = 0
while True:
    for segundos in range(60):
        os.system('cls')
        print(f'{segundos}')
        time.sleep(1)
        mi_bot.send_message('Te amo wey','missasinfonia', segundos)
         
                   































