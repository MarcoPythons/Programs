from django.shortcuts import render, redirect, HttpResponse
from registros.models import usuario
from registros.forms import ClienteForm
from django.contrib.auth import login, authenticate


def registration(request):

    data = {
        'form': ClienteForm
    }

    if request.method == 'POST':
        formulario = ClienteForm(request.POST)
        if formulario.is_valid:
            formulario.save()
            username = formulario.cleaned_data['username']
            password = formulario.cleaned_data['password2']
            user = authenticate(username=username, password=password)
            login(request, user)
            return redirect(to='/home/')

    return render(request, "registration.html", data)

