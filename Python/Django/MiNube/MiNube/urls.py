from django.contrib import admin
from django.urls import path
from MiNube import views
from django.conf.urls.static import static
from django.conf import settings
from registros import Rviews
urlpatterns = [
    path('admin/', admin.site.urls),
    path('home/', views.home, name = 'home'),
    path('registration/', Rviews.registration, name = 'registration'), 
] + static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)
