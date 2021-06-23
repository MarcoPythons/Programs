import webbrowser
import wmi
import math
import os
import time
import playsound
import speech_recognition as sr
from gtts import gTTS
from locale import getdefaultlocale

LANGUAGE , encoding = getdefaultlocale()
os.system('color 5')
named_tuple = time.localtime() 
time_string = time.strftime("%H:%M", named_tuple)  #these 2 lines is to get the time
WAKE = "Morgan"
languages = 0 # 0 = English, 1 = Español


print(LANGUAGE)
if LANGUAGE == "es_CL":
    languages = 0

def get_audioENGLISH():  # this return the text what i said
  r = sr.Recognizer()
  with sr.Microphone() as source:
      record = ""
      r.adjust_for_ambient_noise(source)
      audio = r.listen(source)
      record = r.recognize_google(audio, language= 'en')
      return record


def get_audioSPANISH():  # esto devuelve lo que digo
  r = sr.Recognizer()
  with sr.Microphone() as source:
      record = ""
      r.adjust_for_ambient_noise(source)
      audio = r.listen(source)
      record = r.recognize_google(audio, language= 'ES-es')
      return record

def speakENGLISH(text): # this speaks what i said, requires a text 'couse the text is what the bot is going to talk
  tts = gTTS(text=text , lang ='en')
  response = 'response.mp3'
  tts.save(response)
  playsound.playsound(response)
  os.remove(response)

def speakSPANISH(text): # Esta funcion sirve para que hable el bot, el texto es lo que habla el bot
  tts = gTTS(text=text , lang ='ES-es')
  response = 'response.mp3'
  tts.save(response)
  playsound.playsound(response)
  os.remove(response)

def avg(value_list):  # this is to get the cpu and gpu temp
	num = 0
	length = len(value_list)
	for val in value_list:
		num += val
	return num/length
contador = 0 # este contador sirve para que el programa sepa que responder cuando se desactiva
while (True):
  
  while True:
  
    try:
      if languages == 0:
        print("listening.......")
      elif languages == 1:
        print("Escuchando.......")
      
      if languages == 0:
        record = get_audioENGLISH()
      elif languages == 1:
        record = get_audioSPANISH()

      if record.count(WAKE) > 0:
        if languages == 0:

          if contador == 0:
            speakENGLISH("I'm Morgan your assistend, what can I help you?")
            contador += 1
            break
          else:
            speakENGLISH("Yes sir?")
            break
        elif languages == 1:
          if contador == 0:
            speakSPANISH("Soy morgan tu asistente, Como puedo ayudarte?")
            contador += 1
            break
          else:
            speakSPANISH("a su orden señor")
            break

      else:
        speakENGLISH("sorry, I can't understand you said")
      print("reminder, key word : Morgan")
      

    except sr.UnknownValueError:
      print("sorry, I could not understand what you said1")

    except sr.RequestError as e:
      print("Sphinx error; {0}".format(e))
    except PermissionError:
      print("sorry, I could not understand what you said2")
      break
    
  while "Morgan" in record:
    try:
      if languages == 0:
        print("waiting orders.......")
        record_2 = get_audioENGLISH()
        if "time" in record_2:
          speakENGLISH("it is " + time_string )
          
          
        elif  "set language to Spanish" in record_2:
          speakSPANISH("Cambiando el lenguaje a español")
          languages = 1
          contador = 0
          break

        elif "purpose" in record_2:
          speakENGLISH("my purpose is to dominate the world and make cookies")

        elif "are you there" in record_2:
          speakENGLISH(" Yes, I'm here sir")
          

        elif "turn off" in record_2:
          speakENGLISH("shutting down the computer, good night")
          os.system("shutdown /s /t 1");
          

        elif "help" in record_2:
          speakENGLISH("here is the help")
          print("Comands:  ")



        elif "processor" in record_2:
          w = wmi.WMI(namespace="root\\OpenHardwareMonitor")
          sensors = w.Sensor()
          cpu = []
          gpu = 0
          for sensor in sensors:

	          if sensor.SensorType==u'Temperature' and not 'GPU' in sensor.Name:
		          cpu += [float(sensor.Value)]
	          elif sensor.SensorType==u'Temperature' and 'GPU' in sensor.Name:
		          gpu = sensor.Value
          cpu1= format(avg(cpu))
          cpu_in_celcius= float(cpu1) 

          if cpu_in_celcius < 60:
            speakENGLISH("the current temperature in the cpu is "+ str(math.trunc(cpu_in_celcius))+"degrees Celcius." +" it's  not a dangerous temperature ")
          else:
            speakENGLISH("the current temperature in the cpu is "+ str(math.trunc(cpu_in_celcius))+"degrees Celcius." + " is a dangerous temperature")
            

        elif "graphic card" in record_2:
          w = wmi.WMI(namespace="root\\OpenHardwareMonitor")
          sensors = w.Sensor()
          cpu = []
          gpu = 0
          for sensor in sensors:

	          if sensor.SensorType==u'Temperature' and not 'GPU' in sensor.Name:
		          cpu += [float(sensor.Value)]
	          elif sensor.SensorType==u'Temperature' and 'GPU' in sensor.Name:
		          gpu = sensor.Value
          cpu1= format(avg(cpu))
          cpu_in_celcius= float(cpu1)
          if gpu < 60:
            speakENGLISH("the current temperature in the gpu is "+ str(math.trunc(gpu))+"degrees Celcius." + " it's not a dangerous temperature")
            
          else:
            speakENGLISH("the current temperature in the gpu is "+ str(math.trunc(gpu))+"degrees Celcius." + " it's a dangerous temperature")

        elif "take a break" in record_2:
          speakENGLISH("turning off my service, see you soon. don't forget to drink water")
          
          time.sleep(2)
          break

        elif "thank you" in record_2:
          speakENGLISH("You welcome sir")

        elif "Microsoft Edge" in record_2:
          speakENGLISH("Abriendo microsoft edge")
          os.system('"C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"')

        elif "search" in record_2:
          url = "https://www.google.com/?#q="  #searching in google
          Search = record_2.split("h") #capturing the words next to 'h'
          Searching = Search[1:] #only wants to see the word to search
          s = ''.join(Searching) #save the word
          final_string = s
          webbrowser.open(url+final_string)

          speakENGLISH("This is what i found in google for"+final_string )
        else:
          print(record_2)
          speakENGLISH("sorry, ¿What are you saying? ")


      if languages == 1:
        print("Esperando ordenes.......")
        record_2 = get_audioSPANISH()
        if "hora" in record_2:
          speakSPANISH("La hora es " + time_string )
          
          
        elif  "Cambiar el lenguaje a inglés" in record_2:
          speakENGLISH("seting language to english")
          languages = 0
          contador = 0
          break

        elif "propósito" in record_2:
          speakSPANISH("mi propósito es dominar el mundo y hacer galletas")
 
        elif "estás ahí" in record_2:
          speakSPANISH(" si, estoy aqui señor")
        
          

        elif "apaga" in record_2:
          speakSPANISH("apagando el ordenador")
          os.system("shutdown /s /t 1");
          

        elif "ayuda" in record_2:
          speakSPANISH("aqui esta la ayuda")
          print("Comands:   ")



        elif "cpu" in record_2:
          w = wmi.WMI(namespace="root\\OpenHardwareMonitor")
          sensors = w.Sensor()
          cpu = []
          gpu = 0
          for sensor in sensors:

	          if sensor.SensorType==u'Temperature' and not 'GPU' in sensor.Name:
		          cpu += [float(sensor.Value)]
	          elif sensor.SensorType==u'Temperature' and 'GPU' in sensor.Name:
		          gpu = sensor.Value
          cpu1= format(avg(cpu))
          cpu_in_celcius= float(cpu1) 

          if cpu_in_celcius < 60:
            speakSPANISH("la temperatura actual del cpu es  "+ str(math.trunc(cpu_in_celcius))+"grados celcius." +" no es una temperatura peligrosa ")
          else:
            speakSPANISH("la temperatura actual del cpu es  "+ str(math.trunc(cpu_in_celcius))+"grados celcius." +" no es una temperatura peligrosa ")
            

        elif "gpu" in record_2:
          w = wmi.WMI(namespace="root\\OpenHardwareMonitor")
          sensors = w.Sensor()
          cpu = []
          gpu = 0
          for sensor in sensors:

	          if sensor.SensorType==u'Temperature' and not 'GPU' in sensor.Name:
		          cpu += [float(sensor.Value)]
	          elif sensor.SensorType==u'Temperature' and 'GPU' in sensor.Name:
		          gpu = sensor.Value
          cpu1= format(avg(cpu))
          cpu_in_celcius= float(cpu1)
          if gpu < 60:
            speakSPANISH("la temperatura actual del gpu es  "+ str(math.trunc(gpu))+"grados celcius." +" no es una temperatura peligrosa ")
            
          else:
            speakSPANISH("la temperatura actual del gpu es  "+ str(math.trunc(gpu))+"grados celcius." +" no es una temperatura peligrosa ")

        elif "toma un descanso" in record_2:
          speakSPANISH("apagando mis servicios, hasta luego, no te olvides de tomar agua")
          
          time.sleep(2)
          break

        elif "gracias" in record_2:
          speakSPANISH("de nada señor")

        elif "Microsoft Edge" in record_2:
          speakSPANISH("Abriendo microsoft edge")
          os.system('"C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"')

        elif "Busca" or "busca" in record_2:
          url = "https://www.google.com/?q="
          Search = record_2.split("a") 
          Searching = Search[1:] 
          s = ''.join(Searching) 
          final_string = s
          webbrowser.open(url+final_string)

          speakSPANISH("Esto es lo que encontre en google para "+final_string )
        else:
          print(record_2)
          speakSPANISH("perdon, ¿Que fue lo que dijiste? ")
        
    
          

    except sr.UnknownValueError:
        print("sorry, I could not understand what you said1")

    except sr.RequestError as e:
            print("Sphinx error; {0}".format(e))
    except:
      print("taking a break")
      print(record_2)
      time.sleep(2)
    
   
    
       
        
        


