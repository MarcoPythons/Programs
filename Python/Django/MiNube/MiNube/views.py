from django.shortcuts import render, redirect, HttpResponse
from django.contrib.auth import login, authenticate








def home(request):
    


    return render(request, 'index.html')
