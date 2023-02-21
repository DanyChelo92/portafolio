from django.shortcuts import render,redirect
from .models import Tecnologia, Categoria
from django.views.generic import View
from django.contrib.auth.forms import UserCreationForm,AuthenticationForm
from django.contrib.auth import login,logout,authenticate
from django.contrib import messages
# Create your views here.

def tecnologias(request):   
    categoria=Categoria.objects.all()
    tecnologia=Tecnologia.objects.all()
    return render(request,'home/index.html',{'categorias':categoria,'tecnologias':tecnologia})
