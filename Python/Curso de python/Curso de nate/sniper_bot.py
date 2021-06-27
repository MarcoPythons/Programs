from time import sleep
from requests_html import HTMLSession
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver.common.keys import Keys
from password import user_password




url = "https://www.instagram.com"

session = HTMLSession()

product_page = session.get(url)
driver = webdriver.Chrome()
driver.get(url)
form = None

is_form_loaded = False


while not is_form_loaded:
        try:
            form = driver.find_element_by_id("loginForm")
            is_form_loaded = True
        except NoSuchElementException:
            print("Puessss no esta el formulario...")



_user = form.find_element_by_name("username")
_password = form.find_element_by_name("password")
_user.send_keys("_masterservice_")
_password.send_keys(user_password)
sleep(1)

driver.find_element_by_css_selector('button[type=submit]').click()
sleep(3)
driver.find_element_by_xpath("/html/body/div[1]/section/main/div/div/div/div/button").click()
driver.find_element_by_xpath("/html/body/div[4]/div/div/div/div[3]/button[2]").click()
driver.find_element_by_class_name("xWeGp").click()
sleep(1)
driver.find_element_by_xpath("/html/body/div[1]/section/div/div[2]/div/div/div[1]/div[2]/div/div/div/div/div[1]/a").click()

texto = driver.find_element_by_xpath("/html/body/div[1]/section/div/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/textarea")
for i in range(20):

    texto.send_keys("Holi :)")
    sleep(0.5)
    texto.send_keys(Keys.ENTER)

"""
found = product_page.html.find("#main-buy")

if len(found) > 0:
    driver = webdriver.Firefox()
    driver.get(url_coolmod)
    driver.find_element_by_class_name("confirm").click()
    driver.find_element_by_class_name("accept").click()
    driver.find_element_by_class_name("button-buy").click()
    sleep(1)
    driver.find_element_by_class_name("confirm").click()

    # Esto es por si vuelve a salir la silla razer
    try:
        driver.find_element_by_class_name("confirm").click()
    except NoSuchElementException:
        print("No habia silla razer")

    driver.find_element_by_class_name("button-buy").click()

    is_form_loaded = False
    form = None

    while not is_form_loaded:
        try:
            form = driver.find_element_by_class_name("login100-form")
            is_form_loaded = True
        except NoSuchElementException:
            print("Puessss no esta el formulario...")

    email = form.find_element_by_name("jform[email]")
    password = form.find_element_by_name("jform[password]")

    email.send_keys("nate@nate.com")
    password.send_keys("megustarazer")

    driver.find_element_by_class_name("login100-form-btn").click()
"""
