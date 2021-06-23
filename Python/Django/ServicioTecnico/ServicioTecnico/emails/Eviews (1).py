from django.shortcuts import render, redirect, HttpResponse
from django.contrib.auth import login, authenticate






def contact_page(request):
    
    return render (request, 'contact.html') 
