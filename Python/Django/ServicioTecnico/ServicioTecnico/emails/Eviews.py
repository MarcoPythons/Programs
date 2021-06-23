from django.shortcuts import render, redirect, HttpResponse 
from django.contrib.auth import login, authenticate
from emails.models import cliente
from emails.forms import ClienteForm 

from django.core.mail import send_mail
from django.conf import settings


"""
def send_mail(request):
    if request.method == 'POST':
         nombre = request.POST["nombre"]
         mensaje = request.POST["mensaje"]
         mail = request.POST["email"]
  
         email_from = settings.EMAIL_HOST_USER

         recipient_list = ['marco.xdxdx3@gmail.com']

         send_mail(nombre, mensaje, email_from, recipient_list)
    return render (request, 'contact.html')

def contact_page(request):
    
    data= {
            'form':ClienteForm
            }
    if request.method == 'POST':
          formulario= ClienteForm(request.POST)
          if formulario.is_valid:
                 formulario.save()
                 return redirect(to='/home/')


    return render (request, 'contact.html', data) 
       

"""
         

def contact_page(request):
    
    data= {
            'form':ClienteForm
            }

    if request.method == 'POST':
         nombre = request.POST["nombre"]
         mensaje = request.POST["mensaje"]
         mail = request.POST["email"]
  
         message = nombre + " ha enviado para contratar los servicios. " + "Mensaje: " + mensaje + " " + "Email del cliente: " + mail 
         email_from = settings.EMAIL_HOST_USER

         recipient_list = ['marco.xdxdx3@gmail.com']

         send_mail(nombre, message, email_from, recipient_list)



         formulario= ClienteForm(request.POST)
         if formulario.is_valid:
             formulario.save()
             return redirect(to='/home/')


    return render (request, 'contact.html', data)   
