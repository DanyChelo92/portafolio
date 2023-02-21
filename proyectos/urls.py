from django.urls import path
from . import views

urlpatterns = [
    path('',views.proyecto,name='proyectos'),
    path('herramienta_proyectos/<int:herramienta_id>',views.filtro_proyecto,name='herramienta_proyectos'),
]