from django.contrib import admin
from registros.models import usuario



class ClienteAdmin(admin.ModelAdmin):
    list_display=("username" , "email" )
    search_fields =("username",)

admin.site.register(usuario, ClienteAdmin)
