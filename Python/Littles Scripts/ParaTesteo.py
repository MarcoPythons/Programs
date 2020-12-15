import webbrowser
import wmi
import math
import os
import time
import playsound
import speech_recognition as sr
from gtts import gTTS


def get_audioSPANISH():  # this return the text what i said
  r = sr.Recognizer()
  with sr.Microphone() as source:
      record = ""
      r.adjust_for_ambient_noise(source)
      audio = r.listen(source)
      record = r.recognize_google(audio, language= 'ES-es')
      return record

def speakENGLISH(text): # this speaks what i said, requires a text 'couse the text is what the bot is going to talk
  tts = gTTS(text=text , lang ='Es-es')
  response = 'response.mp3'
  tts.save(response)
  playsound.playsound(response)
  os.remove(response)


print("escuchando")
record = get_audioSPANISH()

print("lo que dijiste fue " + record)
speakENGLISH(record)