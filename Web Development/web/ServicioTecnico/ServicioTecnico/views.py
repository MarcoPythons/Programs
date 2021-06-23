from django.shortcuts import render, redirect, HttpResponse
from django.contrib.auth import login, authenticate




def pag_principal(request):
    
    return render(request, 'body.html')



