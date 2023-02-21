from django.shortcuts import render
from .models import Proyecto,Herramienta
# Create your views here.

def proyecto(request):
    proyecto=Proyecto.objects.all()
    herramienta=Herramienta.objects.all()
    return render(request,'proyectos/proyectos.html',{'herramientas':herramienta,'proyectos':proyecto})

def filtro_proyecto(request,herramienta_id):
    herramienta_todas= Herramienta.objects.all()
    herramienta=Herramienta.objects.get(id=herramienta_id)
    proyecto=Proyecto.objects.filter(herramientas=herramienta)
    return render(request,'herramienta/herramienta_proyectos.html',{'herramientas':herramienta,'proyectos':proyecto,'herramientas_todas':herramienta_todas})


