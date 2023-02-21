from django.urls import path
from . import views
from django.conf import settings
from django.conf.urls.static import static

urlpatterns = [
    path('',views.VistaRegistro.as_view(),name='registro'),  
    path('cerrar_sesion/',views.cerrar_sesion,name='cerrar_sesion'),
    path('login/',views.log_in,name='login'), 
]

urlpatterns+=static(settings.MEDIA_URL,document_root=settings.MEDIA_ROOT)